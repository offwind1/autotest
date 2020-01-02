package normalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class chanTestCase {

    private SuperAdmin superAdmin;

    @BeforeClass()
    public void beforeClass() {
        superAdmin = Global.init().getSuperAdmin();
    }

    private String grpName;
    private String grpId;

    @Test(description = "渠道群添加chanGroup/add")
    public void test_chanGroup_add() {
        grpName = Common.creatRandomString();
        JSONObject object = superAdmin.getManage().chanGroupAgent().add(grpName);
        SampleAssert.assertCode200(object);
    }

    @Test(description = "渠道群管理chanGroup/list", dependsOnMethods = {"test_chanGroup_add"})
    public void test_chanGroup_list() {
        JSONObject object = superAdmin.getManage().chanGroupAgent().list();
        SampleAssert.assertCode200(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), grpName, "grpName");
        grpId = object.getString("grpId");
    }

    @Test(description = "渠道群编辑chanGroup/edit", dependsOnMethods = {"test_chanGroup_list"})
    public void test_chanGroup_edit() {
        JSONObject object = superAdmin.getManage().chanGroupAgent().edit(grpId, Common.creatRandomString());
        SampleAssert.assertCode200(object);
    }

    private String chnName;
    private String chnId;

    @Test(description = "渠道信息新增chan/add")
    public void test_chan_add() {
        chnName = Common.creatRandomString();
        superAdmin.getManage().chanAgent().add(chnName);
    }

    @Test(description = "渠道信息列表chan/list", dependsOnMethods = {"test_chan_add"})
    public void test_chan_list() {
        JSONObject object = superAdmin.getManage().chanAgent().list();
        SampleAssert.assertCode200(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), chnName, "chnName");
        chnId = object.getString("chnId");
    }

    @Test(description = "渠道信息编辑chan/edit", dependsOnMethods = {"test_chan_list"})
    public void test_chan_edit() {
        JSONObject object = superAdmin.getManage().chanAgent().edit(chnId, Common.creatRandomString());
        SampleAssert.assertCode200(object);
    }

    @Test(description = "渠道绑定群chan/banding", dependsOnMethods = {"test_chan_edit", "test_chanGroup_edit"})
    public void test_chan_bangding() {
        JSONObject object = superAdmin.getManage().chanAgent().banding(chnId, grpId);
        SampleAssert.assertCode200(object);
    }

    @Test(description = "渠道信息详情chan/info", dependsOnMethods = {"test_chan_bangding"})
    public void test_chan_info() {
        JSONObject object = superAdmin.getManage().chanAgent().info(chnId);
        object = Common.filder(object.getJSONObject("data").getJSONObject("chan").getJSONArray("groupList"), grpId, "grpId");
        if (object == null) {
            throw new RuntimeException(grpId + "未找到");
        }
    }

    @Test(description = "渠道群删除chanGroup/del", dependsOnMethods = {"test_chan_info"})
    public void test_chanGroup_del() {
        JSONObject object = superAdmin.getManage().chanGroupAgent().del(grpId);
        SampleAssert.assertCode200(object);
    }

    @Test(description = "渠道信息删除chan/del", dependsOnMethods = {"test_chan_info"})
    public void test_chan_del() {
        JSONObject object = superAdmin.getManage().chanAgent().del(chnId);
        SampleAssert.assertCode200(object);
    }





}
