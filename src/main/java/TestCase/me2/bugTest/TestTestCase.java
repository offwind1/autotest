package TestCase.me2.bugTest;

import cn.hutool.core.util.XmlUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.XmlTool.ElementMine;
import com.mizholdings.util.XmlTool.NodeListMine;
import com.mizholdings.util.XmlTool.NodeMine;
import com.mizholdings.util.XmlTool.XmlTool;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import io.qameta.allure.model.TestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.UUID;

public class TestTestCase {
    private Me2SuperAdmin superAdmin;
    @Test
    public void tesssst() {

        String asd = UUID.randomUUID().toString();
        System.out.println(asd);

        Allure.getLifecycle().scheduleTestCase(asd, (new TestResult()).withUuid(asd));
//        Allure.getLifecycle().updateTestCase(asd, this.setStatus(Status.PASSED));
        Allure.getLifecycle().stopTestCase(asd);
        Allure.getLifecycle().writeTestCase(asd);
        Allure.addAttachment("asdasd", "asdasd");

    }
}
