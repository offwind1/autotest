package jigouTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.web.AdvertAgent;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class advertTestCase {

    private SuperAdmin superAdmin = Global.init().getSuperAdmin();
    private Jigou jigou = Global.init().getFengBiJigou();
    private String advertId;

    @BeforeClass
    public void beforeClass() {
        superAdmin.setOrgId(jigou.getOrgId());

        String remark = Common.creatRandomString();
        JSONObject object = superAdmin.getManage().advertAgent().add(remark, jigou.getOrgId());
        SampleAssert.assertCode200(object);

        object = superAdmin.getManage().advertAgent().list();
        SampleAssert.assertCode200(object);

        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), remark, "remark");

        if (ObjectUtil.isNotNull(object)) {
            advertId = object.getString("advertId");
        } else {
            throw new RuntimeException("新建的新闻未定位到");
        }
    }

    @Test(description = "当前机构进行搜索，广告")
    public void advertList_jigou_test() {
        UserBase student = Global.init().getUserBase();
        student.setOrgId(jigou.getOrgId());

        JSONObject object = student.getApp().topAgent().advertList(Parameter.creat().add("type", "1"));
        object = Common.filder(object.getJSONArray("data"), advertId, "advertId");

        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("未搜索到，广告");
        }
    }

    @Test(description = "8橙进行搜索，广告")
    public void advertList_8cheng_test() {
        UserBase student = Global.init().getUserBase();
        student.setOrgId("0");

        JSONObject object = student.getApp().topAgent().advertList(Parameter.creat().add("type", "1"));
        object = Common.filder(object.getJSONArray("data"), advertId, "advertId");

        if (ObjectUtil.isNotNull(object)) {
            throw new RuntimeException("8橙进行搜索不能搜索到该广告");
        }
    }

    @AfterClass
    public void afterClass() {
        JSONObject object = superAdmin.getManage().advertAgent().del(advertId);
        SampleAssert.assertCode200(object);
    }


}

