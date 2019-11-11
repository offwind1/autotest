package com.mizholdings.kacha.interfaces;

import com.alibaba.fastjson.JSONObject;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface WrongbookInterface {


    /**
     * 11.1.1 题目学科选择器
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("wrongbook/question/selector")
    Call<ResponseBody> questionSelector(@Header("Authorization") String Authorization,
                                        @QueryMap Map<String, String> map);


    /**
     * 11.1.2 查看错题列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("wrongbook/questions")
    Call<ResponseBody> questions(@Header("Authorization") String Authorization,
                                 @QueryMap Map<String, String> map);


    /**
     * 11.1.3 删除错题
     *
     * @param Authorization
     * @return
     */
    @POST("wrongbook/question/delete")
    Call<ResponseBody> questionDelete(@Header("Authorization") String Authorization,
                                      @Body RequestBody body);


    /**
     * 11.1.4 查看错题详情
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("wrongbook/question/detail")
    Call<ResponseBody> questionDetail(@Header("Authorization") String Authorization,
                                      @QueryMap Map<String, String> map);


    /**
     * 11.1.5 题目匹配错误反馈
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("wrongbook/question/feedback")
    @FormUrlEncoded
    Call<ResponseBody> questionFeedback(@Header("Authorization") String Authorization,
                                        @FieldMap Map<String, String> map);

    /**
     * 11.1.6 查看页面列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("wrongbook/pages")
    Call<ResponseBody> pages(@Header("Authorization") String Authorization,
                             @QueryMap Map<String, String> map);


    /**
     * 11.1.7 学生掌握状态
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("wrongbook/question/grasp")
    @FormUrlEncoded
    Call<ResponseBody> questionGrasp(@Header("Authorization") String Authorization,
                                     @FieldMap Map<String, String> map);


    /**
     * 11.2.1上传页面
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("wrongbook/page")
    @FormUrlEncoded
    Call<ResponseBody> page(@Header("Authorization") String Authorization,
                            @FieldMap Map<String, String> map);

    /**
     * 11.2.2 提交错题
     *
     * @param Authorization
     * @param body
     * @return
     */
    @POST("wrongbook/commit")
    Call<ResponseBody> commit(@Header("Authorization") String Authorization,
                              @Body RequestBody body);


    /**
     * 11.2.3提交报告
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("wrongbook/commit/report")
    Call<ResponseBody> commitReport(@Header("Authorization") String Authorization,
                                    @QueryMap Map<String, String> map);

    /**
     * 11.3.3 作业报告
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("wrongbook/report/queryChildReprotGz")
    Call<ResponseBody> reportQuerychildreprotgz(@Header("Authorization") String Authorization,
                                                @QueryMap Map<String, String> map);


    @GET("wrongbook/data/export/page")
    Call<ResponseBody> dataExportPage(@Header("Authorization") String Authorization,
                                      @QueryMap Map<String, String> map);


}
