package bugTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.ComboUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.web.LessonAgent;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.Test;

public class BugTestCase {

    @Test(description = "authen=3，authenStatus=认证失败")
    public void user_info() {
        String account = Global.getProperties("me2.student.renzhengzhuanyong.account");
        UserBase student = new UserBase(account, "111111", "app");

        JSONObject object = student.getApp().mobileAgent().userInfo();
        SampleAssert.assertEquals(object.getJSONObject("data"), "authen", "3");
        SampleAssert.assertEquals(object.getJSONObject("data"), "authenStatus", "认证失败");

        object = student.getApp().usrAuthenAgent().list();
        SampleAssert.assertResult0(object);
    }

    /**
     * 机构用户购买机构课程，也要收费
     * 机构用户访问机构收费课程时，realPrice不能为0（以前是默认为0）
     */
    @Test(description = "机构用户购买机构课程，也要收费")
    public void realPrice_is_not_0() {
        Jigou jigou = Global.init().getOpenBiJigou();
        String lessonId = jigou.newLessonAndGetLessonId(LessonAgent.FreeType.NO_FREE);
        ComboUtil.applyLesson(Global.init().getSuperAdmin(), jigou, lessonId);

        UserBase student = Global.init().getUserBase();
        student.setOrgId(jigou.getOrgId());

        JSONObject object = student.getApp().lessonInfoAgent().lessonInfo(lessonId);

        if ("0".equals(object.getJSONObject("data").getString("realPrice"))) {
            throw new RuntimeException("realPrice依旧是0，机构用户依旧免费");
        }
    }


}

