package TestCase.me2;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.agent.app.ClassInfoAgent;
import com.mizholdings.me2.agent.app.LessonInfoAgent;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.user.serve.App;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class XueXiPageTest {

    private Me2Teacher teacher;
    private Me2SuperAdmin superAdmin;
    private Me2UserBase student;

    @BeforeClass
    public void beforeClass() {
        teacher = GlobalMe2.init().getTeacher();
        superAdmin = GlobalMe2.init().getSuperAdmin();
        student = GlobalMe2.init().getUserBase();
    }

    /**
     * 新增课程并审核
     *
     * @return
     */
    public String newLessonAndApply(int startDay, int classRoomCount) {
        String lessonId = teacher.newLessonAndGetLessonId(LessonAgent.FreeType.FREE, startDay, classRoomCount);
        teacher.getWeb().lessonAgent().apply(lessonId);
        superAdmin.getWeb().lessonAgent().passLesson(lessonId);
        return lessonId;
    }

    @Test(description = "2_1_1_1 课程表显示未来两周待上的课节名称, 前两天")
    public void test2_1_1_1() {
        //新增课程
        String lessonId = newLessonAndApply(0, 2);
        //加入课程
        JSONObject object = student.getApp().payAgent().getPingxx(lessonId);
        SampleAssert.assertEquals("购买成功", object);

        object = student.getApp().classInfoAgent().weekRoom(ClassInfoAgent.StudyType.STUDENT);

        List<Object> list = object.getJSONArray("data").stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return lessonId.equals(o.getString("lessonId"));
        }).collect(Collectors.toList());

        if (list.size() != 2) {
            throw new RuntimeException("2个课节没有全部搜索出来");
        }
    }

    @Test(description = "2_1_1_1 课程表显示未来两周待上的课节名称, 后两天")
    public void test2_1_1_2() {
        //新增课程
        String lessonId = newLessonAndApply(13, 4);
        //加入课程
        JSONObject object = student.getApp().payAgent().getPingxx(lessonId);
        SampleAssert.assertEquals("购买成功", object);

        object = student.getApp().classInfoAgent().weekRoom(ClassInfoAgent.StudyType.STUDENT);
        List<Object> list = object.getJSONArray("data").stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return lessonId.equals(o.getString("lessonId"));
        }).collect(Collectors.toList());

        System.out.println(list.size());

        if (list.size() != 2) {
            throw new RuntimeException("2周内");
        }
    }

    @Test(description = "2_1_2_1 显示所有加入过的系列课程")
    public void test2_1_2_1() {
        //新增课程
        String lessonId = newLessonAndApply(0, 2);
        //加入课程
        JSONObject object = student.getApp().payAgent().getPingxx(lessonId);
        object = student.getApp().lessonInfoAgent().myLesson(LessonInfoAgent.LessonTerm.LESSON);

        if (object.getJSONArray("data").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return !lessonId.equals(o.getString("lessonId"));
        })) {
            throw new RuntimeException("没有搜索到加入过的系列课程");
        }
    }






}
