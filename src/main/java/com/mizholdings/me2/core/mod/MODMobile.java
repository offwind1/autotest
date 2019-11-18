package com.mizholdings.me2.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.MobileInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODMobile extends MODBase<MODMobile> {

    public static MobileInterface mobileInterface = Requests.getService(MobileInterface.class);

    public MODMobile(Me2UserBase executor) {
        super(executor);
        interfaced = mobileInterface;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public JSONObject userInfo() {
        return exec("userInfo");
    }


    /**
     * 获取验证码(手机/邮箱)
     *
     * @param javaBean phoneCode
     * @return
     */
    public JSONObject phoneCode(PLJavaBean javaBean) {
        return exec("phoneCode", javaBean);
    }

    /**
     * 用户登陆(手机/邮箱/用户名)
     *
     * @param javaBean login
     * @return
     */
    public JSONObject login(PLJavaBean javaBean) {
        return exec("login", javaBean);
    }

    /**
     * token自动登陆
     *
     * @param javaBean tokenLogin
     * @return
     */
    public JSONObject tokenLogin(PLJavaBean javaBean) {
        return exec("tokenLogin", javaBean);
    }

    /**
     * 用户退出
     *
     * @param javaBean loginOut
     * @return
     */
    public JSONObject loginOut(PLJavaBean javaBean) {
        return exec("loginOut", javaBean);
    }
    
    /**
     * 用户注册(手机号/账号/邮箱)
     *
     * @param javaBean userRegister
     * @return
     */
    public JSONObject userRegister(PLJavaBean javaBean) {
        return exec("userRegister", javaBean);
    }

    /**
     * 忘记密码
     *
     * @param javaBean findPassword
     * @return
     */
    public JSONObject findPassword(PLJavaBean javaBean) {
        return exec("findPassword", javaBean);
    }

    /**
     * 修改手机号或者邮箱
     *
     * @param javaBean updateContact
     * @return
     */
    public JSONObject updateContact(PLJavaBean javaBean) {
        return exec("updateContact", javaBean);
    }

    /**
     * 修改用户信息
     *
     * @param javaBean updateUserInfo
     * @return
     */
    public JSONObject updateUserInfo(PLJavaBean javaBean) {
        return exec("updateUserInfo", javaBean);
    }

    /**
     * 根据用户CODE，获得云信ID
     *
     * @param javaBean userByCode
     * @return
     */
    public JSONObject userByCode(PLJavaBean javaBean) {
        return exec("userByCode", javaBean);
    }

    /**
     * 根据ID获得用户信息
     *
     * @param javaBean userInfoById
     * @return
     */
    public JSONObject userInfoById(PLJavaBean javaBean) {
        return exec("userInfoById", javaBean);
    }

    /**
     * 收藏用户
     *
     * @param javaBean keepUser
     * @return
     */
    public JSONObject keepUser(PLJavaBean javaBean) {
        return exec("keepUser", javaBean);
    }

    /**
     * 取消收藏
     *
     * @param javaBean rmkeepUser
     * @return
     */
    public JSONObject rmkeepUser(PLJavaBean javaBean) {
        return exec("rmkeepUser", javaBean);
    }

    /**
     * 机构用户管理的教师列表
     *
     * @param javaBean orgUserList
     * @return
     */
    public JSONObject orgUserList(PLJavaBean javaBean) {
        return exec("orgUserList", javaBean);
    }

    /**
     * 用户修改密码
     *
     * @param javaBean updatePassword
     * @return
     */
    public JSONObject updatePassword(PLJavaBean javaBean) {
        return exec("updatePassword", javaBean);
    }

    /**
     * 用户绑定手机(验证码类型为4)
     *
     * @param javaBean bingPhone
     * @return
     */
    public JSONObject bingPhone(PLJavaBean javaBean) {
        return exec("bingPhone", javaBean);
    }

    /**
     * 第三方登陆
     *
     * @param javaBean otherLogin
     * @return
     */
    public JSONObject otherLogin(PLJavaBean javaBean) {
        return exec("otherLogin", javaBean);
    }

    /**
     * APP扫码，登录页面端
     *
     * @param javaBean login2
     * @return
     */
    public JSONObject login2(PLJavaBean javaBean) {
        return exec("login2", javaBean);
    }

    /**
     * 机构用户/教师的课件(微课)
     *
     * @param javaBean orgCourseList
     * @return
     */
    public JSONObject orgCourseList(PLJavaBean javaBean) {
        return exec("orgCourseList", javaBean);
    }

    /**
     * 扫码登陆web接口
     *
     * @param javaBean scanLogin
     * @return
     */
    public JSONObject scanLogin(PLJavaBean javaBean) {
        return exec("scanLogin", javaBean);
    }

    /**
     * 分享页面注册
     *
     * @param javaBean shareUserRegister
     * @return
     */
    public JSONObject shareUserRegister(PLJavaBean javaBean) {
        return exec("shareUserRegister", javaBean);
    }

    /**
     * 根据手机获取用户信息
     *
     * @param javaBean getUserInfoByPhone
     * @return
     */
    public JSONObject getUserInfoByPhone(PLJavaBean javaBean) {
        return exec("getUserInfoByPhone", javaBean);
    }

    /**
     * 增加用户的米猪时光
     *
     * @param javaBean getMizhuTime
     * @return
     */
    public JSONObject getMizhuTime(PLJavaBean javaBean) {
        return exec("getMizhuTime", javaBean);
    }

    /**
     * ISO系统登陆
     *
     * @param javaBean appleLogin
     * @return
     */
    public JSONObject appleLogin(PLJavaBean javaBean) {
        return exec("appleLogin", javaBean);
    }


}
