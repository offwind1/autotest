package itemTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.Global_enum;
import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.Parameter;
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

    private JSONArray getItemDiscountJson() {
        JSONArray array = new JSONArray();
        for (int i = 0; i < 3; i++) {
            JSONObject object = new JSONObject();
            object.put("meetPrice", 20 * (i + 1));
            object.put("discountsPrice", 10 * (i + 1));
            array.add(object);
        }
        return array;
    }

    @Test(description = "添加收款项目")
    public void add_test() {
        JSONObject object = jigou.getWeb().lessonAgent().list(Global_enum.PUB_TYPE.PASS);
        List<String> list = Common.map(object.getJSONObject("data").getJSONArray("list"), "lessonId");
        lessonIds = String.join(",", list);

        object = jigou.getWeb().itemAgent().add(lessonIds, getItemDiscountJson());
        SampleAssert.assertResult0(object);
    }

    @Test(description = "查询收费列表", dependsOnMethods = {"add_test"})
    public void list_test() {
        JSONObject object = jigou.getWeb().itemAgent().list();
        SampleAssert.assertResult0(object);
        itemId = Common.random(object.getJSONObject("data").getJSONArray("OrgPayitemList")).getString("itemId");
    }


    @Test(description = "管理员 查看收费列表", dependsOnMethods = {"list_test"})
    public void superAdmin_list_test() {
        SuperAdmin superAdmin = Global.init().getSuperAdmin();
        JSONObject object = superAdmin.getManage().itemAgent().list(Parameter.creat().add("page", "1").add("pageSize", "10"));

        object = Common.filder(object.getJSONObject("data").getJSONArray("opList"), itemId, "itemId");
        if (ObjectUtil.isNull(object)) {
            throw new RuntimeException("管理员收费列表中，未找到该收款项目");
        }
    }

    @Test(description = "修改收费列表", dependsOnMethods = {"superAdmin_list_test"})
    public void update_test() {
        JSONObject object = jigou.getWeb().itemAgent().update(itemId, lessonIds, getItemDiscountJson());
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
        if ("课程下架或已购买".equals(object.getString("msg"))) {
            return;
        }

        if ("0".equals(object.getString("result"))) {
            return;
        }

        SampleAssert.assertResult0(object);
    }

    @Test(description = "删除收款项目", dependsOnMethods = {"buyLesson_test"})
    public void delete_test() {
        JSONObject object = jigou.getWeb().itemAgent().delete(itemId);
        SampleAssert.assertResult0(object);
    }

}
