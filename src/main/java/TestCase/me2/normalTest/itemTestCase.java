package TestCase.me2.normalTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.GlobalMe2;
import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class itemTestCase {

    private Me2Jigou jigou;

    @BeforeClass
    public void beforeClass() {
        jigou = GlobalMe2.init().getFengBiJigou();
    }


    @Test(description = "查询收费列表item/list")
    public void test_item_list() {
        JSONObject object = jigou.getWeb().itemAgent().list();
        SampleAssert.assertMsg("列表查询成功", object);
    }


    public String randomLessonString() {
        JSONObject object = jigou.getWeb().lessonAgent().list();
        List<String> list = object.getJSONObject("data").getJSONArray("list").stream().map(i -> {
            JSONObject o = (JSONObject) i;
            return o.getString("lessonId");
        }).collect(Collectors.toList());
        return Common.randomJoinFromList(",", list);
    }


    @Test(description = "添加收款项目item/add")
    public void test_item_add() {
        String lessonIds = randomLessonString();
        JSONObject object = jigou.getWeb().itemAgent().add(Common.creatRandomString(), "2,3", lessonIds);
        SampleAssert.assertMsg("添加成功！", object);
    }


    @Test(description = "修改收款项目item/update")
    public void test_item_update() {
        JSONObject object = jigou.getWeb().itemAgent().list();
        object = Common.random(object.getJSONObject("data").getJSONArray("OrgPayitemList"));
        String itemId = object.getString("itemId");

        object = jigou.getWeb().itemAgent().update(itemId, Common.creatRandomString(), "2,3", randomLessonString());
        SampleAssert.assertMsg("修改成功", object);
    }

    @Test(description = "查询收款项目信息item/getById")
    public void test_item_getById() {
        JSONObject object = jigou.getWeb().itemAgent().list();
        object = Common.random(object.getJSONObject("data").getJSONArray("OrgPayitemList"));
        String itemId = object.getString("itemId");

        object = jigou.getWeb().itemAgent().getById(itemId);
        SampleAssert.assertMsg("查询成功", object);
    }

}
