package TestCase.kacha;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODWpa;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.playload.PLWpa;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWpaCase {

    private KCParent parent;
    private MODWpa modWpa;

    @BeforeClass
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
        modWpa = new MODWpa(parent);
    }

    @Test(description = "17.1.1 查询关注班级事件")
    public void test1() {
        PLWpa plWpa = new PLWpa();
        plWpa.setMappScanClass(parent.currentChild());

        JSONObject object = modWpa.mappScanClass(plWpa);
        System.out.println(object);
    }


    @Test(description = "微信公众号班级二维码")
    public void test3() {
        PLWpa plWpa = new PLWpa();
        plWpa.setWeixinWxcode("642");

        JSONObject object = modWpa.weixinWxcode(plWpa);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("操作成功!", object);
    }


}
