package professionalTest.lesson;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.M2TYPE;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class classroomVideoTestCase {

    // TODO 机构用户可以观看学情监控
    // TODO 机构指派的教师用户，也可以观看学情监控

    private Jigou jigou;
    private SuperAdmin superAdmin;
    private UserBase student;

    @BeforeClass
    public void beforeClass() {
        jigou = Global.init().getOpenBiJigou();
        superAdmin = Global.init().getSuperAdmin();
        student = Global.init().getUserBase();
    }

    private String lessonId;
    private List<String> classroomIds;
    private List<String> classroomVideoIds;
    private String stuId = "1101";

    public void init1(int classRoomCount) {
        //新建课程
        lessonId = jigou.newLessonAndGetLessonId(classRoomCount);
        //提交审核
        ComboUtil.applyLesson(superAdmin, jigou, lessonId);
        //新建视频
        //获取classroomId
        JSONObject object = jigou.getWeb().classroomAgent().listByLessonId(lessonId);
        classroomIds = Common.map(object.getJSONObject("data").getJSONArray("list"), "classroomId");

        for (String classroomId : classroomIds) {
            //为课节添加视频
            object = jigou.getWeb().classroomAgent().addClassVideo(classroomId);
            SampleAssert.assertCode200(object);
        }

        //获取视频id
        object = jigou.getWeb().lessonAgent().getVideo(lessonId);
        classroomVideoIds = Common.map(object.getJSONObject("data").getJSONArray("list"), "classroomVideoId");

        //课程添加班级
        jigou.getWeb().lessonAgent().studentByClassId(lessonId, stuId);
    }

    @Test(description = "学情监控，多课程，单用户全浏览")
    public void test() {
        int classRoomCount = 3;
        //初始化课时长度为3的课程
        init1(classRoomCount);

        //初始化学生，并将3个课时的视频都观看
        UserBase student = Global.init().getUserBase();
        for (int i = 0; i < classroomIds.size(); i++) {
            student.getApp().lessonInfoAgent().updateVideoTime("60", lessonId, classroomIds.get(i), classroomVideoIds.get(i));
        }

        JSONObject object = jigou.getApp().classChartAgent().getVideoList(stuId, Common.getNowTime(), Common.getEndTime(classRoomCount));
        assertGetVideoList(object, classRoomCount);

        object = jigou.getApp().classChartAgent().getVideoListClass(lessonId, stuId);
        assertGetVideoListClass(object, student, classRoomCount);

        object = jigou.getApp().classChartAgent().getVideoLesTypeClass(lessonId, stuId, M2TYPE.LESSON_TYPE_ID.CHI, Common.getNowTime(), Common.getEndTime(classRoomCount));
        assertGetVideoLesTypeClass(object, student, classRoomCount);
    }

    public void assertGetVideoList(JSONObject object, int classRoomCount) {
        JSONObject lessonInfo = Common.filder(object.getJSONArray("data"), lessonId, "lessonId");
        if (ObjectUtil.isNull(lessonInfo)) {
            throw new RuntimeException("classChart/getVideoList 接口，未返回lessonId==" + lessonId + "的课程");
        } else {
            SampleAssert.assertEquals(lessonInfo, "lsscount", String.valueOf(1));
            SampleAssert.assertEquals(lessonInfo, "lookCount", String.valueOf(classRoomCount));
            SampleAssert.assertEquals(lessonInfo, "classroomCount", String.valueOf(classRoomCount));
        }
    }

    public void assertGetVideoListClass(JSONObject object, UserBase student, int classRoomCount) {
        JSONObject userInfo = Common.filder(object.getJSONArray("data"), student.getUserId(), "userId");
        if (ObjectUtil.isNull(userInfo)) {
            throw new RuntimeException("classChart/getVideoListClass 接口，未搜索到userId为:" + student.getUserId() + "的学生");
        } else {
            SampleAssert.assertEquals(userInfo, "lessonId", lessonId);
            SampleAssert.assertEquals(userInfo, "watchTime", String.valueOf(classRoomCount) + "分");
            SampleAssert.assertEquals(userInfo, "timeLong", String.valueOf(classRoomCount * 60));
            SampleAssert.assertEquals(userInfo, "classroomCount", String.valueOf(classRoomCount));
        }
    }

    public void assertGetVideoLesTypeClass(JSONObject object, UserBase student, int classRoomCount) {
        JSONObject userInfo = Common.filder(object.getJSONArray("data"), student.getUserId(), "userId");
        if (ObjectUtil.isNull(userInfo)) {
            throw new RuntimeException("classChart/getVideoLesTypeClass 接口，未搜索到userId为:" + student.getUserId() + "的学生");
        } else {
            SampleAssert.assertEquals(userInfo, "lessonId", lessonId);
            SampleAssert.assertEquals(userInfo, "watchTime", String.valueOf(classRoomCount) + "分");
            SampleAssert.assertEquals(userInfo, "timeLong", String.valueOf(classRoomCount * 60));
            SampleAssert.assertEquals(userInfo, "classroomCount", String.valueOf(classRoomCount));
        }
    }
}
