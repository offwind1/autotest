package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class PayAgent extends MODBase<PayAgent> {
//    public static PayInterface payInterface = Requests.getService(PayInterface.class);

    public PayAgent(User executor) {
        super(executor);
//        interfaced = payInterface;
    }


    /**
     * 购买资源
     *
     * @param coursewareId 资源id
     * @param userId       用户id
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
     * 获得充值图标
     *
     * @return json
     */
    @Step("获得充值图标")
    public JSONObject rateList(Parameter parameter) {
        return exec("rateList", parameter);
    }

    /**
     * 用户充值
     *
     * @return json
     */
    @Step("用户充值")
    public JSONObject usrRecharge(Parameter parameter) {
        return exec("usrRecharge", parameter);
    }

    /**
     * 用户购买课程
     *
     * @return json
     */
    @Step("用户购买课程")
    public JSONObject buyLesson(Parameter parameter) {
        return exec("buyLesson", parameter);
    }

    public JSONObject buyLesson(String userId, String lessonId) {
        return buyLesson(Parameter.creat()
//                .add()
        );
    }


    /**
     * 购买资源
     *
     * @return json
     */
    @Step("购买资源")
    public JSONObject buyCourseware(Parameter parameter) {
        return exec("buyCourseware", parameter);
    }

    /**
     * 获取Ping++支付凭证
     *
     * @return json
     */
    @Step("获取Ping++支付凭证")
    public JSONObject getPingxx(Parameter parameter) {
        return exec("getPingxx", parameter);
    }

    /**
     * 查询用户充值记录
     *
     * @return json
     */
    @Step("查询用户充值记录")
    public JSONObject userTrans(Parameter parameter) {
        return exec("userTrans", parameter);
    }

    /**
     * 获取提现账号
     *
     * @return json
     */
    @Step("获取提现账号")
    public JSONObject drawAccount(Parameter parameter) {
        return exec("drawAccount", parameter);
    }

    /**
     * 提现申请
     *
     * @return json
     */
    @Step("提现申请")
    public JSONObject drawApply(Parameter parameter) {
        return exec("drawApply", parameter);
    }

    /**
     * 扫码支付（支付宝或微信）
     *
     * @return json
     */
    @Step("扫码支付（支付宝或微信）")
    public JSONObject getPingxxScan(Parameter parameter) {
        return exec("getPingxxScan", parameter);
    }

    /**
     * 苹果支付成功后调用
     *
     * @return json
     */
    @Step("苹果支付成功后调用")
    public JSONObject applePayReturn(Parameter parameter) {
        return exec("applePayReturn", parameter);
    }

    /**
     * 获取充值图标
     *
     * @return json
     */
    @Step("获取充值图标")
    public JSONObject rateListForWeb(Parameter parameter) {
        return exec("rateListForWeb", parameter);
    }

    /**
     * web微信充值
     *
     * @return json
     */
    @Step("web微信充值")
    public JSONObject webUsrRecharge(Parameter parameter) {
        return exec("webUsrRecharge", parameter);
    }

    /**
     * 获取微信、支付宝二维码
     *
     * @return json
     */
    @Step("获取微信、支付宝二维码")
    public JSONObject getNative(Parameter parameter) {
        return exec("getNative", parameter);
    }

    /**
     * 获得充值图标(IOS端)
     *
     * @return json
     */
    @Step("获得充值图标(IOS端)")
    public JSONObject rateForApple(Parameter parameter) {
        return exec("rateForApple", parameter);
    }

    /**
     * 转换橙币，和橙时光(IOS)
     *
     * @return json
     */
    @Step("转换橙币，和橙时光(IOS)")
    public JSONObject convertAmout(Parameter parameter) {
        return exec("convertAmout", parameter);
    }

}
