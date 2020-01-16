package superAdminTest;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class applyTestCase {

    private Teacher teacher = Global.init().getTeacher();
    private SuperAdmin superAdmin = Global.init().getSuperAdmin();
    private String lessonId;
    private String classroomId;

    @BeforeClass
    public void beforeClass() {
        lessonId = teacher.newLessonAndGetLessonId(1);
        JSONObject object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);
        classroomId = Common.random(object.getJSONObject("data").getJSONArray("classroomList")).getString("classroomId");
    }

    @Test(description = "课程提交审核——未通过——状态：审核未通过")
    public void apply_lesson_test() {
        JSONObject object = teacher.getWeb().lessonAgent().apply(lessonId);
        SampleAssert.assertCode200(object);

        object = superAdmin.getManage().lessonAgent().lessonReply(lessonId, Global_enum.PUB_TYPE.NO_PASS);
        SampleAssert.assertCode200(object);

        object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);

        JSONObject lessonInfo = object.getJSONObject("data").getJSONObject("lessonInfo");
        JSONArray array = object.getJSONObject("data").getJSONArray("classroomList");

        // pubType
        throwExceptionIsFalse(lessonInfo.getString("pubType").equals(Global_enum.PUB_TYPE.NO_PASS.value), "pubType不正确");
    }

    @Test(description = "编辑课程——状态：未提交审核", dependsOnMethods = {"apply_lesson_test"})
    public void edit_lesson_test() {
        LessonEditBean lessonEditBean = new LessonEditBean();
        Parameter parameter = lessonEditBean.build();
        parameter.add("lessonId", lessonId);

        JSONObject object = teacher.getWeb().lessonAgent().edit(parameter);
        SampleAssert.assertCode200(object);

        object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);

        JSONObject lessonInfo = object.getJSONObject("data").getJSONObject("lessonInfo");
        JSONArray array = object.getJSONObject("data").getJSONArray("classroomList");

        // pubType
        throwExceptionIsFalse(lessonInfo.getString("pubType").equals(Global_enum.PUB_TYPE.NO_APPLY.value), "pubType不正确");
    }

    @Test(description = "提交审核——管理员通过——状态：未提交审核", dependsOnMethods = {"edit_lesson_test"})
    public void apply_pass_lesson_test() {
        ComboUtil.applyLesson(superAdmin, teacher, lessonId);

        JSONObject object = teacher.getWeb().lessonAgent().getLessonInfoById(lessonId);

        JSONObject lessonInfo = object.getJSONObject("data").getJSONObject("lessonInfo");
        JSONArray array = object.getJSONObject("data").getJSONArray("classroomList");

        // pubType
        throwExceptionIsFalse(lessonInfo.getString("pubType").equals(Global_enum.PUB_TYPE.PASS.value), "pubType不正确");
    }


    // 编辑课时——课时状态待提交
    // 提交课时——不通过——
    // 提交课时——通过——


    public void throwExceptionIsFalse(Boolean flag, String msg) {
        if (!flag) {
            throw new RuntimeException(msg);
        }
    }

}
