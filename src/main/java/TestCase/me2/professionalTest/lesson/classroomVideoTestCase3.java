package TestCase.me2.professionalTest.lesson;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.M2TYPE;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class classroomVideoTestCase3 {

    // TODO 机构用户可以观看学情监控
    // TODO 机构指派的教师用户，也可以观看学情监控

    private Me2Jigou jigou;
    private Me2SuperAdmin superAdmin;
    private Me2UserBase student;

    @BeforeClass
    public void beforeClass() {
        jigou = GlobalMe2.init().getOpenBiJigou();
        superAdmin = GlobalMe2.init().getSuperAdmin();
        student = GlobalMe2.init().getUserBase();
    }

    private String lessonId;
    private List<String> classroomIds;
    private List<String> classroomVideoIds;
    private String stuId = "1101";

    public void init(int classRoomCount) {
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

    @Test(description = "学情监控，多学生，多课程，全浏览")
    public void test() {
        //初始化课时长度为3的课程
        int classRoomCount = 3;
        int studentCount = 2;
        init(classRoomCount);

        for (int i = 0; i < studentCount; i++) {
            //初始化学生，并将3个课时的视频都观看
            Me2UserBase student = GlobalMe2.init().getUserBase();
            for (int j = 0; j < classRoomCount; j++) {
                student.getApp().lessonInfoAgent().updateVideoTime("60", lessonId, classroomIds.get(j), classroomVideoIds.get(j));
            }
        }

        JSONObject object = jigou.getApp().classChartAgent().getVideoList(stuId, Common.getNowTime(), Common.getEndTime(classRoomCount));
        assertGetVideoList(object, studentCount, classRoomCount);

        object = jigou.getApp().classChartAgent().getVideoListClass(lessonId, stuId);
        assertGetVideoListClass(object, studentCount, classRoomCount);

        object = jigou.getApp().classChartAgent().getVideoLesTypeClass(lessonId, stuId, M2TYPE.LESSON_TYPE_ID.CHI, Common.getNowTime(), Common.getEndTime(classRoomCount));
        assertGetVideoLesTypeClass(object, studentCount, classRoomCount);
    }

    public void assertGetVideoList(JSONObject object, int studentCount, int classRoomCount) {
        JSONObject lessonInfo = Common.filder(object.getJSONArray("data"), lessonId, "lessonId");
        if (ObjectUtil.isNull(lessonInfo)) {
            throw new RuntimeException("classChart/getVideoList 接口，未返回lessonId==" + lessonId + "的课程");
        } else {
            SampleAssert.assertEquals(lessonInfo, "lsscount", String.valueOf(studentCount));
            SampleAssert.assertEquals(lessonInfo, "lookCount", String.valueOf(classRoomCount * studentCount));
            SampleAssert.assertEquals(lessonInfo, "classroomCount", String.valueOf(classRoomCount));
        }
    }

    public void assertGetVideoListClass(JSONObject object, int studentCount, int classRoomCount) {

        if (ObjectUtil.notEqual(object.getJSONArray("data").size(), studentCount)) {
            throw new RuntimeException("classChart/getVideoListClass 接口的" + "学生数量不正确");
        }
        JSONObject userInfo = Common.random(object.getJSONArray("data"));
        if (ObjectUtil.isNotNull(userInfo)) {
            SampleAssert.assertEquals(userInfo, "lessonId", lessonId);
            SampleAssert.assertEquals(userInfo, "watchTime", String.valueOf(classRoomCount) + "分");
            SampleAssert.assertEquals(userInfo, "timeLong", String.valueOf(classRoomCount * 60));
            SampleAssert.assertEquals(userInfo, "classroomCount", String.valueOf(classRoomCount));
        }
    }

    public void assertGetVideoLesTypeClass(JSONObject object, int studentCount, int classRoomCount) {

        if (ObjectUtil.notEqual(object.getJSONArray("data").size(), studentCount)) {
            throw new RuntimeException("classChart/getVideoListClass 接口的" + "学生数量不正确");
        }

        JSONObject userInfo = Common.random(object.getJSONArray("data"));
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
