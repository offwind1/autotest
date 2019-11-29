package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.PayInterface;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class PayAgent extends MODBase<PayAgent> {
    public static PayInterface payInterface = Requests.getService(PayInterface.class);

    public PayAgent(User executor) {
        super(executor);
        interfaced = payInterface;
    }


    /**
     * 获得充值图标
     *
     * @param javaBean rateList
     * @return
     */
    @Step("获得充值图标")
    public JSONObject rateList(PLJavaBean javaBean) {
        return exec("rateList", javaBean);
    }

    /**
     * 用户充值
     *
     * @param javaBean usrRecharge
     * @return
     */
    @Step("用户充值")
    public JSONObject usrRecharge(PLJavaBean javaBean) {
        return exec("usrRecharge", javaBean);
    }

    /**
     * 用户购买课程
     *
     * @param javaBean buyLesson
     * @return
     */
    @Step("用户购买课程")
    public JSONObject buyLesson(PLJavaBean javaBean) {
        return exec("buyLesson", javaBean);
    }

    /**
     * 购买资源
     *
     * @param coursewareId 资源id
     * @param userId    用户id
     * @return
     */
    @Step("购买资源")
    public JSONObject buyCourseware(String coursewareId, String userId) {
        return exec("buyCourseware", Parameter.creat()
                .add("coursewareId", coursewareId).add("userId", userId));
    }

    /**
     * 获取Ping++支付凭证
     *
     * @param rateId   充值标识（来源界面1=充值图标ID，购买课程=课程ID，购买资源=资源ID）
     * @param rateType 支付渠道 alipay,wx
     * @param channel  充值来源界面，1充值界面充值，2课程界面充值，3课件资源界面充值,11购买课程，12购买课件
     * @return
     */
    @Step("获取Ping++支付凭证")
    public JSONObject getPingxx(String rateId, String rateType, String channel) {
        return exec("getPingxx", Parameter.creat()
                .add("rateId", rateId)
                .add("rateType", rateType)
                .add("channel", channel));
    }

    /**
     * 购买免费课程
     *
     * @param rateId 购买课程=课程ID
     * @return
     */
    @Step("购买免费课程")
    public JSONObject getPingxx(String rateId) {
        return getPingxx(rateId, "11", "");
    }


    /**
     * 查询用户充值记录
     *
     * @return
     */
    @Step("查询用户充值记录")
    public JSONObject userTrans() {
        return exec("userTrans");
    }

    /**
     * 获取提现账号
     *
     * @param javaBean drawAccount(删除，新接口查看“钱包”分组)
     * @return
     */
    @Step("获取提现账号")
    public JSONObject drawAccount(PLJavaBean javaBean) {
        return exec("drawAccount(删除，新接口查看“钱包”分组)", javaBean);
    }

    /**
     * 提现申请
     *
     * @param javaBean drawApply(删除，新接口查看“钱包”分组)
     * @return
     */
    @Step("提现申请")
    public JSONObject drawApply(PLJavaBean javaBean) {
        return exec("drawApply(删除，新接口查看“钱包”分组)", javaBean);
    }

    /**
     * 扫码支付（支付宝或微信）
     *
     * @param javaBean getPingxxScan
     * @return
     */
    @Step("扫码支付（支付宝或微信）")
    public JSONObject getPingxxScan(PLJavaBean javaBean) {
        return exec("getPingxxScan", javaBean);
    }

    /**
     * 苹果支付成功后调用
     *
     * @param javaBean applePayReturn
     * @return
     */
    @Step("苹果支付成功后调用")
    public JSONObject applePayReturn(PLJavaBean javaBean) {
        return exec("applePayReturn", javaBean);
    }

    /**
     * 获取充值图标
     *
     * @param javaBean rateListForWeb
     * @return
     */
    @Step("获取充值图标")
    public JSONObject rateListForWeb(PLJavaBean javaBean) {
        return exec("rateListForWeb", javaBean);
    }

    /**
     * web微信充值
     *
     * @param javaBean webUsrRecharge
     * @return
     */
    @Step("web微信充值")
    public JSONObject webUsrRecharge(PLJavaBean javaBean) {
        return exec("webUsrRecharge", javaBean);
    }

    /**
     * 获取微信、支付宝二维码
     *
     * @param javaBean getNative
     * @return
     */
    @Step("获取微信、支付宝二维码")
    public JSONObject getNative(PLJavaBean javaBean) {
        return exec("getNative", javaBean);
    }

    /**
     * 获得充值图标(IOS端)
     *
     * @param javaBean rateForApple
     * @return
     */
    @Step("获得充值图标(IOS端)")
    public JSONObject rateForApple(PLJavaBean javaBean) {
        return exec("rateForApple", javaBean);
    }

    /**
     * 转换橙币，和橙时光(IOS)
     *
     * @param javaBean convertAmout
     * @return
     */
    @Step("转换橙币，和橙时光(IOS)")
    public JSONObject convertAmout(PLJavaBean javaBean) {
        return exec("convertAmout", javaBean);
    }

}
