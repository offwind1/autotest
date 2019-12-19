package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class HlpAgent extends MODBase<HlpAgent> {

    public HlpAgent(User executor) {
        super(executor);
    }


    
    /**
     * 根据ID获取好友助力列表（最近的前10个）
     *
     * @return json
     */
    @Step("根据ID获取好友助力列表（最近的前10个）")
    public JSONObject getHlpList(Parameter parameter) {
        return exec("getHlpList", parameter);
    }
    
    /**
     *  根据code判断是否老用户，老用户则返回用户信息，新用户则不返回
     *
     * @return json
     */
    @Step(" 根据code判断是否老用户，老用户则返回用户信息，新用户则不返回")
    public JSONObject getWxUserInfo(Parameter parameter) {
        return exec("getWxUserInfo", parameter);
    }
    
    /**
     * 老用户绑定微信账号（暂时不用）
     *
     * @return json
     */
    @Step("老用户绑定微信账号（暂时不用）")
    public JSONObject bangdingWX(Parameter parameter) {
        return exec("bangdingWX", parameter);
    }
    
    /**
     * 参加助力
     *
     * @return json
     */
    @Step("参加助力")
    public JSONObject joinHelp(Parameter parameter) {
        return exec("joinHelp", parameter);
    }
    
    /**
     * 助力榜单
     *
     * @return json
     */
    @Step("助力榜单")
    public JSONObject getTopList(Parameter parameter) {
        return exec("getTopList", parameter);
    }
    
    /**
     * 获取WX签名字段
     *
     * @return json
     */
    @Step("获取WX签名字段")
    public JSONObject getWxsign(Parameter parameter) {
        return exec("getWxsign", parameter);
    }
    
    /**
     * 领取助力积分活动
     *
     * @return json
     */
    @Step("领取助力积分活动")
    public JSONObject helperReward(Parameter parameter) {
        return exec("helperReward", parameter);
    }
    

}