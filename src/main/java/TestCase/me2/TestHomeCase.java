package TestCase.me2;


import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.GlobalMe2;
import com.mizholdings.me2.core.mod.MODTop;
import com.mizholdings.me2.core.user.Me2Student;
import com.mizholdings.me2.core.user.Me2Teacher;
import com.mizholdings.me2.playload.PLTop;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Feature("首页测试")
public class TestHomeCase {

    private Me2Student student;
    private Me2Teacher teacher;

    private MODTop modTop;

    @BeforeClass
    public void beforeClass() {
        student = GlobalMe2.init().getStudent();
        teacher = GlobalMe2.init().getTeacher();

        modTop = new MODTop(student);
    }

    @Test(description = "获取广告列表")
    public void test1() {
        PLTop plTop = new PLTop();
        plTop.setType("1");
        plTop.setOrgId("0");

        JSONObject object = modTop.advertList(plTop);
        System.out.println(object);
    }


}
