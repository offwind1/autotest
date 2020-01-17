package jigouTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.web.AdvertAgent;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class orgMessageTestCase {
    /**
     * 机构新闻权限测试
     * 各机构APP只能看当前机构的新闻
     */

    private Jigou open = Global.init().getOpenBiJigou();
    private SuperAdmin superAdmin = Global.init().getSuperAdmin();
    private String messageId;


    @BeforeClass
    public void beforeClass() {
        String msgName = "新闻" + Common.creatRandomString();
        JSONObject object = open.getWeb().orgInfoAgent().insertMessage(msgName);
        SampleAssert.assertCode200(object);

        object = open.getWeb().orgInfoAgent().orgMessageList();
        SampleAssert.assertCode200(object);
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), msgName, "messageName");

        if (ObjectUtil.isNotNull(object)) {
            messageId = object.getString("messageId");
        } else {
            throw new RuntimeException("新闻列表中，未找到相关新闻");
        }

        object = open.getWeb().orgInfoAgent().applyMessage(messageId);
        SampleAssert.assertCode200(object);

        object = superAdmin.getManage().orgInfoAgent().replyOrgMessage(messageId);
        SampleAssert.assertCode200(object);
    }


    /**
     * 当前结构，查看机构新闻，应该可以看到最新的机构新闻
     */
    @Test(description = "显示当前机构的新闻")
    public void v2topList_test() {
        UserBase student = Global.init().getUserBase();
        student.setOrgId(open.getOrgId());
        JSONObject object = student.getApp().topAgent().v2topList(ServeBase.GRADEID.ONE);
        SampleAssert.assertResult0(object);

        object = Common.filder(object.getJSONObject("data").getJSONArray("orgMsgList"), messageId, "messageId");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("当前机构的机构新闻没有显示");
        }
    }

    /**
     * 其他机构查看新闻，应该无法查看到
     */
    @Test(description = "其他机构的新闻")
    public void other_v2topList_test() {
        UserBase student = Global.init().getUserBase();
        student.setOrgId("9017");

        JSONObject object = student.getApp().topAgent().v2topList(ServeBase.GRADEID.ONE);
        SampleAssert.assertResult0(object);

        object = Common.filder(object.getJSONObject("data").getJSONArray("orgMsgList"), messageId, "messageId");
        if (ObjectUtil.isNotNull(object)) {
            throw new RuntimeException("其他机构的新闻,不应该显示这个新闻");
        }
    }

    @Test(description = "当前机构，新闻列表中可以看到最新的机构新闻")
    public void v2OrgMsgList_in_jigou() {
        // 接口v2OrgMsgList 机构用户只能查看本机构下的新闻
        UserBase student = Global.init().getUserBase();
        student.setOrgId(open.getOrgId());

        JSONObject object = student.getApp().topAgent().v2OrgMsgList();
        object = Common.filder(object.getJSONObject("data").getJSONArray("orgMsgList"), messageId, "messageId");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("机构新闻列表中没有该新闻");
        }
    }

    @Test(description = "其他机构，新闻列表中不能看到这个新闻")
    public void v2OrgMsgList_no_in_jigou() {
        // 接口v2OrgMsgList 机构用户只能查看本机构下的新闻
        UserBase student = Global.init().getUserBase();
        student.setOrgId("9017");

        JSONObject object = student.getApp().topAgent().v2OrgMsgList();
        object = Common.filder(object.getJSONObject("data").getJSONArray("orgMsgList"), messageId, "messageId");
        if (ObjectUtil.isNotNull(object)) {
            throw new RuntimeException("其他机构也看到了这个新闻！");
        }
    }


    @AfterClass
    public void afterClass() {
        JSONObject object = open.getWeb().orgInfoAgent().delMessage(Parameter.creat().add("messageId", messageId));
        SampleAssert.assertCode200(object);

    }

}
