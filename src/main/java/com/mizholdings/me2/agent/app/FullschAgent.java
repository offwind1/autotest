package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.FullschInterface;
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

    public class TYPE {
        public static final String LESSON = "1";
        public static final String COURSE = "2";
        public static final String TEACHER = "3";
        public static final String JIGOU = "4";
    }

    public class GRADEID {
        public static final String ONE = "1";
        public static final String TWO = "2";
        public static final String THREE = "3";
        public static final String FOUR = "4";
        public static final String FIVE = "5";
        public static final String SIX = "6";
        public static final String SEVEN = "7";
        public static final String EIGHT = "8";
        public static final String NINE = "9";
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
    public JSONObject searchAll2(String keyword, String type, String gradeId) {
        return exec("searchAll2", Parameter.creat()
                .add("page", "1")
                .add("keyword", keyword)
                .add("type", type)
                .add("gradeId", gradeId)
                .add("grade", Grade.getGrade(gradeId)));
    }
}


class Grade {
    private static Grade singleton = null;
    private Map<String, String> gradeMap = new HashMap<>();

    private Grade() {
        gradeMap.put("1", "一年级");
        gradeMap.put("2", "二年级");
        gradeMap.put("3", "三年级");
        gradeMap.put("4", "四年级");
        gradeMap.put("5", "五年级");
        gradeMap.put("6", "六年级");
        gradeMap.put("7", "七年级");
        gradeMap.put("8", "八年级");
        gradeMap.put("9", "九年级");
        gradeMap.put("10", "高一");
        gradeMap.put("11", "高二");
        gradeMap.put("12", "高三");
    }

    private static Grade init() {
        if (singleton == null) {
            singleton = new Grade();
        }
        return singleton;
    }

    public static String getGrade(String gradeId) {
        return init().gradeMap.get(gradeId);
    }

}