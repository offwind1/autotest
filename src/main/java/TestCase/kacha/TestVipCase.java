package TestCase.kacha;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODVip;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.playload.PLVip;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Feature("会员模块")
public class TestVipCase {
    private KCParent parent;
    private MODVip modVip;

    @BeforeClass
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
        modVip = new MODVip(parent);
    }

    @Test(description = "会员信息")
    public void test1() {
        PLVip plVip = new PLVip();
        plVip.setOpVipinfo(parent.getUserId());
        JSONObject object = modVip.opVipinfo(plVip);
    }

    @Test(description = "获得价格信息")
    public void test2() {
        PLVip plVip = new PLVip();
        plVip.setOpPrice(parent.currentChild());
        JSONObject object = modVip.opPrice(plVip);

        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("操作成功！", object);
    }


}
