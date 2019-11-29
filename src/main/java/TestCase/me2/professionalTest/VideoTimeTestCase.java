package TestCase.me2.professionalTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.me2.user.Me2UserBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VideoTimeTestCase {

    private Me2Teacher teacher;
    private Me2UserBase student;

    @BeforeClass()
    public void beforeClass() {
        teacher = GlobalMe2.init().getTeacher();
        student = GlobalMe2.init().getUserBase();
    }


}
