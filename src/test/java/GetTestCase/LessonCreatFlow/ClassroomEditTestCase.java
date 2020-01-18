package GetTestCase.LessonCreatFlow;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.Common;
import com.mizholdings.util.JsonFuncUtil;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import com.mizholdings.util.javabean.LessonEditBean;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 编辑课时
 */
public class ClassroomEditTestCase extends BaseTestCase {

    @BeforeClass
    public void beforeClass() {
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
    }


    @Test(description = "教师后台 课程列表")
    public void teacher_lesson_list_test() {
        teacher_list(lessonId).ifPresent(i -> {
            ass_tls(STATE_CLASSROOM_NO_APPLY, i.getString("state"));
        });
    }

    @Test(description = "教师后台 课程详情")
    public void teacher_lessonInfo_test() {
        Info info = teacher_getLessonInfoById(lessonId);

        info.lessonInfo.ifPresent(i -> {
            ass_tlp(PUB_APPLY_PASS, i.getString("pubType"));
        });

        info.array.flatMap(array -> JsonFuncUtil.extract(array, classroomId, "classroomId")).ifPresent(i -> {
            ass_tcp(PUB_NO_APPLY, i.getString("pubType"));
        });
    }


    @Test(description = "管理员 课程列表")
    public void superAdmin_lesson_list_test() {
        superAdmin_list(lessonId).ifPresent(i -> {
            ass_sls(STATE_CLASSROOM_NO_APPLY, i.getString("state"));
        });
    }

    @Test(description = "管理员 课程详情")
    public void superAdmin_lessonInfo_test() {
        Info info = superAdmin_getLessonInfoById(lessonId);

        info.lessonInfo.ifPresent(i -> {
            ass_slp(PUB_APPLY_PASS, i.getString("pubType"));
        });

        info.array.flatMap(array -> JsonFuncUtil.extract(array, classroomId, "classroomId")).ifPresent(i -> {
            ass_scp(PUB_NO_APPLY, i.getString("pubType"));
        });
    }

}
