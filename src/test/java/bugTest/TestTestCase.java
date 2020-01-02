package bugTest;

import com.mizholdings.me2.user.SuperAdmin;
import io.qameta.allure.Allure;
import io.qameta.allure.model.TestResult;
import org.testng.annotations.Test;

import java.util.UUID;

public class TestTestCase {
    private SuperAdmin superAdmin;
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
