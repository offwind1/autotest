package TestCase.me2.professionalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.agent.web.AdvertAgent;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class advertTestCase {

    private Me2SuperAdmin superAdmin;
    private Me2UserBase student;
    private Me2Jigou jigou;


    @BeforeClass
    public void beforeClass() {
        superAdmin = GlobalMe2.init().getSuperAdmin();
        jigou = GlobalMe2.init().getFengBiJigou();

        student = GlobalMe2.init().getUserBase();

        jigou.studentJoinJigou(student);
        student.setOrgId(jigou.getOrgId());
    }

    @AfterClass
    public void afterClass() {
        jigou.studentQuitJigou(student);
    }

    private String remark;
    private String advertId;


    @Test(description = "添加机构广告， 机构用户查看", groups = {"test"})
    public void test() {
        String remark = Common.creatRandomString();
        superAdmin.setOrgId(jigou.getOrgId());
        superAdmin.getManage().advertAgent().add(remark);

        JSONObject object = superAdmin.getManage().advertAgent().list();
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), remark, "remark");
        advertId = object.getString("advertId");

        student.getApp().topAgent().advertList(AdvertAgent.SRC_TYPE.JIGOU);
        student.getApp().topAgent().advertList(AdvertAgent.SRC_TYPE.RECOMMEND);

    }

    @AfterGroups(groups = {"test"})
    public void after_test() {
        superAdmin.getManage().advertAgent().del(advertId);
    }


}
