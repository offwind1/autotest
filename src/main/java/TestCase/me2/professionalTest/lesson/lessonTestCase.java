package TestCase.me2.professionalTest.lesson;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Common;
import org.testng.annotations.*;

import java.io.*;

public class lessonTestCase {
    public Me2Teacher teacher;
    public Me2UserBase student;
    public Me2SuperAdmin superAdmin;

    @BeforeClass
    public void beforeClass() {
        teacher = GlobalMe2.init().getTeacher();
        superAdmin = GlobalMe2.init().getSuperAdmin();
        student = GlobalMe2.init().getUserBase();

        System.out.println(teacher);
        System.out.println(superAdmin);
        System.out.println(student);
    }

    private String classroomVideoId;
    private String cloudAccount;
    private String classroomId;
    private String classroomCode;

    private int studentNum = 10;


    @BeforeGroups(groups = {"lessonTestCase"})
    public void beforeTest() {
        System.out.println(teacher);
        String lessonId = teacher.newLessonAndGetLessonId(4);
        String userIds = String.join(",", GlobalMe2.getUserIds(studentNum));
        teacher.getWeb().lessonAgent().addTeacherStudent(userIds, lessonId);

        teacher.getWeb().lessonAgent().apply(lessonId);
        superAdmin.getManage().lessonAgent().passLesson(lessonId);

        JSONObject object = teacher.getApp().lessonInfoAgent().lessonInfo(lessonId);
        object = Common.random(object.getJSONObject("data").getJSONArray("classroomInfoList"));
        classroomId = object.getString("classroomId");

        object = teacher.getApp().classInfoAgent().classroomStart(classroomId);

        classroomCode = object.getJSONObject("data").getJSONObject("classroomInfo").getString("classroomCode");
        classroomVideoId = object.getJSONObject("data").getString("classroomVideoId");
        cloudAccount = object.getJSONObject("data").getJSONObject("classroomInfo").getString("teacherCloudeAccount");
    }

    @Test(groups = {"lessonTestCase"})
    public void test() {
        JSONObject object = superAdmin.getManage().classroomAgent().onlineListV2ByClassroomCode(classroomCode);
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), classroomId, "classroomId");

        if (studentNum != object.getInteger("studentCount")) {
            throw new RuntimeException("应到人数不正确");
        }
    }


    @Test(groups = {"lessonTestCase"})
    public void test1() {
        JSONObject object = teacher.getApp().classChartAgent().arrive(classroomId);
    }


    @AfterGroups(groups = {"lessonTestCase"})
    public void afterTest() {
        teacher.getApp().classInfoAgent().classroomEnd(classroomVideoId, cloudAccount);
    }


}
