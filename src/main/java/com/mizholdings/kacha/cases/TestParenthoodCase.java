package com.mizholdings.kacha.cases;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.Parent;
import com.mizholdings.kacha.core.Teacher;
import com.mizholdings.util.SampleAssert;
import com.myreport.Title;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class TestParenthoodCase {


    Parent parent;

    @BeforeClass
    public void beforeClass() {
        parent = new Parent("cs0002", "111111");
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
    @Test
    @Title("正常流程")
    public void test1() {
        String childName = "asd228";
        //1、添加子女
        JSONObject addChild = parent.addChild(childName);
        Assert.assertEquals("添加成功", addChild.getString("msg"));
        String userId = addChild.getJSONObject("data").getString("userId");

        //2、修改子女姓名
        JSONObject updateChild = parent.updateChild(userId, childName + "new");
        Assert.assertEquals("设置成功!", updateChild.getString("msg"));

        //3、设置该子女为当前子女
        JSONObject setCurrentChild = parent.setCurrentChild(userId);
        Assert.assertEquals("设置成功!", setCurrentChild.getString("msg"));

        //4、获取当前子女信息
        JSONObject getCurrentChild = parent.getCurrentChild();
        Assert.assertEquals(userId, getCurrentChild.getJSONObject("data").getString("id"));

        //5、解绑子女
        JSONObject deleteChild = parent.deleteChild(userId);
        Assert.assertEquals("解除亲子关系", deleteChild.getString("msg"));

        //6、查看子女列表查看是否解绑
        JSONObject childs = parent.getChilds();

        for (Object object : childs.getJSONArray("data")) {
            JSONObject jsonObject = (JSONObject) object;
            Assert.assertNotEquals(userId, jsonObject.getString("id"));
        }
    }


    /**
     * 不能重复添加子女
     */
    @Test
    @Title("不能重复添加子女")
    public void test2() {
        String childName = "aaa223";

        // 1、第一次添加子女成功
        JSONObject child = parent.addChild(childName);
        Assert.assertEquals("添加成功", child.getString("msg"));
        String userId = child.getJSONObject("data").getString("userId");

        // 2、第二次重复添加，报错
        child = parent.addChild(childName);
        Assert.assertEquals("同名子女已存在!", child.getString("msg"));

        //3、删除子女，恢复数据
        JSONObject deleteChild = parent.deleteChild(userId);
        Assert.assertEquals("解除亲子关系", deleteChild.getString("msg"));
    }


    @Test
    @Title("通过亲子绑定码，绑定子女")
    public void test3() {
        Parent parent1 = new Parent("robot0100", "111111");
        Parent parent2 = new Parent("robot0200", "111111");

        // 父母1，添加子女
        JSONObject addChild = parent1.addChild("绑定测试生成子女");
        Assert.assertEquals("添加成功", addChild.getString("msg"));
        String userId = addChild.getJSONObject("data").getString("userId");

        //生成子女的绑定码
        JSONObject bindCode = parent1.bindCode(userId);
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
            return userId.equals(o.getString("id"));
        }).collect(Collectors.toList());
        Assert.assertTrue(test.size() > 0);

        //用例成功。双父母删除子女，恢复数据
        parent1.deleteChild(userId);
        parent2.deleteChild(userId);
    }
}
