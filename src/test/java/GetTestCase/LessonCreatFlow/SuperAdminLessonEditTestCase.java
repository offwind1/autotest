package GetTestCase.LessonCreatFlow;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.util.JsonFuncUtil;
import com.mizholdings.util.SampleAssert;
import com.mizholdings.util.javabean.LessonEditBean;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SuperAdminLessonEditTestCase extends BaseTestCase {
    LessonEditBean lessonEditBean;

    @BeforeClass
    public void beforeClass() {
        // TODO 修改课程信息，是否有效
        lessonEditBean = new LessonEditBean();
        lessonEditBean.addGradeId(Global_enum.GRADEID.FIVE); //5
        lessonEditBean.addGradeId(Global_enum.GRADEID.NINE); //9
        lessonEditBean.setClassroomCount(3);
        lessonEditBean.setCustRelease(Global_enum.CustRelease.CLASS_LIB);
        lessonEditBean.setLesson_type_id(Global_enum.LESSON_TYPE_ID.MAT);//数学
        lessonEditBean.setLessonName("新修改后的名称");
        lessonEditBean.setStartDay(1);

        JSONObject object = superAdmin.getManage().lessonAgent().edit(lessonId, lessonEditBean);
        SampleAssert.assertCode200(object);
    }

    @Test(description = "管理员 课程详情")
    public void superAdmin_lessonInfo_test() {
        Info info = superAdmin_getLessonInfoById(lessonId);
        info_assert(info);
    }

    @Test(description = "教师 课程详情")
    public void teacher_lessonInfo_test() {
        Info info = teacher_getLessonInfoById(lessonId);
        info_assert(info);
    }

    public void info_assert(Info info) {
        info.lessonInfo.ifPresent(i -> {
            //年级检测
            String gradeIds = i.getString("gradeIds");
            String gradeNames = i.getString("gradeNames");

            lessonEditBean.getGrade().forEach(gradeId -> {
                assert gradeIds.contains(gradeId.value) : "gradeIds 值" + gradeIds + " 中不存在" + gradeId.value;
                assert gradeNames.contains(gradeId.gradeName) : "gradeNames 值" + gradeNames + " 中不存在" + gradeId.gradeName;
            });

            //学科检测
            String lessonTypeId = i.getString("lessonTypeId");
            String lessonTypeName = i.getString("lessonTypeName");
            Global_enum.LESSON_TYPE_ID now_type = lessonEditBean.getLesson_type_id();
            assert lessonTypeId.equals(now_type.value) : "学科id不正确 应是" + now_type.value + " 实际是" + lessonTypeId;
            assert lessonTypeName.equals(now_type.name) : "学科name不正确 应是" + now_type.name + " 实际是" + lessonTypeName;

            //custRelease
            String custRelease = i.getString("custRelease");
            Global_enum.CustRelease now_cust = lessonEditBean.getCustRelease();
            assert now_cust.value.equals(custRelease) : "custRelease不正确 应是" + now_cust.value + " 实际是" + custRelease;

            //lessonName
            String lessonName = i.getString("lessonName");
            String now_lessonName = lessonEditBean.getLessonName();
            assert now_lessonName.equals(lessonName) : "lessonName不正确 应是" + now_lessonName + " 实际是" + lessonName;

        });

        info.array.ifPresent(array -> {
            assert array.size() == 3 : "课时数量不正确";
            array.forEach(i -> {
                JSONObject o = (JSONObject) i;
                assert PUB_APPLY_PASS.equals(o.getString("pubType")) :
                        "管理员添加的课时应该都是通过审核的，但该课时状态为" + o.getString("pubType");

                String teacherId = o.getString("teacherId");
                assert teacher.getUserId().equals(teacherId) : "课时的主讲人不正确";
            });
        });
    }


}
