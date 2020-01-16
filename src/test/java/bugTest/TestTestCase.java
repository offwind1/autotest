package bugTest;

import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.agent.manage.LessonAgent;
import com.mizholdings.me2.user.SuperAdmin;
import io.qameta.allure.Allure;
import io.qameta.allure.model.TestResult;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestTestCase {
    private SuperAdmin superAdmin;
    @Test
    public void tesssst() {

        List<Global_enum.LESSON_TYPE_ID> lesson_type_ids = new ArrayList<>();


        lesson_type_ids.add(Global_enum.LESSON_TYPE_ID.CHE);

    }
}
