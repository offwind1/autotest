package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLQues extends PLJavaBean {
    private String graderId;
    private String lessonTypeId;
    private String questionType;
    private String page;

    /**
     * 题库查询
     *
     * @param graderId     int,年级ID
     * @param lessonTypeId int,学科分类ID
     * @param questionType int,题目分类ID
     * @param page         int,页码
     */
    public void setList(String graderId, String lessonTypeId, String questionType, String page) {
        this.graderId = graderId;
        this.lessonTypeId = lessonTypeId;
        this.questionType = questionType;
        this.page = page;

    }

    private String questionId;
    private String classroomId;

    /**
     * 根据ID查询题目
     *
     * @param questionId   int,题目ID
     * @param lessonTypeId int,学科分类ID
     * @param classroomId  string,课堂ID（非必传）
     */
    public void setGetquestionbyid(String questionId, String lessonTypeId, String classroomId) {
        this.questionId = questionId;
        this.lessonTypeId = lessonTypeId;
        this.classroomId = classroomId;

    }

    private String userId;
    private String answerType;
    private String userAnswer;
    private String teacherRemark;
    private String teacherId;
    private String realAnswer;
    private String auto;
    private String studentAnswerId;

    /**
     * 学生答题
     *
     * @param questionId      int,题目ID
     * @param classroomId     string,课堂ID（可为空）
     * @param userId          long,学生ID
     * @param answerType      int,用户答案类型，1字符，2图片，3声音
     * @param userAnswer      string,用户答案
     * @param teacherRemark   String,老师评语
     * @param teacherId       long,老师ID
     * @param realAnswer      string,正确答案
     * @param auto            int 题目类型，1客观题，2主观题
     * @param studentAnswerId int,从一期错题本中拿到
     */
    public void setStudentanswer(String questionId, String classroomId, String userId, String answerType, String userAnswer, String teacherRemark, String teacherId, String realAnswer, String auto, String studentAnswerId) {
        this.questionId = questionId;
        this.classroomId = classroomId;
        this.userId = userId;
        this.answerType = answerType;
        this.userAnswer = userAnswer;
        this.teacherRemark = teacherRemark;
        this.teacherId = teacherId;
        this.realAnswer = realAnswer;
        this.auto = auto;
        this.studentAnswerId = studentAnswerId;

    }


    /**
     * 根据题目ID，获取用户答案列表
     *
     * @param classroomId string.课堂ID
     * @param questionId  int,试题ID
     */
    public void setQuestionanswerlist(String classroomId, String questionId) {
        this.classroomId = classroomId;
        this.questionId = questionId;

    }

    private String answerId;
    private String answerResult;

    /**
     * 老师评语和批改
     *
     * @param answerId      string,用户答案ID
     * @param answerResult  int,正确与否，-1未判断,0正确，1半正确，2错误
     * @param teacherRemark string,评语
     */
    public void setTeachercomment(String answerId, String answerResult, String teacherRemark) {
        this.answerId = answerId;
        this.answerResult = answerResult;
        this.teacherRemark = teacherRemark;

    }


    /**
     * 课堂答题统计
     *
     * @param classroomId  String,课堂ID
     * @param questionId   int,题目ID
     * @param lessonTypeId int，学科ID
     */
    public void setQuestionanswerstatistics(String classroomId, String questionId, String lessonTypeId) {
        this.classroomId = classroomId;
        this.questionId = questionId;
        this.lessonTypeId = lessonTypeId;

    }

    private String questionIds;

    /**
     * 根据题目ID集合拿到题目
     *
     * @param questionIds string,题目ID集合，用“，”分割
     * @param classroomId string,课堂ID（非必传）
     */
    public void setGetquestionbyids(String questionIds, String classroomId) {
        this.questionIds = questionIds;
        this.classroomId = classroomId;

    }

    private String autos;

    /**
     * 老师在课堂中添加试题使用，为了统计本堂课一共有多少试题
     *
     * @param questionIds string,题目ID集合，逗号分隔
     * @param autos       string,每道题目1客观题，2主观题，逗号分隔
     * @param classroomId string,课堂ID
     */
    public void setJoinquestions(String questionIds, String autos, String classroomId) {
        this.questionIds = questionIds;
        this.autos = autos;
        this.classroomId = classroomId;

    }


}