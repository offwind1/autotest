package TestCase.me2.professionalTest.lesson;

import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.serveInterface.appInterface;

public class classLibraryTest {

    private Me2Jigou jigou = GlobalMe2.init().getFengBiJigou();

    public void test() {
        jigou.getWeb().lessonAgent();




    }


}
