package com.mizholdings.kacha.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface ParenthoodInterface {
    String path = "parenthood";
    String url = path + "/";


    /**
     * 3.1.1 子女列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("parenthood/childs")
    Call<ResponseBody> childs(@Header("Authorization") String Authorization,
                              @QueryMap Map<String, String> map);


    /**
     * 3.1.2 添加子女
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("parenthood/addChild")
    @FormUrlEncoded
    Call<ResponseBody> addChild(@Header("Authorization") String Authorization,
                                @FieldMap Map<String, String> map);


    /**
     * 3.1.3 修改子女姓名
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("parenthood/updateChild")
    @FormUrlEncoded
    Call<ResponseBody> updateChild(@Header("Authorization") String Authorization,
                                   @FieldMap Map<String, String> map);


    /**
     * 3.1.4 解除亲子关系
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("parenthood/deleteChild")
    @FormUrlEncoded
    Call<ResponseBody> deleteChild(@Header("Authorization") String Authorization,
                                   @FieldMap Map<String, String> map);


    /**
     * 3.2.1 亲子绑定码
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("parenthood/bindCode")
    Call<ResponseBody> bindCode(@Header("Authorization") String Authorization,
                                @QueryMap Map<String, String> map);


    /**
     * 3.2.2 亲子绑定
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("parenthood/bindChild")
    @FormUrlEncoded
    Call<ResponseBody> bindChild(@Header("Authorization") String Authorization,
                                 @FieldMap Map<String, String> map);


    /**
     * 3.3.1 当前子女
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("parenthood/currentChild")
    @FormUrlEncoded
    Call<ResponseBody> currentChild(@Header("Authorization") String Authorization,
                                    @FieldMap Map<String, String> map);


    /**
     * 3.3.2 获取当前子女
     *
     * @param Authorization
     * @return
     */
    @GET(url + "currentChild")
    Call<ResponseBody> getCurrentChild(@Header("Authorization") String Authorization);


    /**
     * 3.3.2 获取当前子女
     *
     * @param Authorization
     * @return
     */
    @GET("parenthood/currentChild")
    Call<ResponseBody> currentChild(@Header("Authorization") String Authorization);

}
