package GetTestCase.LessonCreatFlow;

import com.mizholdings.util.JsonFuncUtil;
import com.mizholdings.util.javabean.LessonEditBean;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 编辑课程
 */
public class LessonEditTestCase extends BaseTestCase {

    @BeforeClass
    public void beforeClass() {
        LessonEditBean lessonEditBean = new LessonEditBean();
        teacher.getWeb().lessonAgent().edit(lessonId, lessonEditBean.build());
    }


    @Test(description = "教师后台 课程列表")
    public void teacher_lesson_list_test() {
        teacher_list(lessonId).ifPresent(i -> {
            ass_tls(STATE_LESSON_NO_APPLY, i.getString("state"));
        });
    }

    @Test(description = "教师后台 课程详情")
    public void teacher_lessonInfo_test() {
        Info info = teacher_getLessonInfoById(lessonId);

        info.lessonInfo.ifPresent(i -> {
            ass_tlp(PUB_NO_APPLY, i.getString("pubType"));
        });

        info.array.flatMap(array -> JsonFuncUtil.extract(array, classroomId, "classroomId")).ifPresent(i -> {
            ass_tcp(PUB_APPLY_FALSE, i.getString("pubType"));
        });
    }


    @Test(description = "管理员 课程列表")
    public void superAdmin_lesson_list_test() {
        superAdmin_list(lessonId).ifPresent(i -> {
            ass_sls(STATE_LESSON_NO_APPLY, i.getString("state"));
        });
    }

    @Test(description = "管理员 课程详情")
    public void superAdmin_lessonInfo_test() {
        Info info = superAdmin_getLessonInfoById(lessonId);

        info.lessonInfo.ifPresent(i -> {
            ass_slp(PUB_NO_APPLY, i.getString("pubType"));
        });

        info.array.flatMap(array -> JsonFuncUtil.extract(array, classroomId, "classroomId")).ifPresent(i -> {
            ass_scp(PUB_APPLY_FALSE, i.getString("pubType"));
        });
    }


}
