package TestCase.me2.professionalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class chanTestCase {

    private Me2SuperAdmin superAdmin;

    @BeforeClass()
    public void beforeClass() {
        superAdmin = GlobalMe2.init().getSuperAdmin();
    }


    @Test(description = "渠道和渠道群绑定后，渠道群被删除，渠道信息中的渠道群信息是否同步被删除")
    public void test() {
        //新建群
        String grpId = superAdmin.newChanGroup();
        //新建渠道
        String chnId = superAdmin.newChan();
        //渠道和群绑定
        superAdmin.getManage().chanAgent().banding(chnId, grpId);
        //删除群
        superAdmin.getManage().chanGroupAgent().del(grpId);
        //查看渠道信息
        JSONObject object = superAdmin.getManage().chanAgent().info(chnId);
        //删除渠道
        superAdmin.getManage().chanAgent().del(chnId);

        //是否群消息还遗留着
        object = Common.filder(object.getJSONObject("data").getJSONObject("chan").getJSONArray("groupList"), grpId, "grpId");
        if (object != null) {
            throw new RuntimeException("渠道群删除后，查看渠道信息，依旧会显示该渠道的信息");
        }
    }
}
