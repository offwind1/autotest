package bugTest;

import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.manage.LessonAgent;
import com.mizholdings.me2.user.SuperAdmin;
import io.qameta.allure.Allure;
import io.qameta.allure.model.TestResult;
import org.testng.annotations.Test;

import java.util.UUID;

public class TestTestCase {
    private SuperAdmin superAdmin;
    @Test
    public void tesssst() {

        superAdmin = Global.init().getSuperAdmin();
        superAdmin.getManage().lessonAgent().lessonReply("fc59b8d840ed4507babcbdf634a7495d", com.mizholdings.me2.agent.web.LessonAgent.PubType.PASS);

    }
}
