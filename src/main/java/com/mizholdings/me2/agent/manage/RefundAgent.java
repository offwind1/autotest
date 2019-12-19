package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class RefundAgent extends MODBase<RefundAgent> {

    public RefundAgent(User executor) {
        super(executor);
    }


    
    /**
     * 退课记录
     *
     * @return json
     */
    @Step("退课记录")
    public JSONObject refundList(Parameter parameter) {
        return exec("refundList", parameter);
    }
    
    /**
     * 退课老师审批
     *
     * @return json
     */
    @Step("退课老师审批")
    public JSONObject teacherApply(Parameter parameter) {
        return exec("teacherApply", parameter);
    }
    
    /**
     * 退款流程查询
     *
     * @return json
     */
    @Step("退款流程查询")
    public JSONObject refundInfo(Parameter parameter) {
        return exec("refundInfo", parameter);
    }
    
    /**
     * 退款金额查询
     *
     * @return json
     */
    @Step("退款金额查询")
    public JSONObject refundMoney(Parameter parameter) {
        return exec("refundMoney", parameter);
    }
    
    /**
     * 老师主动退款
     *
     * @return json
     */
    @Step("老师主动退款")
    public JSONObject teahcerDelStu(Parameter parameter) {
        return exec("teahcerDelStu", parameter);
    }
    

}