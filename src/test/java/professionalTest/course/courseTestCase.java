package professionalTest.course;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.requests.Request;
import org.testng.annotations.Test;

public class courseTestCase {

    private Teacher teacher;

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
