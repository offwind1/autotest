package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface CreditInterface {

    /**
     * 添加学分信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/credit/addCreditInfo")
    @FormUrlEncoded
    Call<ResponseBody> addCreditInfo(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 根据用户查询学分
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/credit/creditList")
    @FormUrlEncoded
    Call<ResponseBody> creditList(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 用户积分记录
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/credit/userCredit")
    @FormUrlEncoded
    Call<ResponseBody> userCredit(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 获取用户学分信息
     *
     * @param token
     * @return
     */
    @POST("mizhu/web/credit/getCreditByUserId")
    @FormUrlEncoded
    Call<ResponseBody> getCreditByUserId(@Field("token") String token);

    /**
     * 修改学分信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/credit/editCreditInfo")
    @FormUrlEncoded
    Call<ResponseBody> editCreditInfo(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 修改积分
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/credit/editUserCredit")
    @FormUrlEncoded
    Call<ResponseBody> editUserCredit(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 查询课程列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/credit/creditLessonList")
    @FormUrlEncoded
    Call<ResponseBody> creditLessonList(@Field("token") String token,
                                        @FieldMap Map<String, String> map);

    /**
     * 学分资源列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/credit/creditCourseList")
    @FormUrlEncoded
    Call<ResponseBody> creditCourseList(@Field("token") String token,
                                        @FieldMap Map<String, String> map);


}
