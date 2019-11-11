package TestCase.kacha;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.GlobalKC;
import com.mizholdings.kacha.core.mod.MODParenthood;
import com.mizholdings.kacha.core.mod.MODSchool;
import com.mizholdings.kacha.core.user.KCParent;
import com.mizholdings.kacha.playload.PLParenthood;
import com.mizholdings.kacha.playload.PLSchool;
import com.mizholdings.util.SampleAssert;
import com.myreport.Title;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.stream.Collectors;

@Feature("亲子中心")
public class TestParenthoodCase {


    KCParent parent;
    private String classId;
    private String schoolId;
    private String childId;
    MODParenthood modParenthood;

    @BeforeClass
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
        classId = GlobalKC.getClassId();
        schoolId = GlobalKC.getSchoolId();
        childId = GlobalKC.getChildId();

        modParenthood = new MODParenthood(parent);
    }

    @BeforeGroups(description = "初始化", groups = {"update_test"})
    public void beforeGroups() {
        //3、设置该子女为当前子女
        JSONObject setCurrentChild1 = parent.setCurrentChild(childId);
        SampleAssert.assertEquals("设置成功!", setCurrentChild1);
    }

    @Test(description = "update 接口。修改昵称，name和nickname都需要修改", groups = {"update_test"})
    public void test1() {
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

    @AfterGroups(groups = {"update_test"}, description = "恢复原始昵称")
    public void after_update_test() {
        String define_name = "接口测试专用子女";
        //2、修改子女姓名
        PLParenthood plParenthood = new PLParenthood();
        plParenthood.setUpdatechild(childId, define_name);
        JSONObject updateChild = modParenthood.updateChild(plParenthood);
        SampleAssert.assertEquals("设置成功!", updateChild);
    }

    @Test(description = "家长不能添加重复昵称的子女", groups = {"repeat_name_test"})
    public void test2() {
        String childName = "asd228";

        //1、添加子女
        JSONObject addChild = parent.addChild(childName);
        SampleAssert.assertEquals("添加成功", addChild);
        String userId = addChild.getJSONObject("data").getString("userId");

        // 2、第二次重复添加，报错
        JSONObject addChild2 = parent.addChild(childName);
        Assert.assertEquals("同名子女已存在!", addChild2.getString("msg"));
    }

    @AfterGroups(groups = {"repeat_name_test"})
    public void after_repeat_name_test() {
        //6、查看子女列表查看是否解绑
        JSONObject childs = parent.getChilds();

        for (Object object : childs.getJSONArray("data")) {
            JSONObject child = (JSONObject) object;
            if (!childId.equals(child.getString("id"))) {
                JSONObject deleteChild = parent.deleteChild(child.getString("id"));
                Assert.assertEquals("解除亲子关系", deleteChild.getString("msg"));
            }
        }
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
    @Test(description = "正常流程")
    public void test11() {
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


    private KCParent parent1;
    private KCParent parent2;
    private String bind_child;

    @Test(description = "通过亲子绑定码，绑定子女", groups = {"bind_test"})
    public void test3() {
        parent1 = new KCParent("robot0100", "111111");
        parent2 = new KCParent("robot0200", "111111");

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

    @AfterGroups(groups = {"bind_test"})
    public void after_bind_test() {
        //用例成功。双父母删除子女，恢复数据
        parent1.deleteChild(bind_child);
        parent2.deleteChild(bind_child);
    }


}
