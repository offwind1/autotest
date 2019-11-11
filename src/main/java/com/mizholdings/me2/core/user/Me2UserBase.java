package com.mizholdings.me2.core.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.core.mod.MODClassInfo;
import com.mizholdings.me2.core.mod.MODLessonInfo;
import com.mizholdings.me2.core.mod.MODMobile;
import com.mizholdings.me2.core.mod.MODPay;
import com.mizholdings.me2.interfaces.api.MobileInterface;
import com.mizholdings.me2.playload.PLLessonInfo;
import com.mizholdings.me2.playload.PLMobile;
import com.mizholdings.me2.playload.PLPay;
import com.mizholdings.util.Funcs;
import com.mizholdings.util.Requests;
import com.mizholdings.util.SampleAssert;
import com.mizholdings.util.User;
import io.qameta.allure.Step;
import org.testng.Assert;

public class Me2UserBase extends User {
    public static MobileInterface mobileInterface = Requests.getService(MobileInterface.class);

    protected String token;
    protected String userId;
    protected String cloudUsrAccount;

    protected MODMobile modMobile;
    protected MODPay modPay;
    protected MODLessonInfo modLessonInfo;
    protected MODClassInfo modClassInfo;

    public Me2UserBase(String account, String password) {
        JSONObject object = login(account, password);
        SampleAssert.assertEquals("登陆成功", object);

        token = object.getJSONObject("data").getString("token");
        userId = object.getJSONObject("data").getString("userId");
        cloudUsrAccount = object.getJSONObject("data").getString("cloudUsrAccount");

        modMobile = new MODMobile(this);
        modPay = new MODPay(this);
        modLessonInfo = new MODLessonInfo(this);
        modClassInfo = new MODClassInfo(this);
    }

    public JSONObject login(String account, String password) {
        PLMobile plMobile = new PLMobile();
        plMobile.setLogin(account, password);
        return Requests.getJson(mobileInterface.login(Funcs.javabeanToMap(plMobile)));
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    public String getCloudUsrAccount() {
        return cloudUsrAccount;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @Step("获取用户信息")
    public JSONObject userInfo() {
        return modMobile.userInfo();
    }

    /**
     * 查询用户充值记录
     *
     * @return
     */
    public JSONObject userTrans() {
        PLPay plPay = new PLPay();
        plPay.setUserTrans("1", "0");

        return modPay.userTrans(plPay);
    }

    /**
     * 点赞课程
     *
     * @param lessonId string,课程ID
     * @return
     */
    public JSONObject likedLesson(String lessonId) {
        PLLessonInfo plLessonInfo = new PLLessonInfo();
        plLessonInfo.setLikedLesson(lessonId);
        return modLessonInfo.likedLesson(plLessonInfo);
    }

}
