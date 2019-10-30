package com.mizholdings.me2.cases;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.interfaces.api.TopInterface;
import com.mizholdings.me2.model.User;
import com.mizholdings.me2.core.Global;
import com.mizholdings.util.Requests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TopV2TestCase {

    private TopInterface topInterface = Requests.getService(TopInterface.class);
    private User teacher;

    @BeforeClass
    public void beforeClass() {
        teacher = Global.teacher;
    }

    @Test
    public void v2topList() {
        JSONObject object = Requests.getJson(topInterface.v2topList(teacher.getToken(),
                1, 1, 1));
        Assert.assertEquals(object.getString("msg"), "获取主页列表成功");
    }

    @Test
    public void v2topListByNoToken() {
        JSONObject object = Requests.getJson(topInterface.v2topList("",
                1, 1, 1));
        Assert.assertEquals(object.getString("msg"), "获取主页列表成功");
    }

    @Test
    public void v2playList() {
        JSONObject object = Requests.getJson(topInterface.v2playList(teacher.getToken(),
                1, 1, 1, 1));
        Assert.assertEquals(object.getString("msg"), "获取直播课列表成功");
    }

    @Test
    public void v2playListByNoToken() {
        JSONObject object = Requests.getJson(topInterface.v2playList("",
                1, 1, 1, 1));
        Assert.assertEquals(object.getString("msg"), "获取直播课列表成功");
    }


}
