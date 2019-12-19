package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class VoteAgent extends MODBase<VoteAgent> {
//    public static VoteInterface voteInterface = Requests.getService(VoteInterface.class);

    public VoteAgent(User executor) {
        super(executor);
//        interfaced = voteInterface;
    }


    /**
     * 老师发起投票
     *
     * @return
     */
    public JSONObject insert() {
        return exec("insert", Parameter.creat());
    }


    /**
     * 老师发起投票
     *
     * @return json
     */
    @Step("老师发起投票")
    public JSONObject insert(Parameter parameter) {
        return exec("insert", parameter);
    }

    /**
     * 查询课堂中所有投票
     *
     * @return json
     */
    @Step("查询课堂中所有投票")
    public JSONObject getList(Parameter parameter) {
        return exec("getList", parameter);
    }

    /**
     * 提交投票结果
     *
     * @return json
     */
    @Step("提交投票结果")
    public JSONObject subOption(Parameter parameter) {
        return exec("subOption", parameter);
    }

    /**
     * 获得投票用户列表
     *
     * @return json
     */
    @Step("获得投票用户列表")
    public JSONObject getOptionUser(Parameter parameter) {
        return exec("getOptionUser", parameter);
    }

    /**
     * 结束投票
     *
     * @return json
     */
    @Step("结束投票")
    public JSONObject voteEnd(Parameter parameter) {
        return exec("voteEnd", parameter);
    }

}