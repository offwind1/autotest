package TestCase.kacha.parenthood;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODParenthood;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.playload.PLParenthood;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;

@Feature("亲子中心")
public class TestParenthoodCase {
    KCParent parent;
    private String classId;
    private String schoolId;
    private String childId;
    MODParenthood modParenthood;

    private KCParent parent1;
    private KCParent parent2;
    private String bind_child;

    @BeforeClass
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
        classId = GlobalKC.getClassId();
        schoolId = GlobalKC.getSchoolId();
        childId = GlobalKC.getChildId();

        modParenthood = new MODParenthood(parent);


        parent1 = new KCParent("robot0100", "111111");
        parent2 = new KCParent("robot0200", "111111");
    }

    @BeforeGroups(description = "初始化", groups = {"update_test"})
    public void beforeGroups() {
        //3、设置该子女为当前子女
        JSONObject setCurrentChild1 = parent.setCurrentChild(childId);
        SampleAssert.assertEquals("设置成功!", setCurrentChild1);
    }

    @Test(description = "3_2_6 修改名字接口，name和nickname都需要修改", groups = {"test3_2_6"})
    public void test3_2_6() {
        String define_name = "接口测试专用子女";

        //2、修改子女姓名
        PLParenthood plParenthood = new PLParenthood();
        plParenthood.setUpdatechild(childId, define_name + "new");
        JSONObject updateChild = modParenthood.updateChild(plParenthood);
        SampleAssert.assertEquals("设置成功!", updateChild);

        //4、获取当前子女信息
        JSONObject getCurrentChild = parent.getCurrentChild();
        SampleAssert.assertEquals("获取成功!", getCurrentChild);
        String nickname = getCurrentChild.getJSONObject("data").getString("nickname");
        String name = getCurrentChild.getJSONObject("data").getString("name");
        assert nickname.equals(name) : nickname + "==" + name;
    }

    @AfterGroups(groups = {"test3_2_6"}, description = "恢复原始昵称")
    public void after_update_test() {
        String define_name = "接口测试专用子女";
        //2、修改子女姓名
        PLParenthood plParenthood = new PLParenthood();
        plParenthood.setUpdatechild(childId, define_name);
        JSONObject updateChild = modParenthood.updateChild(plParenthood);
        SampleAssert.assertEquals("设置成功!", updateChild);
    }

    @Test(description = "3_2_1 添加子女，子女的名称不能重复（测试三次以上）", groups = {"repeat_name_test"})
    public void test2() {
        String childName = "asd228";
        //1、添加子女
        JSONObject addChild = parent.addChild(childName);
        SampleAssert.assertResult("0", addChild);
        Allure.addAttachment("第一次添加", addChild.toJSONString());

        // 2、第二次重复添加，报错
        JSONObject addChild2 = parent.addChild(childName);
        Allure.addAttachment("第二次添加", addChild2.toJSONString());
        SampleAssert.assertResult("0", addChild2);
        JSONObject addChild3 = parent.addChild(childName);
        Allure.addAttachment("第三次添加", addChild3.toJSONString());
        SampleAssert.assertResult("0", addChild3);
    }

    @AfterGroups(groups = {"repeat_name_test"})
    public void after_repeat_name_test() {
        parent.deleteAllChilds(childId);
    }


    /**
     * 正常流程
     * 1、添加子女
     * 2、修改子女姓名
     * 3、设置该子女为当前子女
     * 4、获取当前子女信息
     * 5、解绑子女
     * 6、查看子女列表查看是否解绑
     */
    @Test(description = "3_2_5 正常流程")
    public void test3_2_5() {
        String childName = "asd228";
        //1、添加子女
        JSONObject addChild = parent.addChild(childName);
        SampleAssert.assertEquals("添加成功", addChild);
        String userId = addChild.getJSONObject("data").getString("userId");

        //2、修改子女姓名
        PLParenthood plParenthood = new PLParenthood();
        plParenthood.setUpdatechild(userId, childName + "new");
        JSONObject updateChild = modParenthood.updateChild(plParenthood);
        SampleAssert.assertEquals("设置成功!", updateChild);

        //3、设置该子女为当前子女
        JSONObject setCurrentChild1 = parent.setCurrentChild(userId);
        SampleAssert.assertEquals("设置成功!", setCurrentChild1);

        parent.getChilds();

        //4、获取当前子女信息
        JSONObject getCurrentChild = parent.getCurrentChild();
        SampleAssert.assertEquals("获取成功!", getCurrentChild);
        assert userId.equals(getCurrentChild.getJSONObject("data").getString("id")) :
                userId + "!=" + getCurrentChild.getJSONObject("data").getString("id");

        //5、解绑子女
        JSONObject deleteChild = parent.deleteChild(userId);
        SampleAssert.assertEquals("解除亲子关系", deleteChild);

        //6、查看子女列表查看是否解绑
        JSONObject childs = parent.getChilds();

        for (Object object : childs.getJSONArray("data")) {
            JSONObject jsonObject = (JSONObject) object;
            Assert.assertNotEquals(userId, jsonObject.getString("id"));
        }
    }

    @Test(description = "3_2_4 通过绑定码绑定子女（正常绑定）", groups = {"test3_2_4"})
    public void test3_2_4() {
        // 父母1，添加子女
        JSONObject addChild = parent1.addChild("绑定测试生成子女");
        SampleAssert.assertEquals("添加成功", addChild);
        bind_child = addChild.getJSONObject("data").getString("userId");

        //生成子女的绑定码
        JSONObject bindCode = parent1.bindCode(bind_child);
        SampleAssert.assertEquals("获取成功", bindCode);
        String code = bindCode.getJSONObject("data").getString("code");

        //父母2通过绑定码，绑定子女
        JSONObject bindChild = parent2.bindChild(code);
        SampleAssert.assertEquals("绑定成功", bindChild);

        //检查父母2的子女列表中，是否有新子女
        JSONObject childs = parent2.getChilds();
        System.out.println(childs);

        List<Object> test = childs.getJSONArray("data").stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return bind_child.equals(o.getString("id"));
        }).collect(Collectors.toList());
        Assert.assertTrue(test.size() > 0);
    }

    @AfterGroups(groups = {"test3_2_4"})
    public void after_bind_test() {
        //用例成功。双父母删除子女，恢复数据
        parent1.deleteChild(bind_child);
        parent2.deleteChild(bind_child);
    }

    @Test(description = "3_2_2 通过绑定方式，添加名称重复的子女", groups = {"3_2_2"})
    @Description("家长通过code添加子女，而这个code子女名字正好和自己已有的子女重名")
    public void test3_2_2() {
        String childName = "codeChild";

        //用户1添加子女
        parent1.addChild(childName);
        //用户2添加子女，名称相同
        JSONObject object = parent2.addChild(childName);
        String userId = object.getJSONObject("data").getString("userId");

        object = parent2.bindCode(userId);
        String code = object.getJSONObject("data").getString("code");
        parent1.bindChild(code);

    }

    @AfterGroups(groups = {"3_2_2"})
    public void after_3_2_2() {
        parent1.deleteAllChilds();
        parent2.deleteAllChilds();
    }

    @Test(description = "3_2_3 通过绑定码，重复添加子女")
    public void test3_2_3() {
        JSONObject object = parent1.addChild("bindChild");
        String userId = object.getJSONObject("data").getString("userId");

        object = parent1.bindCode(userId);
        String code = object.getJSONObject("data").getString("code");

        object = parent1.bindChild(code);
        SampleAssert.assertEquals("请勿重复添加", object);
    }

    @AfterGroups(groups = {"test3_2_3"})
    public void after_3_2_3() {
        parent1.deleteAllChilds();
        parent2.deleteAllChilds();
    }

    @Test(description = "3_2_7 反复解除亲子关系")
    public void test3_2_7() {
        JSONObject object = parent1.addChild("327Child");
        String userId = object.getJSONObject("data").getString("userId");

        parent1.deleteChild(userId);
        JSONObject object1 = parent1.deleteChild(userId);
        SampleAssert.assertEquals("请检查亲子关系", object1);
    }

    @Test(description = "3_2_8 生成不是自己子女的绑定码")
    public void test3_2_8() {
        JSONObject object = parent1.bindCode(childId);
        SampleAssert.assertEquals("您没有分享权限", object);
    }

    @Test(description = "3_2_9 设置其他人的子女作为当前子女")
    public void test3_2_9() {
        JSONObject object = parent1.setCurrentChild(childId);
        assert false : object.getString("msg");
    }


}
