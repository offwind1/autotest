package bugTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.app.FullschAgent;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Allure;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestFullschCase {

    private UserBase student;

    @BeforeClass
    public void beforeClass() {
        student = Global.init().getUserBase();
    }

    @Test(description = "bug8630")
    public void testBug8630() {
        student.setOrgId("8268");
        JSONObject object = student.getApp().fullschAgent().searchAll2("1", FullschAgent.TYPE.LESSON, ServeBase.GRADEID.ONE);
        SampleAssert.assertResult0(object);
    }

    @Test(description = "bug8637")
    public void testBug8637() {
        student.setOrgId("0");
        JSONObject object = student.getApp().fullschAgent().searchAll2("2019", FullschAgent.TYPE.COURSE, ServeBase.GRADEID.ONE);
        SampleAssert.assertResult0(object);

        for (Object i : object.getJSONObject("data").getJSONArray("resultList")) {
            JSONObject o = (JSONObject) i;
            JSONObject temp = student.getApp().courseAgent().coursewareInfo(o.getString("coursewareId"));
            if (temp.getJSONObject("data") == null) {
                throw new RuntimeException("查询资源详情为空");
            }
        }
    }

    @Test(description = "首页搜索测试，搜索不同长度的keyword")
    public void testBug1() {
        String[] strs = {"2", "20", "2019"};
        for (String s : Arrays.asList(strs)) {
            Allure.addAttachment("keyword", s);
            JSONObject object = student.getApp().fullschAgent().searchAll2(s, FullschAgent.TYPE.LESSON, ServeBase.GRADEID.ONE);
            if (object.getJSONObject("data").getJSONArray("resultList").size() == 0) {
                throw new RuntimeException("没有搜索到任何内容");
            }
        }
    }
}
