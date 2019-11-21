package com.mizholdings.me2.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.me2.interfaces.api.QuesInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;

public class MODQues extends MODBase<MODQues> {
    public static QuesInterface quesInterface = Requests.getService(QuesInterface.class);

    public MODQues(Me2UserBase executor) {
        super(executor);
        interfaced = quesInterface;
    }


   
/**
 * 题目类型查询
 *
 * @param javaBean getQuestionType
 * @return
 */
public JSONObject getQuestionType(PLJavaBean javaBean) {
    return exec("getQuestionType", javaBean);
}

/**
 * 题库查询
 *
 * @param javaBean list
 * @return
 */
public JSONObject list(PLJavaBean javaBean) {
    return exec("list", javaBean);
}

/**
 * 根据ID查询题目
 *
 * @param javaBean getQuestionById
 * @return
 */
public JSONObject getQuestionById(PLJavaBean javaBean) {
    return exec("getQuestionById", javaBean);
}

/**
 * 学生答题
 *
 * @param javaBean studentAnswer
 * @return
 */
public JSONObject studentAnswer(PLJavaBean javaBean) {
    return exec("studentAnswer", javaBean);
}

/**
 * 根据题目ID，获取用户答案列表
 *
 * @param javaBean questionAnswerList
 * @return
 */
public JSONObject questionAnswerList(PLJavaBean javaBean) {
    return exec("questionAnswerList", javaBean);
}

/**
 * 老师评语和批改
 *
 * @param javaBean teacherComment
 * @return
 */
public JSONObject teacherComment(PLJavaBean javaBean) {
    return exec("teacherComment", javaBean);
}

/**
 * 课堂答题统计
 *
 * @param javaBean questionAnswerStatistics
 * @return
 */
public JSONObject questionAnswerStatistics(PLJavaBean javaBean) {
    return exec("questionAnswerStatistics", javaBean);
}

/**
 * 根据题目ID集合拿到题目
 *
 * @param javaBean getQuestionByIds
 * @return
 */
public JSONObject getQuestionByIds(PLJavaBean javaBean) {
    return exec("getQuestionByIds", javaBean);
}

/**
 * 老师在课堂中添加试题使用，为了统计本堂课一共有多少试题
 *
 * @param javaBean joinQuestions
 * @return
 */
public JSONObject joinQuestions(PLJavaBean javaBean) {
    return exec("joinQuestions", javaBean);
}


}