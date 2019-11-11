package com.mizholdings.kacha.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLReport extends PLJavaBean {

    private String classId;
    private String year;
    private String subjectId;

    /**
     * 18.2.3 查询月份列表
     *
     * @param *classId:   班级Id
     * @param *year:      年份
     * @param *subjectId: 科目Id
     */
    public void setDbQrmonthlist(String classId, String year, String subjectId) {
        this.classId = classId;
        this.year = year;
        this.subjectId = subjectId;
    }

    private String month;
    private String userId;
    private String pageNum;
    private String pageSize;
    private String schoolId;
    private String startTime;
    private String endTime;
    private String knowledgeName;

    /**
     * 18.2.4 查询数据报告详情
     *
     * @param *classId:      班级Id
     * @param *year:         年份
     * @param *subjectId:    科目Id
     * @param month:         月份
     * @param userId:        用户Id
     * @param pageNum:       页码
     * @param pageSize:      分页大小
     * @param schoolId:      学校ID
     * @param startTime:     开始日期
     * @param endTime:       结束日期
     * @param knowledgeName: 知识点名称
     */
    public void setDbQrdetail(String classId, String year, String subjectId, String month, String userId, String pageNum, String pageSize, String schoolId, String startTime, String endTime, String knowledgeName) {
        this.classId = classId;
        this.year = year;
        this.subjectId = subjectId;
        this.month = month;
        this.userId = userId;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.schoolId = schoolId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.knowledgeName = knowledgeName;
    }

    public void setDbQrdetail(String classId, String year, String subjectId) {
        this.classId = classId;
        this.year = year;
        this.subjectId = subjectId;
//        this.month = month;
//        this.userId = userId;
//        this.pageNum = pageNum;
//        this.pageSize = pageSize;
//        this.schoolId = schoolId;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.knowledgeName = knowledgeName;
    }

    /**
     * 18.2.9 查询报告学生统计
     *
     * @param *classId:      班级Id
     * @param *subjectId:    科目Id
     * @param *year:         学年
     * @param month:         月份
     * @param startTime:     开始时间
     * @param endTime:       结束时间
     * @param knowledgeName: 知识点名称
     */
    public void setDbQrstudentcount(String classId, String subjectId, String year, String month, String startTime, String endTime, String knowledgeName) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.year = year;
        this.month = month;
        this.startTime = startTime;
        this.endTime = endTime;
        this.knowledgeName = knowledgeName;
    }

    public void setDbQrstudentcount(String classId, String subjectId, String year) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.year = year;
//        this.month = month;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.knowledgeName = knowledgeName;
    }

    private String timeStamp;
    private String periodTime;

    /**
     * 18.2.11 查询校级报告
     *
     * @param *schoolId:  学校Id
     * @param *classId:   班级Id
     * @param *subjectId: 学科Id
     * @param *timeStamp: 时间
     * @param periodTime:
     * @param startTime:  开始时间
     * @param endTime:    结束时间
     */
    public void setDbSchooldatareport(String schoolId, String classId, String subjectId, String timeStamp, String periodTime, String startTime, String endTime) {
        this.schoolId = schoolId;
        this.classId = classId;
        this.subjectId = subjectId;
        this.timeStamp = timeStamp;
        this.periodTime = periodTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setDbSchooldatareport(String schoolId, String classId, String subjectId, String timeStamp) {
        this.schoolId = schoolId;
        this.classId = classId;
        this.subjectId = subjectId;
        this.timeStamp = timeStamp;
//        this.periodTime = periodTime;
//        this.startTime = startTime;
//        this.endTime = endTime;
    }


    /**
     * 18.2.12 查询班级报告
     *
     * @param *classId:   班级Id
     * @param *subjectId: 学科Id
     * @param *timeStamp: 时间
     * @param periodTime:
     * @param startTime:  开始时间
     * @param endTime:    结束时间
     */
    public void setDbClassdatareport(String classId, String subjectId, String timeStamp, String periodTime, String startTime, String endTime) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.timeStamp = timeStamp;
        this.periodTime = periodTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setDbClassdatareport(String classId, String subjectId, String timeStamp) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.timeStamp = timeStamp;
//        this.periodTime = periodTime;
//        this.startTime = startTime;
//        this.endTime = endTime;
    }


    /**
     * 18.2.13 查询时间戳
     *
     * @param *year: 学年
     */
    public void setDbTimestamp(String year) {
        this.year = year;
    }

    private String mode;

    /**
     * 18.2.14 查询学生提交情况
     *
     * @param *classId:   班级ID
     * @param *subjectId: 学科ID
     * @param *mode:      时间模式
     * @param userId:     用户ID
     * @param pageNum:    页码
     * @param pageSize:   分页大小
     */
    public void setDbQueryqrdetailforgz(String classId, String subjectId, String mode, String userId, String pageNum, String pageSize) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.mode = mode;
        this.userId = userId;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public void setDbQueryqrdetailforgz(String classId, String subjectId, String mode) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.mode = mode;
