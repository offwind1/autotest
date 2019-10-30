package com.mizholdings.kacha.interfaces;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserInterface {
    /**
     * 2.1.1 用户信息
     *
     * @param Authorization
     * @param userId
     * @return
     */
    @GET("user/userInfo")
    Call<ResponseBody> getUserInfo(@Header("Authorization") String Authorization,
                                   @Query("userId") String userId);

    @POST("user/userInfo")
    Call<ResponseBody> updateUserInfo(@Header("Authorization") String Authorization,
                                      @Body RequestBody body);


    /**
     * 2.1.2 用户外部信息
     *
     * @param Authorization
     * @return
     */
    @GET("user/outInfo")
    Call<ResponseBody> outInfo(@Header("Authorization") String Authorization);


    // TODO: 2019/10/28 2.2.2 微信保存电话号码

    /**
     * 2.2.3 修改密码
     *
     * @param Authorization
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @POST("user/userInfo/password")
    @FormUrlEncoded
    Call<ResponseBody> updatePassword(@Header("Authorization") String Authorization,
                                      @Field("oldPwd") String oldPwd,
                                      @Field("newPwd") String newPwd);


    // TODO: 2019/10/28 2.3.1 外部一键投胎


    /**
     * 2.4.1获取短信随机码
     *
     * @param Authorization
     * @param phone
     * @return
     */
    @GET("user/phone/random")
    Call<ResponseBody> getPhoneRandom(@Header("Authorization") String Authorization,
                                      @Query("phone") String phone);

    /**
     * 2.4.2 修改密码通过随机码
     *
     * @param Authorization
     * @param phone
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @POST("user/phone/password")
    Call<ResponseBody> updatePhonePassword(@Header("Authorization") String Authorization,
                                           @Field("phone") String phone,
                                           @Field("oldPwd") String oldPwd,
                                           @Field("newPwd") String newPwd);

    /**
     * 2.4.3 校验随机码（临时）
     *
     * @param Authorization
     * @param phone
     * @param random
     * @return
     */
    @GET("user/phone/check")
    Call<ResponseBody> phoneCheck(@Header("Authorization") String Authorization,
                                  @Field("phone") String phone,
                                  @Field("random") String random);


}
