package com.mizholdings.kacha.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.kacha.core.user.KCUserBase;
import com.mizholdings.kacha.interfaces.ExportInterface;
import com.mizholdings.kacha.playload.PLExport;
import com.mizholdings.util.Requests;
import io.qameta.allure.Attachment;
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


}
