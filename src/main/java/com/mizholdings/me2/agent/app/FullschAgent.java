package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.*;
import io.qameta.allure.Step;


public class FullschAgent extends MODBase<FullschAgent> {
//    public static FullschInterface fullschInterface = Requests.getService(FullschInterface.class);

    public FullschAgent(User executor) {
        super(executor);
//        interfaced = fullschInterface;
    }

    public enum TYPE {
        LESSON("1"), COURSE("2"), TEACHER("3"), JIGOU("4");
        public String value;

        private TYPE(String value) {
            this.value = value;
        }
    }



    /**
     * 首页搜索2
     *
     * @param keyword 关键字
     * @param type    类型 1课程2课件3老师4机构
     * @param gradeId 年级id
     * @return json
     */
    @Step("首页搜索2")
    public JSONObject searchAll2(String keyword, TYPE type, ServeBase.GRADEID gradeId) {
        return exec("searchAll2", Parameter.creat()
                .add("page", "1")
                .add("keyword", keyword)
                .add("type", type.value)
                .add("gradeId", gradeId.value)
                .add("grade", gradeId.gradeName));
    }


    /**
     * 全文检索
     *
     * @return json
     */
    @Step("全文检索")
    public JSONObject searchAll(Parameter parameter) {
        return exec("searchAll", parameter);
    }

    /**
     * 首页搜索2
     *
     * @return json
     */
    @Step("首页搜索2")
    public JSONObject searchAll2(Parameter parameter) {
        return exec("searchAll2", parameter);
    }



}
