package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLLessonInfo extends PLJavaBean {

    private String lessonName;
    private String lessonTerm;
    private String page;
    private String lessonId;

    /**
     * 我的课程
     * page	int,页码
     * lessonName	string,课程名称
     * lessonTerm	int,课程分类，0查询所有，1课程，2微课
     *
     * @param lessonName
     */
    public void setMyLesson(String lessonName) {
        this.lessonName = lessonName;
        this.lessonTerm = "0";
        this.page = "1";
    }

    /**
     * 点赞课程
     *
     * @param lessonId
     */
    public void setLikedLesson(String lessonId) {
        this.lessonId = lessonId;
    }


    /**
     * 相关推荐
     *
     * @param lessonId string,课程ID
     */
    public void setRelatedlist(String lessonId) {
        this.lessonId = lessonId;

    }

    private String orgId;

    /**
     * 课程列表
     *
     * @param lessonName string,课程名称
     * @param page       int,页码
     * @param orgId      int,机构ID
     */
    public void setList(String lessonName, String page, String orgId) {
        this.lessonName = lessonName;
        this.page = page;
        this.orgId = orgId;

    }


    /**
     * 课程详情
     *
     * @param lessonId string,课程ID
     */
    public void setLessoninfo(String lessonId) {
        this.lessonId = lessonId;

    }

    private String resourceId;
    private String userComment;
    private String lessonScore;
    private String contentScore;
    private String styleScore;
    private String teacherScore;
    private String resourcesScore;

    /**
     * 课程评论
     *
     * @param resourceId     string,回复目标ID，如果不是回复某个评论，则不传此字段
     * @param userComment    string,评论内容
     * @param lessonScore    int,课程总评分，1-5，回复评论时此字段为null
     * @param contentScore   int,内容评分，1-5,回复评论时此字段为null
     * @param styleScore     int,教学形式评分，1-5,回复评论时此字段为null
     * @param teacherScore   int,对老师讲解评分，1-5,回复评论时此字段为null
     * @param resourcesScore int,对课程内资源评分，1-5,回复评论时此字段为null
     * @param lessonId       string,课程ID
     */
    public void setScore(String resourceId, String userComment, String lessonScore, String contentScore, String styleScore, String teacherScore, String resourcesScore, String lessonId) {
        this.resourceId = resourceId;
        this.userComment = userComment;
        this.lessonScore = lessonScore;
        this.contentScore = contentScore;
        this.styleScore = styleScore;
        this.teacherScore = teacherScore;
        this.resourcesScore = resourcesScore;
        this.lessonId = lessonId;

    }

    private String userId;

    /**
     * 查询用户课程列表
     *
     * @param userId Long,用户ID
     * @param page   int,页码
     */
    public void setUsrlesson(String userId, String page) {
        this.userId = userId;
        this.page = page;

    }

    private String dataYear;
    private String dataMonth;

    /**
     * 我要听课，我要上课的日历列表
     *
     * @param dataYear  int,要查询的年份
     * @param dataMonth int,要查询的月份
     */
    public void setStudylesson(String dataYear, String dataMonth) {
        this.dataYear = dataYear;
        this.dataMonth = dataMonth;

    }


    /**
     * 点赞课程
     *
     * @param lessonId string,课程ID
     */
    public void setLikedlesson(String lessonId) {
        this.lessonId = lessonId;

    }


    /**
     * 取消点赞
     *
     * @param lessonId string,课程ID
     */
    public void setRmlikedlesson(String lessonId) {
        this.lessonId = lessonId;

    }


    /**
     * 收藏课程
     *
     * @param lessonId string,课程ID
     */
    public void setKeeplesson(String lessonId) {
        this.lessonId = lessonId;

    }


    /**
     * 取消收藏
     *
     * @param lessonId string,课程ID
     */
    public void setRmkeeplesson(String lessonId) {
        this.lessonId = lessonId;

    }


    /**
     * 查询课程评论
     *
     * @param lessonId string,课程ID
     * @param page     int,页码
     */
    public void setLessonscore(String lessonId, String page) {
        this.lessonId = lessonId;
        this.page = page;

    }


    /**
     * 我的课程
     *
     * @param page       int,页码
     * @param lessonName string,课程名称
     * @param lessonTerm int,课程分类，0查询所有，1课程，2微课
     */
    public void setMylesson(String page, String lessonName, String lessonTerm) {
        this.page = page;
        this.lessonName = lessonName;
        this.lessonTerm = lessonTerm;

    }


    /**
     * 获取退课款项
     *
     * @param lessonId string.课程ID
     */
    public void setRetreat(String lessonId) {
        this.lessonId = lessonId;

    }

    private String refundMsg;

    /**
     * 退课申请
     *
     * @param lessonId  string,课程ID
     * @param refundMsg string,申请信息
     */
    public void setRefundapply(String lessonId, String refundMsg) {
        this.lessonId = lessonId;
        this.refundMsg = refundMsg;

    }


    /**
     * 查询退课状态
     *
     * @param lessonId string,课程ID
     */
    public void setRefundstatus(String lessonId) {
        this.lessonId = lessonId;

    }


    /**
     * 我创建的课程
     *
     * @param page       int,页码
     * @param lessonName string,课程名称
     * @param lessonTerm int,课程分类，0查询所有，1课程，2微课
     */
    public void setMycreatelesson(String page, String lessonName, String lessonTerm) {
        this.page = page;
        this.lessonName = lessonName;
        this.lessonTerm = lessonTerm;

    }


    /**
     * 删除私课
     *
     * @param lessonId string,课程ID
     */
    public void setDellesson(String lessonId) {
        this.lessonId = lessonId;

    }

    private String classroomId;
    private String classroomVideoId;

    /**
     * 新增视频回放记录
     *
     * @param lessonId         String，课程id
     * @param classroomId      String，课堂id
     * @param classroomVideoId String，视频id
     */
    public void setSetvideorecord(String lessonId, String classroomId, String classroomVideoId) {
        this.lessonId = lessonId;
        this.classroomId = classroomId;
        this.classroomVideoId = classroomVideoId;

    }


    /**
     * 根据视频id查询播放量
     *
     * @param classroomVideoId String, 视频id
     */
    public void setGettotalplays(String classroomVideoId) {
        this.classroomVideoId = classroomVideoId;

    }

    private String gradeId;
    private String lessonTypeId;
    private String schoolId;

    /**
     * 免费课程列表
     *
     * @param lessonName   string，课程名
     * @param gradeId      int,年级ID
     * @param lessonTypeId int,学科ID
     * @param orgId        int,机构ID
     * @param page         int,页码
     * @param schoolId     int,机构ID（筛选）
     */
    public void setFreelist(String lessonName, String gradeId, String lessonTypeId, String orgId, String page, String schoolId) {
        this.lessonName = lessonName;
        this.gradeId = gradeId;
        this.lessonTypeId = lessonTypeId;
        this.orgId = orgId;
        this.page = page;
        this.schoolId = schoolId;

    }

    private String pageSize;
    private String pageNum;

    /**
     * 我的课程(我购买的)PC
     *
     * @param pageSize   int,显示数量
     * @param pageNum    int,页码
     * @param lessonName string.课程名称
     * @param lessonTerm int.课程分类
     */
    public void setMylessonpc(String pageSize, String pageNum, String lessonName, String lessonTerm) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.lessonName = lessonName;
        this.lessonTerm = lessonTerm;

    }

    private String recordId;
    private String timeLong;

    /**
     * 更新视频回放，观看时长
     *
     * @param recordId int,回放视频记录ID
     * @param timeLong long,观看时长（秒）
     */
    public void setUpdatevideotime(String recordId, String timeLong) {
        this.recordId = recordId;
        this.timeLong = timeLong;

    }


}
