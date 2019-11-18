package com.mizholdings.kacha.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.user.KCUserBase;
import com.mizholdings.kacha.interfaces.ReportInterface;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import io.qameta.allure.Step;

public class MODReport extends MODBase<MODReport> {

    public static ReportInterface reportInterface = Requests.getService(ReportInterface.class);

    public MODReport(KCUserBase executor) {
        super(executor);
        this.interfaced = reportInterface;
    }

    /**
     * 18.1.1 获取省市区
     *
     * @return
     */
    @Step("18.1.1 获取省市区")
    public JSONObject sysAdministrativedivision() {
        return exec("sysAdministrativedivision");

    }


    /**
     * 18.1.4 查询当前系统时间
     *
     * @return
     */
    @Step("18.1.4 查询当前系统时间")
    public JSONObject sysSystemtime() {
        return exec("sysSystemtime");
    }

    /**
     * 18.2.3 查询月份列表
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.3 查询月份列表")
    public JSONObject dbQrmonthlist(PLJavaBean javaBean) {
        return exec("dbQrmonthlist", javaBean);
    }

    /**
     * 18.2.4 查询数据报告详情
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.4 查询数据报告详情")
    public JSONObject dbQrdetail(PLJavaBean javaBean) {
        return exec("dbQrdetail", javaBean);
    }

    @Step("18.2.4 查询数据报告详情")
    public JSONObject dbQrdetail(Parameter parameter) {
        return exec("dbQrdetail", parameter);
    }

    @Step("18.2.4 查询数据报告详情")
    public JSONObject dbQrdetail(String classId) {
        return dbQrdetail(Parameter.creat()
                .add("classId", classId).add("year", "2019")
                .add("subjectId", "10"));
    }


    /**
     * 18.2.9 查询报告学生统计
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.9 查询报告学生统计")
    public JSONObject dbQrstudentcount(PLJavaBean javaBean) {
        return exec("dbQrstudentcount", javaBean);
    }

    @Step("18.2.9 查询报告学生统计")
    public JSONObject dbQrstudentcount(Parameter parameter) {
        return exec("dbQrstudentcount", parameter);
    }

    @Step("18.2.9 查询报告学生统计")
    public JSONObject dbQrstudentcount(String classId) {
        return dbQrstudentcount(Parameter.creat()
                .add("classId", classId).add("subjectId", "10")
                .add("year", "2019"));
    }


    /**
     * 18.2.11 查询校级报告
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.11 查询校级报告")
    public JSONObject dbSchooldatareport(PLJavaBean javaBean) {
        return exec("dbSchooldatareport", javaBean);
    }

    public JSONObject dbSchooldatareport(Parameter parameter) {
        return exec("dbSchooldatareport", parameter);
    }

    public JSONObject dbSchooldatareport(String schoolId, String classId) {
        return dbSchooldatareport(Parameter.creat()
                .add("schoolId", schoolId).add("classId", classId)
                .add("subjectId", "10").add("timeStamp", String.valueOf(System.currentTimeMillis())));
    }

    /**
     * 18.2.12 查询班级报告
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.12 查询班级报告")
    public JSONObject dbClassdatareport(PLJavaBean javaBean) {
        return exec("dbClassdatareport", javaBean);
    }

    @Step("18.2.12 查询班级报告")
    public JSONObject dbClassdatareport(Parameter parameter) {
        return exec("dbClassdatareport", parameter);
    }

    @Step("18.2.12 查询班级报告")
    public JSONObject dbClassdatareport(String classId) {
        return dbClassdatareport(Parameter.creat().add("classId", classId)
                .add("subjectId", "10").add("timeStamp", String.valueOf(System.currentTimeMillis())));
    }


    /**
     * 18.2.13 查询时间戳
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.13 查询时间戳")
    public JSONObject dbTimestamp(PLJavaBean javaBean) {
        return exec("dbTimestamp", javaBean);
    }


    /**
     * 18.2.14 查询学生提交情况
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.14 查询学生提交情况")
    public JSONObject dbQueryqrdetailforgz(PLJavaBean javaBean) {
        return exec("dbQueryqrdetailforgz", javaBean);
    }

    @Step("18.2.14 查询学生提交情况")
    public JSONObject dbQueryqrdetailforgz(Parameter parameter) {
        return exec("dbQueryqrdetailforgz", parameter);
    }

    @Step("18.2.14 查询学生提交情况")
    public JSONObject dbQueryqrdetailforgz(String classId) {
        return dbQueryqrdetailforgz(Parameter.creat()
                .add("classId", classId).add("subjectId", "10")
                .add("mode", "0"));
    }


    /**
     * 18.2.18 获取百度搜索链接
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.18 获取百度搜索链接")
    public JSONObject dbSearchlink(PLJavaBean javaBean) {
        return exec("dbSearchlink", javaBean);
    }

    /**
     * 18.2.19 根据班级ID获取知识点列表
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.19 根据班级ID获取知识点列表")
    public JSONObject dbKnowledgelist(PLJavaBean javaBean) {
        return exec("dbKnowledgelist", javaBean);
    }

    @Step("18.2.19 根据班级ID获取知识点列表")
    public JSONObject dbKnowledgelist(Parameter parameter) {
        return exec("dbKnowledgelist", parameter);
    }

    @Step("18.2.19 根据班级ID获取知识点列表")
    public JSONObject dbKnowledgelist(String classId) {
        return dbKnowledgelist(Parameter.creat()
                .add("classId", classId).add("year", "2019")
                .add("subjectId", "10").add("type", "1"));
    }


    /**
     * 18.2.20 学生统计信息
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.20 学生统计信息")
    public JSONObject dbQueryqrstudentcountforgz(PLJavaBean javaBean) {
        return exec("dbQueryqrstudentcountforgz", javaBean);
    }

    @Step("18.2.20 学生统计信息")
    public JSONObject dbQueryqrstudentcountforgz(Parameter parameter) {
        return exec("dbQueryqrstudentcountforgz", parameter);
    }


    @Step("18.2.20 学生统计信息")
    public JSONObject dbQueryqrstudentcountforgz(String classId) {
        return dbQueryqrstudentcountforgz(Parameter.creat()
                .add("classId", classId).add("subjectId", "10").add("mode", "0"));
    }


    /**
     * 18.2.21 题目统计信息
     *
     * @param javaBean report
     * @return
     */
    @Step("18.2.21 题目统计信息")
    public JSONObject dbQueryqrquestioncountforgz(PLJavaBean javaBean) {
        return exec("dbQueryqrquestioncountforgz", javaBean);
    }

