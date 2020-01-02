package professionalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.app.ClassInfoAgent;
import com.mizholdings.me2.agent.app.LessonInfoAgent;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class XueXiPageTest {

    private Teacher teacher;
    private SuperAdmin superAdmin;
    private UserBase student;

    @BeforeClass
    public void beforeClass() {
        teacher = Global.init().getTeacher();
        superAdmin = Global.init().getSuperAdmin();
        student = Global.init().getUserBase();
    }

    /**
     * 新增课程并审核
     *
     * @return
     */
    public String newLessonAndApply(int startDay, int classRoomCount) {
        String lessonId = teacher.newLessonAndGetLessonId(LessonAgent.FreeType.FREE, startDay, classRoomCount);
        teacher.getWeb().lessonAgent().apply(lessonId);
        superAdmin.getManage().lessonAgent().passLesson(lessonId);
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
