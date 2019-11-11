package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface ClassChartInterface {

    /**
     * 课堂互动列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/interact")
    @FormUrlEncoded
    Call<ResponseBody> interact(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 到课统计
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/arrive")
    @FormUrlEncoded
    Call<ResponseBody> arrive(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 作业统计
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/homework")
    @FormUrlEncoded
    Call<ResponseBody> homework(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 答题进度
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/answer")
    @FormUrlEncoded
    Call<ResponseBody> answer(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 课堂统计导出XLS
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/export")
    @FormUrlEncoded
    Call<ResponseBody> export(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 导出XLS考勤概述
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/summary")
    @FormUrlEncoded
    Call<ResponseBody> summary(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 根据班级导出XLS
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/exportByStuId")
    @FormUrlEncoded
    Call<ResponseBody> exportByStuId(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 根据时间班级查询考勤信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/getAttendanceByStuId")
    @FormUrlEncoded
    Call<ResponseBody> getAttendanceByStuId(@Field("token") String token,
                                            @FieldMap Map<String, String> map);

    /**
     * 根据时间班级查询考勤详细信息(学生考勤)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/getAttendanceInfoByStuId")
    @FormUrlEncoded
    Call<ResponseBody> getAttendanceInfoByStuId(@Field("token") String token,
                                                @FieldMap Map<String, String> map);

    /**
     * 学科考勤（总表）
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/getLessonTypeDili")
    @FormUrlEncoded
    Call<ResponseBody> getLessonTypeDili(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

    /**
     * 学科考勤（班级表）
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/getLessonTypeDiliClass")
    @FormUrlEncoded
    Call<ResponseBody> getLessonTypeDiliClass(@Field("token") String token,
                                              @FieldMap Map<String, String> map);

    /**
     * 学科考勤XLS文件导出
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/exportByLesType")
    @FormUrlEncoded
    Call<ResponseBody> exportByLesType(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 回放记录-班级（总表）
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/getVideoList")
    @FormUrlEncoded
    Call<ResponseBody> getVideoList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 回放记录-班级（详情表）
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/getVideoListClass")
    @FormUrlEncoded
    Call<ResponseBody> getVideoListClass(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

    /**
     * 视频回看统计导出
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/exportByVideo")
    @FormUrlEncoded
    Call<ResponseBody> exportByVideo(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 回放记录-学科（列表）
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/getVideoLesType")
    @FormUrlEncoded
    Call<ResponseBody> getVideoLesType(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 回放记录-学科（详情表）
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/getVideoLesTypeClass")
    @FormUrlEncoded
    Call<ResponseBody> getVideoLesTypeClass(@Field("token") String token,
                                            @FieldMap Map<String, String> map);

    /**
     * 回放记录-学科-导出
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classChart/exportByVideoType")
    @FormUrlEncoded
    Call<ResponseBody> exportByVideoType(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

}
