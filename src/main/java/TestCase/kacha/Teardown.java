package TestCase.kacha;

import com.mizholdings.kacha.GlobalKC;
import org.testng.annotations.AfterSuite;

public class Teardown {

    @AfterSuite
    public void afterSuite() {
        GlobalKC.init().teardown();
    }


}
