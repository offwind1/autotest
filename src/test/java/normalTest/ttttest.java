package normalTest;

import cn.hutool.core.util.RandomUtil;
import org.testng.annotations.Test;

public class ttttest {

    int k_count = 4;
    int z_count = 1;
    int answer_student = 5;
    int no_answer_student = 1;

    @Test
    public void test() {
        System.out.println(answer_student / 4 + ((4 % 4) < (answer_student % 4) ? 1 : 0));
    }
}
