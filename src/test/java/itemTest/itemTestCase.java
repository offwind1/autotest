package itemTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class itemTestCase {

    private Jigou jigou = Global.init().getOpenBiJigou();
    private UserBase student = Global.init().getUserBase();
    private String itemId;
    private String lessonIds;

    @Test(description = "多项目收款流程测试")
    public void ItemTest() {
        add_test();
        list_test();
        delete_test();
        getById_test();
    }

    @Test(description = "添加收款项目")
    public void add_test() {
        JSONObject object = jigou.getWeb().lessonAgent().list();
        List<String> list = Common.map(object.getJSONObject("data").getJSONArray("list"), "lessonId");
        lessonIds = String.join(",", list);

        object = jigou.getWeb().itemAgent().add(lessonIds);
        SampleAssert.assertResult0(object);
    }

    @Test(description = "查询收费列表", dependsOnMethods = {"add_test"})
    public void list_test() {
        JSONObject object = jigou.getWeb().itemAgent().list();
        SampleAssert.assertResult0(object);
        itemId = Common.random(object.getJSONObject("data").getJSONArray("OrgPayitemList")).getString("itemId");
    }

    @Test(description = "修改收费列表", dependsOnMethods = {"list_test"})
    public void update_test() {
        JSONObject object = jigou.getWeb().itemAgent().update(itemId, lessonIds);
        SampleAssert.assertResult0(object);
    }

    @Test(description = "查询收款项目信息", dependsOnMethods = {"update_test"})
    public void getById_test() {
        JSONObject object = jigou.getWeb().itemAgent().getById(itemId);
        SampleAssert.assertResult0(object);
        List<String> list = Common.map(object.getJSONObject("data").getJSONObject("OrgPayitem").getJSONArray("liList"), "lessonId");
        lessonIds = String.join(",", list);
    }


    @Test(description = "用户购买课程", dependsOnMethods = {"getById_test"})
    public void buyLesson_test() {
        JSONObject object = jigou.getApp().payAgent().buyLesson(student.getUserId(), lessonIds);
//        SampleAssert.assertResult0(object);
    }

    @Test(description = "删除收款项目", dependsOnMethods = {"buyLesson_test"})
    public void delete_test() {
        JSONObject object = jigou.getWeb().itemAgent().delete(itemId);
        SampleAssert.assertResult0(object);
    }


}
