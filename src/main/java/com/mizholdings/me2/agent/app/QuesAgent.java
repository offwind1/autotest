package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class QuesAgent extends MODBase<QuesAgent> {

    public QuesAgent(User executor) {
        super(executor);
    }


    
    /**
     * 题目类型查询
     *
     * @return json
     */
    @Step("题目类型查询")
    public JSONObject getQuestionType(Parameter parameter) {
        return exec("getQuestionType", parameter);
    }
    
    /**
     * 题库查询
     *
     * @return json
     */
    @Step("题库查询")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }
    
    /**
     * 根据ID查询题目
     *
     * @return json
     */
    @Step("根据ID查询题目")
    public JSONObject getQuestionById(Parameter parameter) {
        return exec("getQuestionById", parameter);
    }
    
    /**
     * 学生答题
     *
     * @return json
     */
    @Step("学生答题")
    public JSONObject studentAnswer(Parameter parameter) {
        return exec("studentAnswer", parameter);
    }
    
    /**
     * 根据题目ID，获取用户答案列表
     *
     * @return json
     */
    @Step("根据题目ID，获取用户答案列表")
    public JSONObject questionAnswerList(Parameter parameter) {
        return exec("questionAnswerList", parameter);
    }
    
    /**
     * 老师评语和批改
     *
     * @return json
     */
    @Step("老师评语和批改")
    public JSONObject teacherComment(Parameter parameter) {
        return exec("teacherComment", parameter);
    }
    
    /**
     * 课堂答题统计
     *
     * @return json
     */
    @Step("课堂答题统计")
    public JSONObject questionAnswerStatistics(Parameter parameter) {
        return exec("questionAnswerStatistics", parameter);
    }
    
    /**
     * 根据题目ID集合拿到题目
     *
     * @return json
     */
    @Step("根据题目ID集合拿到题目")
    public JSONObject getQuestionByIds(Parameter parameter) {
        return exec("getQuestionByIds", parameter);
    }
    
    /**
     * 老师在课堂中添加试题使用，为了统计本堂课一共有多少试题
     *
     * @return json
     */
    @Step("老师在课堂中添加试题使用，为了统计本堂课一共有多少试题")
    public JSONObject joinQuestions(Parameter parameter) {
        return exec("joinQuestions", parameter);
    }
    

}