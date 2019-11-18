package com.mizholdings.kacha.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.kacha.user.KCUserBase;
import com.mizholdings.kacha.interfaces.ExportInterface;
import com.mizholdings.kacha.playload.PLExport;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import io.qameta.allure.Step;

public class MODExport extends MODBase<MODExport> {

    public static ExportInterface exportInterface = Requests.getService(ExportInterface.class);

    public MODExport(KCUserBase executor) {
        super(executor);
        interfaced = exportInterface;
    }

    /**
     * 12.1 学生错题导出
     *
     * @param export
     * @return
     */
    @Step("学生错题导出")
    public JSONObject pdfMakestudentwb(PLExport export) {
        return exec("pdfMakestudentwb", export);
    }

    @Step("学生错题导出")
    public JSONObject pdfMakestudentwb(Parameter parameter) {
        return exec("pdfMakestudentwb", parameter);
    }

    @Step("学生错题导出")
    public JSONObject pdfMakestudentwb(String uqIdsStr, String childId) {
        return pdfMakestudentwb(Parameter.creat().add("uqIdsStr", uqIdsStr).add("childId", childId)
                .add("needClean", "0"));
    }


    /**
     * 12.2 一错一练选择错题导出
     *
     * @param export
     * @return
     */
    @Step("一错一练选择错题导出")
    public JSONObject pdfMakeselectwb(PLExport export) {
        return exec("pdfMakeselectwb", export);
    }

    @Step("一错一练选择错题导出")
    public JSONObject pdfMakeselectwb(Parameter parameter) {
        return exec("pdfMakeselectwb", parameter);
    }

    @Step("一错一练选择错题导出")
    public JSONObject pdfMakeselectwb(String uqIdsStr, String childId, String operationClass) {
        return pdfMakeselectwb(Parameter.creat()
                .add("uqIdsStr", uqIdsStr).add("childId", childId)
                .add("operationClass", operationClass).add("practise", "0"));
    }


    /**
     * 12.3 一错一练知识点错题导出
     *
     * @param export
     * @return
     */
    @Step("一错一练知识点错题导出")
    public JSONObject pdfMakeknowledgewb(PLExport export) {
        return exec("pdfMakeknowledgewb", export);
    }


    /**
     * 12.4 按时间导出用户错题本
     *
     * @param export
     * @return
     */
    @Step("按时间导出用户错题本")
    public JSONObject pdfMakeuserdatewb(PLExport export) {
        return exec("pdfMakeuserdatewb", export);
    }

    @Step("按时间导出用户错题本")
    public JSONObject pdfMakeuserdatewb(Parameter parameter) {
        return exec("pdfMakeuserdatewb", parameter);
    }

    @Step("按时间导出用户错题本")
    public JSONObject pdfMakeuserdatewb(String userId, String subjectId) {
        return pdfMakeuserdatewb(Parameter.creat()
                .add("userId", userId).add("subjectId", subjectId)
                .add("beginDate", "2019-10-10").add("endDate", "2019-12-30")
                .add("practise", "0"));
    }

    /**
     * 12.5 用户导出错题压缩包
     *
     * @param export
     * @return
     */
    @Step("用户导出错题压缩包")
    public JSONObject pdfExportstudentpdf(PLExport export) {
        return exec("pdfExportstudentpdf", export);
    }

    @Step("用户导出错题压缩包")
    public JSONObject pdfExportstudentpdf(Parameter parameter) {
        return exec("pdfExportstudentpdf", parameter);
    }

    @Step("用户导出错题压缩包")
    public JSONObject pdfExportstudentpdf(String userId, String subjectId) {
        return pdfExportstudentpdf(Parameter.creat()
                .add("userIds", userId).add("subjectId", subjectId)
                .add("beginDate", "2019-10-10").add("endDate", "2019-12-30")
                .add("practise", "0"));
    }


    /**
     * 12.6.1 查询导出记录
     *
     * @param export
     * @return
     */
    @Step("查询导出记录")
    public JSONObject recordInfo(PLExport export) {
        return exec("recordInfo", export);
    }

    @Step("查询导出记录")
    public JSONObject recordInfo(Parameter parameter) {
        return exec("recordInfo", parameter);
    }

    @Step("查询导出记录")
    public JSONObject recordInfo() {
        return recordInfo(Parameter.creat());
    }


}
