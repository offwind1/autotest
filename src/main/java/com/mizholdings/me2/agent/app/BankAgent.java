package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class BankAgent extends MODBase<BankAgent> {

    public BankAgent(User executor) {
        super(executor);
    }


    /**
     * 银行列表
     *
     * @return json
     */
    @Step("银行列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
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
     * 设置支付密码
     *
     * @return json
     */
    @Step("设置支付密码")
    public JSONObject paypwd(Parameter parameter) {
        return exec("paypwd", parameter);
    }

    /**
     * 申请提现
     *
     * @return json
     */
    @Step("申请提现")
    public JSONObject drawApply(Parameter parameter) {
        return exec("drawApply", parameter);
    }

    /**
     * 绑定银行卡
     *
     * @return json
     */
    @Step("绑定银行卡")
    public JSONObject binding(Parameter parameter) {
        return exec("binding", parameter);
    }

    /**
     * 解除银行卡绑定
     *
     * @return json
     */
    @Step("解除银行卡绑定")
    public JSONObject rmBinding(Parameter parameter) {
        return exec("rmBinding", parameter);
    }

    /**
     * 用户钱包主界面
     *
     * @return json
     */
    @Step("用户钱包主界面")
    public JSONObject userWallet(Parameter parameter) {
        return exec("userWallet", parameter);
    }

    /**
     * 用户直播界面数据
     *
     * @return json
     */
    @Step("用户直播界面数据")
    public JSONObject userDirect(Parameter parameter) {
        return exec("userDirect", parameter);
    }


}