    @Step("18.2.21 题目统计信息")
    public JSONObject dbQueryqrquestioncountforgz(Parameter parameter) {
        return exec("dbQueryqrquestioncountforgz", parameter);
    }

    @Step("18.2.21 题目统计信息")
    public JSONObject dbQueryqrquestioncountforgz(String classId) {
        return dbQueryqrquestioncountforgz(Parameter.creat()
                .add("classId", classId).add("subjectId", "10").add("mode", "0"));
    }


    /**
     * 18.3.1 上传教学视频
     *
     * @param javaBean report
     * @return
     */
    @Step("18.3.1 上传教学视频")
    public JSONObject questionsUploadvideostatus(PLJavaBean javaBean) {
        return exec("questionsUploadvideostatus", javaBean);
    }


    /**
     * 18.3.2 上传教学视频回调
     *
     * @param javaBean report
     * @return
     */
    @Step("18.3.2 上传教学视频回调")
    public JSONObject questionsTeachvideobackcall(PLJavaBean javaBean) {
        return exec("questionsTeachvideobackcall", javaBean);
    }


    /**
     * 18.3.3 查询教学视频
     *
     * @param javaBean report
     * @return
     */
    @Step("18.3.3 查询教学视频")
    public JSONObject questionsTeachvideo(PLJavaBean javaBean) {
        return exec("questionsTeachvideo", javaBean);
    }

    /**
     * 18.3.4 删除教学视频
     *
     * @param javaBean report
     * @return
     */
    @Step("18.3.4 删除教学视频")
    public JSONObject questionsDeleteteachvideo(PLJavaBean javaBean) {
        return exec("questionsDeleteteachvideo", javaBean);
    }

    /**
     * 18.3.5 上传教学视频
     *
     * @param javaBean report
     * @return
     */
    @Step("18.3.5 上传教学视频")
    public JSONObject questionsUploadvideo(PLJavaBean javaBean) {
        return exec("questionsUploadvideo", javaBean);
    }

    /**
     * 18.3.6 获取收藏
     *
     * @param javaBean report
     * @return
     */
    @Step("18.3.6 获取收藏")
    public JSONObject getQuestionsCorrection(PLJavaBean javaBean) {
        return exec("getQuestionsCorrection", javaBean);
    }

    /**
     * 18.3.7 进行收藏标记
     *
     * @param javaBean report
     * @return
     */
    @Step("18.3.7 进行收藏标记")
    public JSONObject postQuestionsCorrection(PLJavaBean javaBean) {
        return exec("postQuestionsCorrection", javaBean);
    }

    /**
     * 18.3.8 标错
     *
     * @param javaBean report
     * @return
     */
    @Step("18.3.8 标错")
    public JSONObject questionsWrongmarker(PLJavaBean javaBean) {
        return exec("questionsWrongmarker", javaBean);
    }

    /**
     * 18.4.1 查询作业详情
     *
     * @param javaBean report
     * @return
     */
    @Step("18.4.1 查询作业详情")
    public JSONObject homeworkDetail(PLJavaBean javaBean) {
        return exec("homeworkDetail", javaBean);
    }


    /**
     * 18.4.3 查询作业列表
     *
     * @param javaBean report
     * @return
     */
    @Step("18.4.3 查询作业列表")
    public JSONObject homeworkList(PLJavaBean javaBean) {
        return exec("homeworkList", javaBean);
    }


    /**
     * 18.4.2 查询作业成绩详情
     *
     * @param javaBean report
     * @return
     */
    @Step("18.4.2 查询作业成绩详情")
    public JSONObject homeworkScoreDetailPs(PLJavaBean javaBean) {
        return exec("homeworkScoreDetailPs", javaBean);
    }

    /**
     * 18.4.4 提醒作业
     *
     * @param javaBean wpa
     * @return
     */
    @Step("18.4.4 提醒作业")
    public JSONObject weixinRemind(PLJavaBean javaBean) {
        return exec("weixinRemind", javaBean);
    }


    /**
     * 18.4.5 查询学生作业拍摄原图
     *
     * @param javaBean report
     * @return
     */
    @Step("18.4.5 查询学生作业拍摄原图")
    public JSONObject homeworkPage(PLJavaBean javaBean) {
        return exec("homeworkPage", javaBean);
    }

    /**
     * 18.5.2 查询作业成绩错误率对比
     *
     * @param javaBean report
     * @return
     */
    @Step("18.5.2 查询作业成绩错误率对比")
    public JSONObject homeworkScoreDetailRate(PLJavaBean javaBean) {
        return exec("homeworkScoreDetailRate", javaBean);
    }


}
