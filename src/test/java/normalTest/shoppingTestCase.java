package normalTest;

import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.Parameter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class shoppingTestCase {

    private Teacher teacher;
    private String lessonId = "bcf5ba2837a543dba2fc6c3b324898d5";

    @BeforeClass
    public void beforeClass() {
        teacher = Global.init().getRandomTeacher();

    }

    @Test(description = "商品加入购物车")
    public void shopping_add_test() {
        teacher.getWeb().shoppingAgent().add(lessonId);
    }

    @Test(description = "查询购物车列表")
    public void shopping_list_test() {
        teacher.getWeb().shoppingAgent().list(Parameter.creat().add("goodsIds", lessonId));
    }
    
    @Test(description = "删除商品")
    public void shopping_delete_test() {
        teacher.getWeb().shoppingAgent().delete(Parameter.creat().add("goodsIds", lessonId));
    }

    @Test(description = "清空购物车")
    public void shopping_deleteAll_test() {
        teacher.getWeb().shoppingAgent().deleteAll(Parameter.creat());
    }

}
