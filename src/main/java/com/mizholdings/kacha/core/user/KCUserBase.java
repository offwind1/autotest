package com.mizholdings.kacha.core.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.interfaces.AuthInterface;
import com.mizholdings.kacha.interfaces.UserInterface;
import com.mizholdings.kacha.playload.PLUser;
import com.mizholdings.util.Requests;
import com.mizholdings.util.User;
import org.testng.Assert;

public class KCUserBase extends User {
    protected static AuthInterface authInterface = Requests.getService(AuthInterface.class);
    protected static UserInterface userInterface = Requests.getService(UserInterface.class);
    protected String token;
    protected String userId;
    protected String project;


    public KCUserBase(String project, String account, String password) {
        this.project = project;
        JSONObject object = login(account, password);
        Assert.assertEquals("登入成功！", object.getString("msg"));
    }

    public JSONObject login(String account, String password) {
        JSONObject object = Requests.getJson(authInterface.login(this.project, account, password));
        token = object.getJSONObject("data").getString("token");
        userId = object.getJSONObject("data").getString("id");
        return object;
    }

    /**
     * 1.4.1 获取用户权限
     *
     * @return
     */
    public JSONObject getPermissionInfo() {
        JSONObject object = Requests.getJson(authInterface.getPermissionInfo(token));
        return object;
    }

    /**
     * 修改用户信息
     *
     * @param object {
     *               id: 用户id
     *               *name:用户姓名
     *               *nickname：用户展示的名称
     *               *avatarUrl:头像地址
     *               *phone:登入电话号码
     *               *phoneNumber：记录的电话号码
     *               }
     * @return
     */
    public JSONObject updateUserInfo(JSONObject object) {
        return Requests.getJson(userInterface.updateUserInfo(token, Requests.getJsonRequestBody(object)));
    }

    public JSONObject updateUserInfo(String userId, PLUser userModel) {
        JSONObject object = new JSONObject();
        object.put("id", userId);

        if (userModel.getName() != null) {
            object.put("name", userModel.getName());
        }
        if (userModel.getNickname() != null) {
            object.put("nickname", userModel.getNickname());
        }
        if (userModel.getAvatarUrl() != null) {
            object.put("avatarUrl", userModel.getAvatarUrl());
        }
        if (userModel.getPhone() != null) {
            object.put("phone", userModel.getPhone());
        }
        if (userModel.getPhoneNumber() != null) {
            object.put("phoneNumber", userModel.getPhoneNumber());
        }
        return updateUserInfo(object);
    }

    /**
     * 2.1.1 用户信息
     *
     * @param userId
     * @return
     */
    public JSONObject getUserInfo(String userId) {
        return Requests.getJson(userInterface.getUserInfo(token, userId));
    }

    /**
     * 2.1.1 用户信息
     *
     * @return
     */
    public JSONObject getUserInfo() {
        return getUserInfo("");
    }

    /**
     * 2.1.2 用户外部信息
     *
     * @return
     */
    public JSONObject getOutInfo() {
        return Requests.getJson(userInterface.outInfo(token));
    }

    /**
     * 2.2.3 修改密码
     *
     * @param oldPwd 旧密码
     * @param newPwd 新密码
     * @return
     */
    public JSONObject updatePassword(String oldPwd, String newPwd) {
        return Requests.getJson(userInterface.updatePassword(token, oldPwd, newPwd));
    }

    /**
     * 2.4.1获取短信随机码
     *
     * @param phone
     * @return
     */
    public JSONObject getPhoneRandom(String phone) {
        return Requests.getJson(userInterface.getPhoneRandom(token, phone));
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }
}
