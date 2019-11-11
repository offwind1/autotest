package com.mizholdings.kacha.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

import java.util.Map;

public interface ExportInterface {

    /**
     * 12.1 学生错题导出
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("export/pdf/makeStudentWB")
    Call<ResponseBody> pdfMakestudentwb(@Header("Authorization") String Authorization,
                                        @QueryMap Map<String, String> map);


    /**
     * 12.2 一错一练选择错题导出
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("export/pdf/makeSelectWB")
    Call<ResponseBody> pdfMakeselectwb(@Header("Authorization") String Authorization,
                                       @QueryMap Map<String, String> map);


    /**
     * 12.3 一错一练知识点错题导出
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("export/pdf/makeKnowledgeWB")
    Call<ResponseBody> pdfMakeknowledgewb(@Header("Authorization") String Authorization,
                                          @QueryMap Map<String, String> map);


    /**
     * 12.4 按时间导出用户错题本
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("export/pdf/makeUserDateWB")
    Call<ResponseBody> pdfMakeuserdatewb(@Header("Authorization") String Authorization,
                                         @QueryMap Map<String, String> map);


    /**
     * 12.5 用户导出错题压缩包
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("export/pdf/exportStudentPdf")
    Call<ResponseBody> pdfExportstudentpdf(@Header("Authorization") String Authorization,
                                           @QueryMap Map<String, String> map);


    /**
     * 12.6.1 查询导出记录
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("export/record/info")
    Call<ResponseBody> recordInfo(@Header("Authorization") String Authorization,
                                  @QueryMap Map<String, String> map);




}
