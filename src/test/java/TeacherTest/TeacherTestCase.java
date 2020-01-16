package TeacherTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TeacherTestCase {

    private Teacher jigou = Global.init().getTeacher();
    private String classroomIds;
    private List<String> classroomId_list;
    private String lessonId;
    private String classroomVideoId;
    private String teacherCloudeAccount;
    private UserBase teacher = Global.init().getUserBase();

    @BeforeClass
    public void beforeClass() {
        lessonId = jigou.newLessonAndGetLessonId(2);
        ComboUtil.applyLesson(Global.init().getSuperAdmin(), jigou, lessonId);

        JSONObject object = jigou.getWeb().lessonAgent().getLessonInfoById(lessonId);

        classroomId_list = Common.map(object.getJSONObject("data").getJSONArray("classroomList"), "classroomId");
        classroomIds = String.join(",", classroomId_list);

        object = jigou.getWeb().classroomAgent().setTeacher(classroomIds, teacher.getUserId());
        SampleAssert.assertResult0(object);

        object = jigou.classroomStart(classroomId_list.get(0));
        SampleAssert.assertResult0(object);

        classroomVideoId = object.getJSONObject("data").getString("classroomVideoId");
        teacherCloudeAccount = object.getJSONObject("data").getJSONObject("classroomInfo").getString("teacherCloudeAccount");
    }

    @Test(description = "获取课堂的助教老师列表")
    public void setTeacher() {
        JSONObject object = jigou.getWeb().classroomAgent().getTeacherList_classroomId(classroomId_list.get(0));
        SampleAssert.assertResult0(object);
    }

    @Test(description = "获取课堂老师列表", dependsOnMethods = "setTeacher")
    public void getClassroomTeacher() {
        UserBase student = Global.init().getUserBase();
        student.getApp().classInfoAgent().getClassroomTeacher(classroomId_list.get(0));
    }

    @Test(description = "切换主讲老师-手动")
    public void switchMasterByManu() {
        JSONObject object = jigou.getApp().classInfoAgent().switchMasterByManu(classroomId_list.get(0), teacher.getUserId());
        SampleAssert.assertResult0(object);
//        List<String> teacher_list = Common.map(object.getJSONObject("data").getJSONArray("teacherList"), "cloudUsrAccount");
    }

    @AfterClass
    public void afterClass() {
        jigou.classroomEnd(classroomVideoId, teacherCloudeAccount);
    }
}
