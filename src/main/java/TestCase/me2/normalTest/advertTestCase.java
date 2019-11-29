package TestCase.me2.normalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.agent.web.AdvertAgent;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class advertTestCase {

    private Me2SuperAdmin superAdmin;
    private Me2UserBase student;

    @BeforeClass
    public void test() {
        superAdmin = GlobalMe2.init().getSuperAdmin();
        student = GlobalMe2.init().getUserBase();
    }

    private String remark;
    private String advertId;

    @Test(description = "添加广告advert/add")
    public void test_advert_add() {
        remark = Common.creatRandomString();
        JSONObject object = superAdmin.getManage().advertAgent().add(remark);
        SampleAssert.assertCode200(object);
    }

    @Test(description = "广告列表advert/list", dependsOnMethods = {"test_advert_add"})
    public void test_advert_list() {
        JSONObject object = superAdmin.getManage().advertAgent().list();
        SampleAssert.assertCode200(object);


        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), remark, "remark");
        advertId = object.getString("advertId");
    }

    @Test(description = "广告编辑advert/edit", dependsOnMethods = {"test_advert_list"})
    public void test_advert_edit() {
        remark = Common.creatRandomString();
        JSONObject object = superAdmin.getManage().advertAgent().edit(advertId, remark);
        SampleAssert.assertCode200(object);
    }

    @Test(description = "根据ID拿到广告详情advert/getAdvertById", dependsOnMethods = {"test_advert_edit"})
    public void test_advert_getAdvertById() {
        JSONObject object = superAdmin.getManage().advertAgent().getAdvertById(advertId);
        SampleAssert.assertCode200(object);

        assert remark.equals(object.getJSONObject("data")
                .getJSONObject("advert")
                .getString("remark")) : remark + ":" + object.getJSONObject("data").getString("remark");

    }

    @Test(description = "主页轮播广告top/advertList", dependsOnMethods = {"test_advert_getAdvertById"})
    public void test_top_advertList() {
        JSONObject object = student.getApp().topAgent().advertList(AdvertAgent.SRC_TYPE.RECOMMEND);
        object = Common.filder(object.getJSONArray("data"), advertId, "advertId");

        if (object == null) {
            throw new RuntimeException("新添加的广告，未搜索到");
        }
    }

    @Test(description = "删除广告advert/del", dependsOnMethods = {"test_top_advertList"})
    public void test_advert_del() {
        JSONObject object = superAdmin.getManage().advertAgent().del(advertId);
        SampleAssert.assertCode200(object);
    }


}
