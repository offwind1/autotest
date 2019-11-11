package com.mizholdings.kacha.playload;

import com.mizholdings.util.PLJavaBean;

public class PLWrongbook extends PLJavaBean {

    private String subjectId;
    private String childId;
    private String startTime;
    private String endTime;
    private String grasp;
    private String page;
    private String pageId;
    private String pageSize;
    private String wrongId;
    private String matchstate;
    private String wrongIds;
    private String url;
    private String classId;
    private String schoolId;
    private String pageNum;


    public void setDateExportPage(String startTime, String endTime) {
        this.classId = "";
        this.startTime = startTime;
        this.endTime = endTime;
        this.schoolId = "";
        this.pageNum = "1";
        this.pageSize = "100";
    }

    /**
     * 11.1.1 题目学科选择器
     *
     * @param subjectId：int 学科id
     * @param childId       ；int 子女id
     */
    public void setQuestionSelector(String subjectId, String childId) {
        this.subjectId = subjectId;
        this.childId = childId;

    }

    /**
     * 11.1.2 查看错题列表
     *
     * @param subjectId：int    学科id
     * @param startTime：String 开始时间 （yyyy-MM-dd）
     * @param endTime：String   结束时间 （yyyy-MM-dd）
     * @param grasp:           int 0 未掌握,1 已掌握 null 全部
     * @param childid:         int 子女id
     * @param page:            页码
     * @param pageSize:        分页大小
     * @param pageId:          页码d
     */
    public void setQuestions(String subjectId, String startTime, String endTime, String grasp, String childid, String page, String pageSize, String pageId) {
        this.subjectId = subjectId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.grasp = grasp;
        this.childId = childid;
        this.page = page;
        this.pageSize = pageSize;
        this.pageId = pageId;
    }

    public void setQuestions(String subjectId, String childid) {
        this.subjectId = subjectId;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.grasp = grasp;
        this.childId = childid;
//        this.page = page;
//        this.pageSize = pageSize;
//        this.pageId = pageId;
    }


    /**
     * 11.1.4 查看错题详情
     *
     * @param wrongId:错题id
     */
    public void setQuestionDetail(String wrongId) {
        this.wrongId = wrongId;

    }


    /**
     * 11.1.5 题目匹配错误反馈
     *
     * @param wrongId:错题id
     * @param childId:     子女ID
     * @param matchstate:  匹配状态
     */
    public void setQuestionFeedback(String wrongId, String childId, String matchstate) {
        this.wrongId = wrongId;
        this.childId = childId;
        this.matchstate = matchstate;

    }

    /**
     * 11.1.6 查看页面列表
     *
     * @param *subjectId：int 学科id
     * @param *childid:      int 子女id
     * @param page:          页码 (默认值 1)
     * @param pageSize:      分页大小 (默认值 15)
     */
    public void setPages(String subjectId, String childid, String page, String pageSize) {
        this.subjectId = subjectId;
        this.childId = childid;
        this.page = page;
        this.pageSize = pageSize;

    }


    /**
     * 11.1.7 学生掌握状态
     *
     * @param wrongIds：String 逗号分隔
     * @param grasp:          int 0未掌握，1掌握
     */
    public void setQuestionGrasp(String wrongIds, String grasp) {
        this.wrongIds = wrongIds;
        this.grasp = grasp;

    }


    /**
     * 11.2.1上传页面
     *
     * @param url:string 图片URL
     */
    public void setPage(String url, String childId) {
        this.url = url;
        this.childId = childId;
    }


    /**
     * 11.2.3提交报告
     *
     * @param childId：int
     */
    public void setCommitReport(String childId) {
        this.childId = childId;

    }

    /**
     * 11.3.3 作业报告
     *
     * @param childId: 子女ID
     */
    public void setReportQuerychildreprotgz(String childId) {
        this.childId = childId;

    }
}
