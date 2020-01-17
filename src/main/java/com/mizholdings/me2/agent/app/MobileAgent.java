package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class MobileAgent extends MODBase<MobileAgent> {

//    public static MobileInterface mobileInterface = Requests.getService(MobileInterface.class);

    public MobileAgent(User executor) {
        super(executor);
//        interfaced = mobileInterface;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @Step("获取用户信息")
    public JSONObject userInfo() {
        return exec("userInfo");
    }


    /**
     * 机构用户管理的教师列表
     *
     * @param userId 机构id
     * @return
     */
    public JSONObject orgUserList(String userId) {
        return exec("orgUserList", Parameter.creat()
                .add("userId", userId));
    }

    /**
     * 机构用户/教师的课件(微课)
     *
     * @param userId 用户id
     * @return
     */
    @Step("机构用户/教师的课件(微课)")
    public JSONObject orgCourseList(String userId) {
        return exec("orgCourseList", Parameter.creat()
                .add("userId", userId)
                .add("page", "1"));
    }


    /**
     * 获取验证码(手机/邮箱)
     *
     * @return json
     */
    @Step("获取验证码(手机/邮箱)")
    public JSONObject phoneCode(Parameter parameter) {
        return exec("phoneCode", parameter);
    }

    /**
     * 用户登陆(手机/邮箱/用户名)
     *
     * @return json
     */
    @Step("用户登陆(手机/邮箱/用户名)")
    public JSONObject login(Parameter parameter) {
        return exec("login", parameter);
    }

    /**
     * token自动登陆
     *
     * @return json
     */
    @Step("token自动登陆")
    public JSONObject tokenLogin(Parameter parameter) {
        return exec("tokenLogin", parameter);
    }

    /**
     * 用户退出
     *
     * @return json
     */
    @Step("用户退出")
    public JSONObject loginOut(Parameter parameter) {
        return exec("loginOut", parameter);
    }

    /**
     * 获取用户信息
     *
     * @return json
     */
    @Step("获取用户信息")
    public JSONObject userInfo(Parameter parameter) {
        return exec("userInfo", parameter);
    }

    /**
     * 用户注册(手机号/账号/邮箱)
     *
     * @return json
     */
    @Step("用户注册(手机号/账号/邮箱)")
    public JSONObject userRegister(Parameter parameter) {
        return exec("userRegister", parameter);
    }

    /**
     * 忘记密码
     *
     * @return json
     */
    @Step("忘记密码")
    public JSONObject findPassword(Parameter parameter) {
        return exec("findPassword", parameter);
    }

    /**
     * 修改手机号或者邮箱
     *
     * @return json
     */
    @Step("修改手机号或者邮箱")
    public JSONObject updateContact(Parameter parameter) {
        return exec("updateContact", parameter);
    }

    /**
     * 修改用户信息
     *
     * @return json
     */
    @Step("修改用户信息")
    public JSONObject updateUserInfo(Parameter parameter) {
        return exec("updateUserInfo", parameter);
    }

    /**
     * 根据用户CODE，获得云信ID
     *
     * @return json
     */
    @Step("根据用户CODE，获得云信ID")
    public JSONObject userByCode(Parameter parameter) {
        return exec("userByCode", parameter);
    }

    /**
     * 根据ID获得用户信息
     *
     * @return json
     */
    @Step("根据ID获得用户信息")
    public JSONObject userInfoById(Parameter parameter) {
        return exec("userInfoById", parameter);
    }

    /**
     * 收藏用户
     *
     * @return json
     */
    @Step("收藏用户")
    public JSONObject keepUser(Parameter parameter) {
        return exec("keepUser", parameter);
    }

    /**
     * 取消收藏
     *
     * @return json
     */
    @Step("取消收藏")
    public JSONObject rmkeepUser(Parameter parameter) {
        return exec("rmkeepUser", parameter);
    }

    /**
     * 机构用户管理的教师列表
     *
     * @return json
     */
    @Step("机构用户管理的教师列表")
    public JSONObject orgUserList(Parameter parameter) {
        return exec("orgUserList", parameter);
    }

    /**
     * 用户修改密码
     *
     * @return json
     */
    @Step("用户修改密码")
    public JSONObject updatePassword(Parameter parameter) {
        return exec("updatePassword", parameter);
    }

    /**
     * 用户绑定手机(验证码类型为4)
     *
     * @return json
     */
    @Step("用户绑定手机(验证码类型为4)")
    public JSONObject bingPhone(Parameter parameter) {
        return exec("bingPhone", parameter);
    }

    /**
     * 第三方登陆
     *
     * @return json
     */
    @Step("第三方登陆")
    public JSONObject otherLogin(Parameter parameter) {
        return exec("otherLogin", parameter);
    }

    /**
     * APP扫码，登录页面端
     *
     * @return json
     */
    @Step("APP扫码，登录页面端")
    public JSONObject login2(Parameter parameter) {
        return exec("login2", parameter);
    }

    /**
     * 机构用户/教师的课件(微课)
     *
     * @return json
     */
    @Step("机构用户/教师的课件(微课)")
    public JSONObject orgCourseList(Parameter parameter) {
        return exec("orgCourseList", parameter);
    }

    /**
     * 扫码登陆web接口
     *
     * @return json
     */
    @Step("扫码登陆web接口")
    public JSONObject scanLogin(Parameter parameter) {
        return exec("scanLogin", parameter);
    }

    /**
     * 分享页面注册
     *
     * @return json
     */
    @Step("分享页面注册")
    public JSONObject shareUserRegister(Parameter parameter) {
        return exec("shareUserRegister", parameter);
    }

    /**
     * 根据手机获取用户信息
     *
     * @return json
     */
    @Step("根据手机获取用户信息")
    public JSONObject getUserInfoByPhone(Parameter parameter) {
        return exec("getUserInfoByPhone", parameter);
    }

    /**
     * 增加用户的米猪时光
     *
     * @return json
     */
    @Step("增加用户的米猪时光")
    public JSONObject getMizhuTime(Parameter parameter) {
        return exec("getMizhuTime", parameter);
    }

    /**
     * ISO系统登陆
     *
     * @return json
     */
    @Step("ISO系统登陆")
    public JSONObject appleLogin(Parameter parameter) {
        return exec("appleLogin", parameter);
    }

}
