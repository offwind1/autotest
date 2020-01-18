package GetTestCase.LessonCreatFlow;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.Common;
import com.mizholdings.util.JsonFuncUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 新建课程
 */
public class CreatLessonTestCase extends BaseTestCase {


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

    @Test(description = "教师后台 课程列表")
    public void teacher_lesson_list_test() {
        teacher_list(lessonId).ifPresent(i -> {
            // 状态为未提交审核
            String state = i.getString("state");
            ass_tls(STATE_LESSON_NO_APPLY, state);
        });
    }

    @Test(description = "教师后台 课程详情")
    public void teacher_lessonInfo_test() {
        Info info = teacher_getLessonInfoById(lessonId);

        info.lessonInfo.ifPresent(i -> {
            String pubType = i.getString("pubType");
            ass_tlp(PUB_NO_APPLY, pubType);
        });

        info.array.flatMap(array -> JsonFuncUtil.extract(array, classroomId, "classroomId")).ifPresent(i -> {
            String pubType = i.getString("pubType");
            ass_tcp(PUB_NO_APPLY, pubType);
        });
    }

    /**
     * 管理员 课程列表此时还没有显示该课程
     * 因为它还没有提交过一次
     */
    @Test(description = "管理员 课程列表")
    public void superAdmin_lesson_list_test() {
        if (superAdmin_list(lessonId).isPresent()) {
            throw new RuntimeException("管理员 课程列表显示了该对象\n但课程还没有提交过一次，不应该显示");
        }
    }

}
