package superAdminTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
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

/**
 * 管理员可以直接编辑课程，
 */
public class lessonEditTestCase {

    private Teacher teacher = Global.init().getTeacher();
    private SuperAdmin superAdmin = Global.init().getSuperAdmin();
    private String lessonId;

    @BeforeClass
    public void BeforeClass() {
        lessonId = teacher.newLessonAndGetLessonId(2);
        ComboUtil.applyLesson(superAdmin, teacher, lessonId);
    }


    @Test(description = "管理员修改课程数量，新增的课程应该默认状态为通过审核")
    public void pubType_is_9() {
        JSONObject object = superAdmin.getManage().lessonAgent().edit(lessonId, 4);
        SampleAssert.assertCode200(object);

        object = superAdmin.getManage().lessonAgent().getLessonInfoById(lessonId);
        object.getJSONObject("data").getJSONArray("classroomList").stream().forEach(i -> {
            JSONObject o = (JSONObject) i;
            SampleAssert.assertEquals(o, "pubType", "9");
        });
    }

    @Test(description = "管理员修改用户课程信息，是否有效")
    public void edit_info() {
        // TODO 修改课程信息，是否有效
        LessonEditBean lessonEditBean = new LessonEditBean();
        lessonEditBean.addGradeId(Global_enum.GRADEID.FIVE); //5
        lessonEditBean.addGradeId(Global_enum.GRADEID.NINE); //9
        lessonEditBean.setClassroomCount(6);
//        lessonEditBean.setFree(Global_enum.FREE_TYPE.NO_FREE);
        lessonEditBean.setCustRelease(Global_enum.CustRelease.CLASS_LIB);
        lessonEditBean.setLesson_type_id(Global_enum.LESSON_TYPE_ID.MAT);//数学
        lessonEditBean.setLessonName("新修改后的名称");
        lessonEditBean.setStartDay(1);

        superAdmin.getManage().lessonAgent().edit(lessonId, lessonEditBean);
        JSONObject object = superAdmin.getManage().lessonAgent().getLessonInfoById(lessonId);
        SampleAssert.assertCode200(object);

        JSONObject lessonInfo = object.getJSONObject("data").getJSONObject("lessonInfo");
        JSONArray classroomList = object.getJSONObject("data").getJSONArray("classroomList");

        //ClassroomCount
        if (classroomList.size() != lessonEditBean.getClassroomCount()) {
            throw new RuntimeException("课程数量不正确");
        }

        //custRelease
        if (!lessonInfo.getString("custRelease").equals(lessonEditBean.getCustRelease().value)) {
            throw new RuntimeException("custRelease不正确");
        }

        // Lesson_type_id
        if (!lessonInfo.getString("lessonTypeId").equals(lessonEditBean.getLesson_type_id().value)) {
            throw new RuntimeException("lessonTypeId不正确");
        }
        if (!lessonInfo.getString("lessonTypeName").equals(lessonEditBean.getLesson_type_id().name)) {
            throw new RuntimeException("lessonTypeName不正确");
        }

        // lesson_name
        if (!lessonInfo.getString("lessonName").equals(lessonEditBean.getLessonName())) {
            throw new RuntimeException("lessonName不正确");
        }

        //Grade
        String gradeIds = lessonInfo.getString("gradeIds");
        String gradeNames = lessonInfo.getString("gradeNames");
        for (Global_enum.GRADEID gra : lessonEditBean.getGrade()) {
            if (!gradeIds.contains(gra.value)) {
                throw new RuntimeException(gra.value + "不存在gradeIds中");
            }
            if (!gradeNames.contains(gra.gradeName)) {
                throw new RuntimeException(gra.gradeName + "不存在gradeNames中");
            }
        }

        // teacherId
        String userId = teacher.getUserId();
        Common.run(classroomList, i -> {
            JSONObject o = (JSONObject) i;
            if (!userId.equals(o.getString("teacherId"))) {
                throw new RuntimeException("课程教师不正确");
            }
        });

    }


}
