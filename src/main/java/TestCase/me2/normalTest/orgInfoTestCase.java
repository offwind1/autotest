package TestCase.me2.normalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class orgInfoTestCase {

    //    private Me2Teacher teacher;
//    private Me2Teacher other;
    private Me2SuperAdmin superAdmin;
    private Me2Jigou jigou;

    @BeforeClass
    public void beforeClass() {
        superAdmin = GlobalMe2.init().getSuperAdmin();
        jigou = GlobalMe2.init().getFengBiJigou();
    }


    @Test(description = "分页列表orgInfo/list")
    public void test_orgInfo_list() {
        JSONObject object = superAdmin.getManage().orgInfoAgent().list("");
        SampleAssert.assertCode200(object);
    }

    @Test(description = "根据ID拿到机构orgInfo/getOrgById")
    public void test_orgInfo_getOrgById() {
        JSONObject object = superAdmin.getManage().orgInfoAgent().getOrgById(jigou.getOrgId());
        SampleAssert.assertCode200(object);
    }

}
