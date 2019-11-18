package TestCase.kacha.parenthood;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODParenthood;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.user.KCSuperAdmin;
import com.mizholdings.kacha.playload.PLParenthood;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NormalParenthoodCase {

    private KCSuperAdmin superAdmin;
    private KCParent parent;
    private KCParent parent_other;
    private MODParenthood modParenthood;


    @BeforeClass
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
        parent_other = new KCParent("robot0200", "111111");
        modParenthood = new MODParenthood(parent);
    }

    public PLParenthood getPL() {
        return new PLParenthood();
    }

    @Test(description = "3_1_1 子女列表")
    @Description("子女列表")
    public void test1() {
        JSONObject object = parent.getChilds();
        SampleAssert.assertEquals("查询成功!", object);
    }

    private String childName = "addChild";
    private String childId;
    private String account;
    private String password = "123456";


    @Test(description = "3_1_2 添加子女")
    @Description("添加子女")
    public void test2() {
        JSONObject object = parent.addChild(childName);
        SampleAssert.assertEquals("添加成功", object);
        childId = object.getJSONObject("data").getString("userId");
        account = object.getJSONObject("data").getString("account");
    }

    @Test(description = "3_1_3 修改子女姓名", dependsOnMethods = {"test2"})
    @Description("修改子女姓名")
    public void test3() {
        PLParenthood plParenthood = getPL();
        plParenthood.setUpdatechild(childId, childName + "new");
        JSONObject object = modParenthood.updateChild(plParenthood);
        SampleAssert.assertEquals("设置成功!", object);
    }

    private String code;

    @Test(description = "3_1_5 亲子绑定码", dependsOnMethods = {"test2"})
    @Description("生成亲子绑定码")
    public void test4() {
        JSONObject object = parent.bindCode(childId);
        SampleAssert.assertEquals("获取成功", object);
        code = object.getJSONObject("data").getString("code");
    }

    @Test(description = "3_1_6 亲子绑定（1）", dependsOnMethods = {"test2", "test4"})
    @Description("通过code绑定子女")
    public void test5() {
        JSONObject object = parent_other.bindChild(code);
        SampleAssert.assertEquals("绑定成功", object);
    }

    @Test(description = "3_1_4 解除亲子关系", dependsOnMethods = {"test2", "test4", "test5"})
    @Description("解除亲子关系")
    public void test6() {
        JSONObject object = parent_other.deleteChild(childId);
        SampleAssert.assertEquals("解除亲子关系", object);
    }

    @Test(description = "3_1_6 亲子绑定（2）", dependsOnMethods = {"test2", "test4", "test5", "test6"})
    @Description("通过账号密码绑定子女")
    public void test7() {
        PLParenthood plParenthood = getPL();
        plParenthood.setBindchild(account, password, childName);
        JSONObject object = modParenthood.setExecutor(parent_other).bindChild(plParenthood);
        SampleAssert.assertEquals("绑定成功", object);
    }

    @Test(description = "3_1_7 当前子女", dependsOnMethods = {"test2"})
    @Description("设置当前子女")
    public void test8() {
        JSONObject object = parent.setCurrentChild(childId);
        SampleAssert.assertEquals("设置成功!", object);
    }

    @Test(description = "3_1_8 获取当前子女", dependsOnMethods = {"test2"})
    @Description("获取当前子女信息")
    public void test9() {
        JSONObject object = parent.getCurrentChild();
        SampleAssert.assertEquals("获取成功!", object);
    }


    @AfterClass
    public void afterClass() {
        parent.deleteAllChilds(GlobalKC.getChildId());
    }

}
