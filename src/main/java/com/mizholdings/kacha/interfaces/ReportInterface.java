package com.mizholdings.kacha.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface ReportInterface {


    /**
     * 18.1.1 获取省市区
     *
     * @param Authorization
     * @return
     */
    @POST("report/sys/administrativeDivision")
    Call<ResponseBody> sysAdministrativedivision(@Header("Authorization") String Authorization);


    /**
     * 18.1.4 查询当前系统时间
     *
     * @param Authorization
     * @return
     */
    @POST("report/sys/systemTime")
    Call<ResponseBody> sysSystemtime(@Header("Authorization") String Authorization);


    /**
     * 18.2.3 查询月份列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/db/qrMonthList")
    Call<ResponseBody> dbQrmonthlist(@Header("Authorization") String Authorization,
                                     @QueryMap Map<String, String> map);

    /**
     * 18.2.4 查询数据报告详情
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/db/qrDetail")
    Call<ResponseBody> dbQrdetail(@Header("Authorization") String Authorization,
                                  @QueryMap Map<String, String> map);


    /**
     * 18.2.9 查询报告学生统计
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/db/qrStudentCount")
    Call<ResponseBody> dbQrstudentcount(@Header("Authorization") String Authorization,
                                        @QueryMap Map<String, String> map);


    /**
     * 18.2.11 查询校级报告
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/db/schoolDataReport")
    Call<ResponseBody> dbSchooldatareport(@Header("Authorization") String Authorization,
                                          @QueryMap Map<String, String> map);


    /**
     * 18.2.12 查询班级报告
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/db/classDataReport")
    Call<ResponseBody> dbClassdatareport(@Header("Authorization") String Authorization,
                                         @QueryMap Map<String, String> map);


    /**
     * 18.2.13 查询时间戳
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("report/db/timeStamp")
    @FormUrlEncoded
    Call<ResponseBody> dbTimestamp(@Header("Authorization") String Authorization,
                                   @FieldMap Map<String, String> map);


    /**
     * 18.2.14 查询学生提交情况
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("report/db/queryQrDetailForGz")
    @FormUrlEncoded
    Call<ResponseBody> dbQueryqrdetailforgz(@Header("Authorization") String Authorization,
                                            @FieldMap Map<String, String> map);


    /**
     * 18.2.18 获取百度搜索链接
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/db/searchLink")
    Call<ResponseBody> dbSearchlink(@Header("Authorization") String Authorization,
                                    @QueryMap Map<String, String> map);


    /**
     * 18.2.19 根据班级ID获取知识点列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/db/knowledgeList")
    Call<ResponseBody> dbKnowledgelist(@Header("Authorization") String Authorization,
                                       @QueryMap Map<String, String> map);


    /**
     * 18.2.20 学生统计信息
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/db/queryQrStudentCountForGz")
    Call<ResponseBody> dbQueryqrstudentcountforgz(@Header("Authorization") String Authorization,
                                                  @QueryMap Map<String, String> map);


    /**
     * 18.2.21 题目统计信息
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/db/queryQrQuestionCountForGz")
    Call<ResponseBody> dbQueryqrquestioncountforgz(@Header("Authorization") String Authorization,
                                                   @QueryMap Map<String, String> map);


    /**
     * 18.3.1 上传教学视频
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("report/questions/uploadVideoStatus")
    @FormUrlEncoded
    Call<ResponseBody> questionsUploadvideostatus(@Header("Authorization") String Authorization,
                                                  @FieldMap Map<String, String> map);


    /**
     * 18.3.2 上传教学视频回调
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("report/questions/teachVideoBackcall")
    @FormUrlEncoded
    Call<ResponseBody> questionsTeachvideobackcall(@Header("Authorization") String Authorization,
                                                   @FieldMap Map<String, String> map);


    /**
     * 18.3.3 查询教学视频
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/questions/teachVideo")
    Call<ResponseBody> questionsTeachvideo(@Header("Authorization") String Authorization,
                                           @QueryMap Map<String, String> map);


    /**
     * 18.3.4 删除教学视频
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("report/questions/deleteTeachVideo")
    @FormUrlEncoded
    Call<ResponseBody> questionsDeleteteachvideo(@Header("Authorization") String Authorization,
                                                 @FieldMap Map<String, String> map);


    /**
     * 18.3.5 上传教学视频
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("report/questions/uploadVideo")
    @FormUrlEncoded
    Call<ResponseBody> questionsUploadvideo(@Header("Authorization") String Authorization,
                                            @FieldMap Map<String, String> map);

    /**
     * 18.3.6 获取收藏
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/questions/correction")
    Call<ResponseBody> getQuestionsCorrection(@Header("Authorization") String Authorization,
                                              @QueryMap Map<String, String> map);

    /**
     * 18.3.7 进行收藏标记
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("report/questions/correction")
    @FormUrlEncoded
    Call<ResponseBody> postQuestionsCorrection(@Header("Authorization") String Authorization,
                                               @FieldMap Map<String, String> map);

    /**
     * 18.3.8 标错
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("report/questions/wrongMarker")
    @FormUrlEncoded
    Call<ResponseBody> questionsWrongmarker(@Header("Authorization") String Authorization,
                                            @FieldMap Map<String, String> map);


    /**
     * 18.4.1 查询作业详情
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/homework/detail")
    Call<ResponseBody> homeworkDetail(@Header("Authorization") String Authorization,
                                      @QueryMap Map<String, String> map);


    /**
     * 18.4.3 查询作业列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/homework/list")
    Call<ResponseBody> homeworkList(@Header("Authorization") String Authorization,
                                    @QueryMap Map<String, String> map);


    /**
     * 18.4.2 查询作业成绩详情
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/homework/score/detail/ps")
    Call<ResponseBody> homeworkScoreDetailPs(@Header("Authorization") String Authorization,
                                             @QueryMap Map<String, String> map);

    /**
     * 18.4.4 提醒作业
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("wpa/weixin/remind")
    @FormUrlEncoded
    Call<ResponseBody> weixinRemind(@Header("Authorization") String Authorization,
                                    @FieldMap Map<String, String> map);


    /**
     * 18.4.5 查询学生作业拍摄原图
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/homework/page")
    Call<ResponseBody> homeworkPage(@Header("Authorization") String Authorization,
                                    @QueryMap Map<String, String> map);


    /**
     * 18.5.2 查询作业成绩错误率对比
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("report/homework/score/detail/rate")
    Call<ResponseBody> homeworkScoreDetailRate(@Header("Authorization") String Authorization,
                                               @QueryMap Map<String, String> map);


}
