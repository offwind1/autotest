package jigouTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * // todo 机构直播课管理
 */
public class liveManageTestCase {

    private Jigou jigou = Global.init().getOpenBiJigou();
    private String lessonId;
    private String classroomVideoId;
    private String teacherCloudeAccount;

    @Test(description = "机构直播课管理：机构用户开课，机构直播课管理界面应该可以查看到该课程")
    public void onlineListV2_test() {
        lessonId = jigou.newLessonAndGetLessonId(1);
        ComboUtil.applyLesson(Global.init().getSuperAdmin(), jigou, lessonId);

        JSONObject object = jigou.getWeb().lessonAgent().getLessonInfoById(lessonId);
        String classroomId = Common.random(object.getJSONObject("data").getJSONArray("classroomList")).getString("classroomId");
        object = jigou.classroomStart(classroomId);
        SampleAssert.assertCode200(object);

        classroomVideoId = object.getJSONObject("data").getString("classroomVideoId");
        teacherCloudeAccount = object.getJSONObject("data").getJSONObject("classroomInfo").getString("teacherCloudeAccount");

        object = jigou.getWeb().classroomAgent().onlineListV2();
        SampleAssert.assertCode200(object);

        if (ObjectUtil.isEmpty(object.getJSONObject("data").getJSONArray("list"))) {
            throw new RuntimeException("直播课管理，未查询到任何课程");
        }
    }


    @AfterClass
    public void afterClass() {
        jigou.classroomEnd(classroomVideoId, teacherCloudeAccount);
    }

}
