package normalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class orgInfoTestCase {

    //    private Me2Teacher teacher;
//    private Me2Teacher other;
    private SuperAdmin superAdmin;
    private Jigou jigou;

    @BeforeClass
    public void beforeClass() {
        superAdmin = Global.init().getSuperAdmin();
        jigou = Global.init().getFengBiJigou();
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
