package TestCase.me2.itemTest;

import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2UserBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class itemTestCase {

    private Me2Jigou jigou;

    @BeforeClass
    public void beforeClass() {
        jigou = GlobalMe2.init().getFengBiJigou();
    }


    @Test(dependsOnMethods = "查询收费列表item/list")
    public void test_item_list() {
//        jigou.getWeb().itemAgent()
    }


}
