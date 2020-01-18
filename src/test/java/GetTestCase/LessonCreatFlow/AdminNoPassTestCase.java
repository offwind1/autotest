package GetTestCase.LessonCreatFlow;

import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.util.JsonFuncUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 管理员 不通过课程审核
 */
public class AdminNoPassTestCase extends BaseTestCase {

    @BeforeClass
    public void beforeClass() {
        superAdmin.getManage().lessonAgent().lessonReply(lessonId, Global_enum.PUB_TYPE.NO_PASS);
    }

    @Test(description = "教师后台 课程列表")
    public void teacher_lesson_list_test() {
        teacher_list(lessonId).ifPresent(i -> {
            ass_tls(STATE_LESSON_APPLY_FALSE, i.getString("state"));
        });
    }

    @Test(description = "教师后台 课程详情")
    public void teacher_lessonInfo_test() {
        Info info = teacher_getLessonInfoById(lessonId);

        info.lessonInfo.ifPresent(i -> {
            ass_tlp(PUB_APPLY_FALSE, i.getString("pubType"));
        });

        info.array.flatMap(array -> JsonFuncUtil.extract(array, classroomId, "classroomId")).ifPresent(i -> {
            ass_tcp(PUB_APPLY_FALSE, i.getString("pubType"));
        });
    }


    @Test(description = "管理员 课程列表")
    public void superAdmin_lesson_list_test() {
        superAdmin_list(lessonId).ifPresent(i -> {
            ass_sls(STATE_LESSON_APPLY_FALSE, i.getString("state"));
        });
    }

    @Test(description = "管理员 课程详情")
    public void superAdmin_lessonInfo_test() {
        Info info = superAdmin_getLessonInfoById(lessonId);

        info.lessonInfo.ifPresent(i -> {
            ass_slp(PUB_APPLY_FALSE, i.getString("pubType"));
        });

        info.array.flatMap(array -> JsonFuncUtil.extract(array, classroomId, "classroomId")).ifPresent(i -> {
            ass_scp(PUB_APPLY_FALSE, i.getString("pubType"));
        });
    }


}
