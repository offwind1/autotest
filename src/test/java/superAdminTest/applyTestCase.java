package superAdminTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.Common;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import com.mizholdings.util.javabean.LessonEditBean;
import lombok.Data;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

public class applyTestCase {

    private Teacher teacher = Global.init().getTeacher();
    private SuperAdmin superAdmin = Global.init().getSuperAdmin();
    private String lessonId;
    private String classroomId;

    //state
    //0 未提交审核
    //2 课节待审核
    //3 审核以通过
    //4 课程未通过
    //10 课节未提交

    @BeforeClass
    public void beforeClass() {
        lessonId = teacher.newLessonAndGetLessonId(1);
        JSONObject object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);
        classroomId = Common.random(object.getJSONObject("data").getJSONArray("classroomList")).getString("classroomId");
    }

    @Test(description = "1课程提交审核——未通过——状态：审核未通过")
    public void apply_lesson_test() {
        JSONObject object = teacher.getWeb().lessonAgent().apply(lessonId);
        SampleAssert.assertCode200(object);

        object = superAdmin.getManage().lessonAgent().lessonReply(lessonId, Global_enum.PUB_TYPE.NO_PASS);
        SampleAssert.assertCode200(object);

        check("4", Global_enum.PUB_TYPE.NO_PASS, Global_enum.PUB_TYPE.NO_PASS);
    }

    @Test(description = "2编辑课程——状态：未提交审核", dependsOnMethods = {"apply_lesson_test"})
    public void edit_lesson_test() {
        LessonEditBean lessonEditBean = new LessonEditBean();
        Parameter parameter = lessonEditBean.build();
        parameter.add("lessonId", lessonId).add("apply", "0");

        JSONObject object = teacher.getWeb().lessonAgent().edit(parameter);
        SampleAssert.assertCode200(object);

        check("0", Global_enum.PUB_TYPE.NO_APPLY, Global_enum.PUB_TYPE.NO_PASS);
    }

    @Test(description = "3提交审核——管理员通过——状态：审核通过", dependsOnMethods = {"edit_lesson_test"})
    public void apply_pass_lesson_test() {
        ComboUtil.applyLesson(superAdmin, teacher, lessonId);

        JSONObject object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);
        SampleAssert.assertCode200(object);

        check("3", Global_enum.PUB_TYPE.PASS, Global_enum.PUB_TYPE.PASS);
    }

    // 编辑课时——课时状态待提交
    @Test(description = "4编辑课时——课时状态待提交", dependsOnMethods = {"apply_pass_lesson_test"})
    public void edit_classroom_test() {
        Parameter parameter = Parameter.creat()
                .add("lessonId", lessonId)
                .add("classroomId", classroomId)
                .add("classroomName", "课时1")
                .add("interaction", "4")
                .add("startTime", Common.getNowTime())
                .add("coursewareId", "")
                .add("timeLong", "0")
                .add("classroomOrdery", "0")
                .add("classroomRemark", "")
                .add("teacherId", teacher.getUserId());

        JSONObject object = teacher.getWeb().classroomAgent().edit(parameter);
        SampleAssert.assertCode200(object);

        check("10", Global_enum.PUB_TYPE.PASS, Global_enum.PUB_TYPE.NO_APPLY);
    }

    // 提交课时——课时待审核
    @Test(description = "5提交课时——课时待审核", dependsOnMethods = {"edit_classroom_test"})
    public void apply_classroom_test() {

        JSONObject object = teacher.getWeb().classroomAgent().apply(Parameter.creat().add("classroomId", classroomId));
        SampleAssert.assertCode200(object);

        check("2", Global_enum.PUB_TYPE.PASS, Global_enum.PUB_TYPE.APPLY);
    }

    //课时审核不通过
//    @Test(description = "6课时审核不通过", dependsOnMethods = {"apply_classroom_test"})
//    public void no_apply_classroom_test() {
////        JSONObject object = superAdmin.getManage().classroomAgent().reply();
//        check("2", Global_enum.PUB_TYPE.PASS, Global_enum.PUB_TYPE.APPLY);
//    }



    // 提交课时——通过——


    private void check(String state, Global_enum.PUB_TYPE pub_type, final Global_enum.PUB_TYPE class_pub_type) {
        //教师端
        teacher_list(lessonId).ifPresent(i -> {
            assert i.getString("state").equals(state) : "教师端 课堂状态不正确";
        });

        Info info = teacher_getLessonInfoById(lessonId);
        info.lessonInfo.ifPresent(i -> {
            assert pub_type.value.equals(i.getString("pubType")) : "教师端 课堂pubType不正确";
        });

        info.array.ifPresent(array -> {
            JSONObject object = Common.filder(array, classroomId, "classroomId");
            assert class_pub_type.value.equals(object.getString("pubType")) : "教师端 课时pubType不正确";
        });

        //管理员
        superAdmin_list(lessonId).ifPresent(i -> {
            assert i.getString("state").equals(state) : "管理员 课堂状态不正确";
        });

        info = superAdmin_getLessonInfoById(lessonId);
        info.lessonInfo.ifPresent(i -> {
            assert pub_type.value.equals(i.getString("pubType")) : "管理员 课堂pubType不正确";
        });

        info.array.ifPresent(array -> {
            JSONObject object = Common.filder(array, classroomId, "classroomId");
            assert class_pub_type.value.equals(object.getString("pubType")) : "教师端 课时pubType不正确";
        });
    }

    private Optional<JSONObject> teacher_list(String lessonId) {
        JSONObject object = teacher.getWeb().lessonAgent().list();
        return Optional.ofNullable(Common.filder(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId"));
    }

    private Info teacher_getLessonInfoById(String lessonId) {
        JSONObject object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);

        JSONObject lessonInfo = object.getJSONObject("data").getJSONObject("lessonInfo");
        JSONArray array = object.getJSONObject("data").getJSONArray("classroomList");

        return new Info(lessonInfo, array);
    }

    private Optional<JSONObject> superAdmin_list(String lessonId) {
        JSONObject object = superAdmin.getManage().lessonAgent().list();
        return Optional.ofNullable(Common.filder(object.getJSONObject("data").getJSONArray("list"), lessonId, "lessonId"));
    }

    private Info superAdmin_getLessonInfoById(String lessonId) {
        JSONObject object = superAdmin.getManage().lessonAgent().getLessonInfoById(lessonId);

        JSONObject lessonInfo = object.getJSONObject("data").getJSONObject("lessonInfo");
        JSONArray array = object.getJSONObject("data").getJSONArray("classroomList");

        return new Info(lessonInfo, array);
    }


    public void throwExceptionIsFalse(Boolean flag, String msg) {
        if (!flag) {
            throw new RuntimeException(msg);
        }
    }

    @Data
    private class Info {
        private Optional<JSONObject> lessonInfo;
        private Optional<JSONArray> array;

        public Info(JSONObject lessonInfo, JSONArray array) {
            this.lessonInfo = Optional.ofNullable(lessonInfo);
            this.array = Optional.ofNullable(array);
        }
    }

}
