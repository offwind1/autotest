package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface RankInterface {


    /**
     * 名师，前三名
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/rank/teacherTop")
    @FormUrlEncoded
    Call<ResponseBody> teacherTop(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 名师排行
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/rank/teacherList")
    @FormUrlEncoded
    Call<ResponseBody> teacherList(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 课程，排行
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/rank/lessonList")
    @FormUrlEncoded
    Call<ResponseBody> lessonList(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 机构，排行
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/rank/orgList")
    @FormUrlEncoded
    Call<ResponseBody> orgList(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 查询明星老师的预约课
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/rank/bespeak")
    @FormUrlEncoded
    Call<ResponseBody> bespeak(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 学习之星
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/rank/studyStar")
    @FormUrlEncoded
    Call<ResponseBody> studyStar(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

}
