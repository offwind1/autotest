package TestCase.me2.professionalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.agent.web.AdvertAgent;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Label;
import io.qameta.allure.model.StepResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

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

    @Test(description = "添加机构广告， 机构用户查看", groups = {"advertTestCase"})
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

    @AfterGroups(groups = {"advertTestCase"})
    public void after_test() {
        superAdmin.getManage().advertAgent().del(advertId);
    }


    //根据ID拿到广告详情advert/getAdvertById
    //TODO 被删除的广告，是否还可以通过接口读取信息
    @Test
    public void test1() {
        String remark = Common.creatRandomString();
        superAdmin.getManage().advertAgent().add(remark);

        JSONObject object = superAdmin.getManage().advertAgent().list();
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), remark, "remark");
        advertId = object.getString("advertId");
        object = superAdmin.getManage().advertAgent().getAdvertById(advertId);

        if (object.getJSONObject("data") == null) {
            throw new RuntimeException("未查询到数据");
        }

        superAdmin.getManage().advertAgent().del(advertId);
        object = superAdmin.getManage().advertAgent().getAdvertById(advertId);
        if (object.getJSONObject("data") != null) {
            throw new RuntimeException("删除的广告，依旧能查到数据");
        }

    }


    //删除广告advert/del
    //TODO 重复删除广告
    @Test
    public void test2() {
        String remark = Common.creatRandomString();
        superAdmin.getManage().advertAgent().add(remark);

        JSONObject object = superAdmin.getManage().advertAgent().list();
        object = Common.filder(object.getJSONObject("data").getJSONArray("list"), remark, "remark");
        advertId = object.getString("advertId");
        superAdmin.getManage().advertAgent().del(advertId);
        superAdmin.getManage().advertAgent().del(advertId);
    }





}
