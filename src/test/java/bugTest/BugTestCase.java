package bugTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.UserBase;
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
    }
}
