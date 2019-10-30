package com.mizholdings.kacha.cases;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.Teacher;
import com.mizholdings.kacha.model.UserModel;
import com.myreport.Title;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Date;

public class TestUserCase {

    Teacher teacher;

    @BeforeClass
    public void beforeClass() {
        teacher = new Teacher("cs0002", "111111");
    }

    /**
     * 修改密码测试
     */
//    @Test
    public void test1() {
        teacher.updatePassword("111111", "222222");

        JSONObject object = teacher.login("cs0002", "222222");
        Assert.assertEquals(object.getString("msg"), "登入成功！");

        teacher.updatePassword("222222", "111111");
        object = teacher.login("cs0002", "111111");
        Assert.assertEquals(object.getString("msg"), "登入成功！");
    }

    /**
     * 修改用户信息
     */
    @Test
    @Title("修改用户信息")
    public void test2() {
        JSONObject userInfo = teacher.getUserInfo();
        String id = userInfo.getJSONObject("data").getString("id");

        Date now = new Date();
        String name = "修改用户名" + now.getTime();
        String nickname = "修改昵称" + now.getTime();
        String avatarUrl = "http://images.mizholdings.com/face/default/01.gif";
        String phone = "1333" + (int) ((Math.random() * 9 + 1) * 100000);
        String phoneNumber = "1222" + (int) ((Math.random() * 9 + 1) * 100000);

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setNickname(nickname);
        userModel.setAvatarUrl(avatarUrl);
        userModel.setPhone(phone);
        userModel.setPhoneNumber(phoneNumber);

        JSONObject updateUserInfo = teacher.updateUserInfo(id, userModel);

        Assert.assertEquals("更新成功", updateUserInfo.getString("msg"));
        Assert.assertEquals(name, updateUserInfo.getJSONObject("data").getString("name"));
        Assert.assertEquals(avatarUrl, updateUserInfo.getJSONObject("data").getString("avatarUrl"));
        Assert.assertEquals(phoneNumber, updateUserInfo.getJSONObject("data").getString("phoneNumber"));
    }

}
