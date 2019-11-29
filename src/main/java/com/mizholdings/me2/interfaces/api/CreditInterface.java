package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface CreditInterface {

    /**
     * 学生学习资源，获取学分
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/credit/addByCourse")
    @FormUrlEncoded
    Call<ResponseBody> addByCourse(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 学生学习课堂，老师指定学分
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/credit/addByClassroom")
    @FormUrlEncoded
    Call<ResponseBody> addByClassroom(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 用户查询自己的学分
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/credit/getCreditList")
    @FormUrlEncoded
    Call<ResponseBody> getCreditList(@Field("token") String token,
                                     @FieldMap Map<String, String> map);



}