//        this.userId = userId;
//        this.pageNum = pageNum;
//        this.pageSize = pageSize;
    }

    private String picId;

    /**
     * 18.2.18 获取百度搜索链接
     *
     * @param *picId: 图片Id
     */
    public void setDbSearchlink(String picId) {
        this.picId = picId;
    }

    private String type;

    /**
     * 18.2.19 根据班级ID获取知识点列表
     *
     * @param *classId:   班级Id
     * @param *year:      学年
     * @param *subjectId: 学科ID
     * @param *type:      类型
     * @param userId:     用户ID
     * @param month:      月份
     * @param startTime:  开始时间
     * @param endTime:    结束时间
     */
    public void setDbKnowledgelist(String classId, String year, String subjectId, String type, String userId, String month, String startTime, String endTime) {
        this.classId = classId;
        this.year = year;
        this.subjectId = subjectId;
        this.type = type;
        this.userId = userId;
        this.month = month;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public void setDbKnowledgelist(String classId, String year, String subjectId, String type) {
        this.classId = classId;
        this.year = year;
        this.subjectId = subjectId;
        this.type = type;
//        this.userId = userId;
//        this.month = month;
//        this.startTime = startTime;
//        this.endTime = endTime;
    }


    /**
     * 18.2.20 学生统计信息
     *
     * @param *classId:   班级ID
     * @param *subjectId: 科目ID
     * @param *mode:      模式
     */
    public void setDbQueryqrstudentcountforgz(String classId, String subjectId, String mode) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.mode = mode;
    }

    /**
     * 18.2.21 题目统计信息
     *
     * @param *classId:   科目Id
     * @param *subjectId: 用户Id
     * @param *mode:      模式
     * @param pageNum：    页码
     * @param pageSize:   分页大小
     */
    public void setDbQueryqrquestioncountforgz(String classId, String subjectId, String mode, String pageNum, String pageSize) {
        this.classId = classId;
        this.subjectId = subjectId;
        this.mode = mode;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    private String uqId;
    private String authorId;

    /**
     * 18.3.1 上传教学视频
     *
     * @param *uqId:     题目Id
     * @param *authorId: 作者Id
     */
    public void setQuestionsUploadvideostatus(String uqId, String authorId) {
        this.uqId = uqId;
        this.authorId = authorId;
    }

    private String videoId;
    private String status;

    /**
     * 18.3.2 上传教学视频回调
     *
     * @param *userId: 用户Id
     * @param *uqId:   题目Id
     * @param videoId: 视频Id
     * @param status:  状态值
     */
    public void setQuestionsTeachvideobackcall(String userId, String uqId, String videoId, String status) {
        this.userId = userId;
        this.uqId = uqId;
        this.videoId = videoId;
        this.status = status;
    }

    private String questionId;

    /**
     * 18.3.3 查询教学视频
     *
     * @param *questionId: 题目Id
     */
    public void setQuestionsTeachvideo(String questionId) {
        this.questionId = questionId;
    }

    /**
     * 18.3.4 删除教学视频
     *
     * @param *videoId: 视频Id
     */
    public void setQuestionsDeleteteachvideo(String videoId) {
        this.videoId = videoId;
    }

    private String url;
    private String duration;

    /**
     * 18.3.5 上传教学视频
     *
     * @param *uqId:         题目Id
     * @param *url：          视频连接
     * @param *duration：视频时长
     * @param userId：可选
     */
    public void setQuestionsUploadvideo(String uqId, String url, String duration, String userId) {
        this.uqId = uqId;
        this.url = url;
        this.duration = duration;
        this.userId = userId;
    }

    /**
     * 18.3.6 获取收藏
     *
     * @param *uqId:    题目Id
     * @param *classId: 班级Id
     */
    public void setQuestionsCorrection(String uqId, String classId) {
        this.uqId = uqId;
        this.classId = classId;
    }

    private String way;

    /**
     * 18.3.8 标错
     *
     * @param *uqId:   题目Id
     * @param *userId: 用户Id
     * @param *way:    way（班级错题-1 学生错题-2 作业报告-3）
     */
    public void setQuestionsWrongmarker(String uqId, String userId, String way) {
        this.uqId = uqId;
        this.userId = userId;
        this.way = way;
    }

    private String homeworkId;
    private String studentId;

    /**
     * 18.4.1 查询作业详情
     *
     * @param *homeworkId: 作业Id
     * @param *studentId:  学生Id
     */
    public void setHomeworkDetail(String homeworkId, String studentId) {
        this.homeworkId = homeworkId;
        this.studentId = studentId;
    }

    private String title;

    /**
     * 18.4.3 查询作业列表
     *
     * @param *classId:  班级Id
     * @param title:     作业标题
     * @param subjectId： 科目Id
     */
    public void setHomeworkList(String classId, String title, String subjectId) {
        this.classId = classId;
        this.title = title;
        this.subjectId = subjectId;
    }


    /**
     * 18.4.2 查询作业成绩详情
     *
     * @param *homeworkId: 作业Id
     */
    public void setHomeworkScoreDetailPs(String homeworkId) {
        this.homeworkId = homeworkId;
    }

    /**
     * 18.4.4 提醒作业
     *
     * @param *subjectId: 科目Id
     * @param *userId:    用户Id
     */
    public void setWeixinRemind(String subjectId, String userId) {
        this.subjectId = subjectId;
        this.userId = userId;
    }


    /**
     * 18.4.5 查询学生作业拍摄原图
     *
     * @param *int  homeworkId:     作业Id
     * @param *list userId:              学生Id
     */
    public void setHomeworkPage(String homeworkId, String userId) {
        this.homeworkId = homeworkId;
        this.userId = userId;
    }

    /**
     * 18.5.2 查询作业成绩错误率对比
     *
     * @param *homeworkId: 作业Id
     * @param *classId:    班级Id
     * @param *subjectId:  学科Id
     */
    public void setHomeworkScoreDetailRate(String homeworkId, String classId, String subjectId) {
        this.homeworkId = homeworkId;
        this.classId = classId;
        this.subjectId = subjectId;
    }
}
