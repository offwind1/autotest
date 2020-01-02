package professionalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.web.AdvertAgent;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class advertTestCase {

    private SuperAdmin superAdmin;
    private UserBase student;
    private Jigou jigou;


    @BeforeClass
    public void beforeClass() {
        superAdmin = Global.init().getSuperAdmin();
        jigou = Global.init().getFengBiJigou();

        student = Global.init().getUserBase();

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
