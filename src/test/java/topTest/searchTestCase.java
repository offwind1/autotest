package topTest;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.agent.app.FullschAgent;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.me2.user.serve.ServeBase;
import org.testng.annotations.Test;

public class searchTestCase {

    private UserBase student = Global.init().getUserBase();

    @Test(description = "首页搜索课程，搜索结果完整性判断")
    public void searchAll2_classroomCount() {

        JSONObject object = student.getApp().fullschAgent().searchAll2("接口", FullschAgent.TYPE.LESSON, ServeBase.GRADEID.ONE);
        object.getJSONObject("data").getJSONArray("resultList").stream().forEach(i -> {
            JSONObject o = (JSONObject) i;
            if (!o.containsKey("classroomCount")) {
                throw new RuntimeException("没有classroomCount" + o.toJSONString());
            }
        });

        object.getJSONObject("data").getJSONArray("resultList").stream().forEach(i -> {
            JSONObject o = (JSONObject) i;
            if (!o.containsKey("faceImg")) {
                throw new RuntimeException("没有faceImg" + o.toJSONString());
            }
        });
    }

}
