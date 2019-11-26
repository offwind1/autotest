package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.playload.PLUser;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.FullschInterface;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.Map;

public class FullschAgent extends MODBase<FullschAgent> {
    public static FullschInterface fullschInterface = Requests.getService(FullschInterface.class);

    public FullschAgent(User executor) {
        super(executor);
        interfaced = fullschInterface;
    }

    public enum TYPE {
        LESSON("1"), COURSE("2"), TEACHER("3"), JIGOU("4");
        public String value;

        private TYPE(String value) {
            this.value = value;
        }
    }



    /**
     * 全文检索
     *
     * @param javaBean searchAll
     * @return
     */
    @Step("首页搜索")
    public JSONObject searchAll(PLJavaBean javaBean) {
        return exec("searchAll", javaBean);
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
}

//
//class Grade {
//    private static Grade singleton = null;
//    private Map<String, String> gradeMap = new HashMap<>();
//
//    private Grade() {
//        gradeMap.put("1", "一年级");
//        gradeMap.put("2", "二年级");
//        gradeMap.put("3", "三年级");
//        gradeMap.put("4", "四年级");
//        gradeMap.put("5", "五年级");
//        gradeMap.put("6", "六年级");
//        gradeMap.put("7", "七年级");
//        gradeMap.put("8", "八年级");
//        gradeMap.put("9", "九年级");
//        gradeMap.put("10", "高一");
//        gradeMap.put("11", "高二");
//        gradeMap.put("12", "高三");
//    }
//
//    private static Grade init() {
//        if (singleton == null) {
//            singleton = new Grade();
//        }
//        return singleton;
//    }
//
//    public static String getGrade(String gradeId) {
//        return init().gradeMap.get(gradeId);
//    }
//
//}