package TestCase.me2.professionalTest.course;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.requests.Request;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.InputStream;

public class courseTestCase {

    private Me2Teacher teacher;

    @Test(description = "资源库列表course/list")
    public void test() {
        JSONObject response = Request.go("app", "mobile", "login", Parameter.creat()
                .add("account", "weiyan")
                .add("password", "111111")
                .add("orgId", "0")
                .add("phone", "")
                .add("verifycode", "")
                .add("loginMode", "")
                .add("machine", "")
                .add("proType", "ykdebug")
                .add("longitude", "")
                .add("latitude", "")
                .getObjectMap()).json();

    }

}
