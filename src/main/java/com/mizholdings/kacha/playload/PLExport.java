package com.mizholdings.kacha.playload;

import com.mizholdings.util.PLJavaBean;

public class PLExport extends PLJavaBean {
    private String uqIdsStr;
    private String childId;
    private String needClean;
    private String operationClass;
    private String classId;
    private String practise;
    private String knowledgeIdsStr;
    private String beginDate;
    private String endDate;
    private String subjectId;
    private String userId;
    private String userIds;
    private String exportId;

    /**
     * 12.1 学生错题导出
     *
     * @param *uqIdsStr：string 题目图片ID（, 分割）
     * @param *childId：long    子女ID
     * @param needClean：int    是否去痕 0否(默认否）；1抹除
     */
    public void setPdfMakestudentwb(String uqIdsStr, String childId, String needClean) {
        this.uqIdsStr = uqIdsStr;
        this.childId = childId;
        this.needClean = needClean;
    }


    /**
     * 12.2 一错一练选择错题导出
     *
     * @param *uqIdsStr：string          题目图片ID（, 分割）
     * @param *childId：long             子女ID
     * @param *operationClass：操作导出的所属班级
     * @param classId                   : 班级ID
     * @param practise：int              是否需要练习题目 （1-需要 0-不需要 默认 1）
     */
    public void setPdfMakeselectwb(String uqIdsStr, String childId, String operationClass, String classId, String practise) {
        this.uqIdsStr = uqIdsStr;
        this.childId = childId;
        this.operationClass = operationClass;
        this.classId = classId;
        this.practise = practise;

    }

    public void setPdfMakeselectwb(String uqIdsStr, String childId) {
        this.uqIdsStr = uqIdsStr;
        this.childId = childId;
//        this.operationClass = operationClass;
//        this.classId = classId;
        this.practise = "0";

    }


    /**
     * 12.3 一错一练知识点错题导出
     *
     * @param *knowledgeIdsStr：string 知识点ID（, 分割）
     * @param *childId：long           子女ID
     * @param practise：int            是否需要练习题目 （1-需要 0-不需要 默认 1）
     * @param beginDate:              开始时间
     * @param endDate:                结束时间
     */
    public void setPdfMakeknowledgewb(String knowledgeIdsStr, String childId, String practise, String beginDate, String endDate) {
        this.knowledgeIdsStr = knowledgeIdsStr;
        this.childId = childId;
        this.practise = practise;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public void setPdfMakeknowledgewb(String knowledgeIdsStr, String childId) {
        this.knowledgeIdsStr = knowledgeIdsStr;
        this.childId = childId;
//        this.practise = practise;
//        this.beginDate = beginDate;
//        this.endDate = endDate;
    }


    /**
     * 12.4 按时间导出用户错题本
     *
     * @param *userId：long      用户ID
     * @param *subjectId：int    科目ID
     * @param *beginDate：String 开始时间（yyyy-MM-dd）
     * @param *endDate：String   结束时间（yyyy-MM-dd
     * @param practise：int      是否需要练习题目 （1-需要 0-不需要 默认 1）
     */
    public void setPdfMakeuserdatewb(String userId, String subjectId, String beginDate, String endDate, String practise) {
        this.userId = userId;
        this.subjectId = subjectId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.practise = practise;

    }

    /**
     * 12.5 用户导出错题压缩包
     *
     * @param *userIds：String   用户ID
     * @param *subjectId：int    科目ID
     * @param *beginDate：String 开始时间（yyyy-MM-dd）
     * @param *endDate：String   结束时间（yyyy-MM-dd )
     * @param practise：int      是否需要练习题目 （1-需要 0-不需要 默认 1）
     */
    public void setPdfExportstudentpdf(String userIds, String subjectId, String beginDate, String endDate, String practise) {
        this.userIds = userIds;
        this.subjectId = subjectId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.practise = practise;

    }


    /**
     * 12.6.1 查询导出记录
     *
     * @param exportId: 导出string
     */
    public void setRecordInfo(String exportId) {
        this.exportId = exportId;

    }
}
