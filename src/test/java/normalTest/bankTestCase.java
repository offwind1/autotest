package normalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.app.ClassInfoAgent;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.Test;

/**
 * 课堂管理相关测试。主要保证接口正常运行
 */
public class bankTestCase {

    private UserBase student = Global.init().getUserBase();
    private Teacher teacher = Global.init().getTeacher();

    @Test(description = "银行列表")
    public void bank_list() {
        JSONObject object = student.getApp().bankAgent().list();
        SampleAssert.assertCode200(object);
    }

    @Test(description = "获取提现账号")
    public void drawAccount() {
        JSONObject object = student.getApp().bankAgent().drawAccount();
        SampleAssert.assertCode200(object);
    }

    @Test(description = "用户钱包主界面")
    public void userWallet() {
        JSONObject object = student.getApp().bankAgent().userWallet();
        SampleAssert.assertCode200(object);
    }

    @Test(description = "用户钱包主界面")
    public void userDirect() {
        JSONObject object = student.getApp().bankAgent().userDirect();
        SampleAssert.assertCode200(object);
    }
}
