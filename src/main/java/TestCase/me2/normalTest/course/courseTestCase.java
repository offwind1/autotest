package TestCase.me2.normalTest.course;

import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2Teacher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class courseTestCase {

    private Me2Teacher teacher;

    @BeforeClass
    public void beforeClass() {
        teacher = GlobalMe2.init().getTeacher();
    }

    @Test(description = "资源库列表course/list")
    public void test_course_list() {
//        teacher.getWeb().webCourseAgent().list();

    }

}
