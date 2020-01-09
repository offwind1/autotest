package normalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.agent.app.ClassInfoAgent;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.Test;

/**
 * 课堂管理相关测试。主要保证接口正常运行
 */
public class classroomInfoTestCase {

    private UserBase student = Global.init().getUserBase();
    private Teacher teacher = Global.init().getTeacher();

    @Test(description = "学生端_未来两周的待上课节")
    public void student_weekRoom() {
        JSONObject object = student.getApp().classInfoAgent().weekRoom(ClassInfoAgent.StudyType.STUDENT);
        SampleAssert.assertResult0(object);
    }

    @Test(description = "教师端_未来两周的待上课节")
    public void teacher_weekRoom() {
        JSONObject object = teacher.getApp().classInfoAgent().weekRoom(ClassInfoAgent.StudyType.TEACHER);
        SampleAssert.assertResult0(object);
    }

    @Test(description = "获取今天课堂列表")
    public void roomToday() {
        JSONObject object = teacher.getApp().classInfoAgent().roomToday();
        SampleAssert.assertResult0(object);
    }

    @Test(description = "获得课堂CODE")
    public void getCode() {
        JSONObject object = teacher.getApp().classInfoAgent().getCode();
        SampleAssert.assertResult0(object);
    }

    @Test(description = "获得七牛连麦的APP列表")
    public void rtcAppList() {
        JSONObject object = teacher.getApp().classInfoAgent().rtcAppList();
        SampleAssert.assertResult0(object);
    }

    @Test(description = "查询是否存在正在开课的课堂")
    public void notClose() {
        JSONObject object = teacher.getApp().classInfoAgent().notClose();
        SampleAssert.assertResult0(object);
    }


}
