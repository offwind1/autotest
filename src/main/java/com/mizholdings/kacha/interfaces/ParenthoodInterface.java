package com.mizholdings.kacha.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ParenthoodInterface {
    String path = "parenthood";
    String url = path + "/";

    /**
     * 3.1.1 子女列表
     *
     * @param Authorization
     * @param year
     * @return
     */
    @GET(url + "childs")
    Call<ResponseBody> getChilds(@Header("Authorization") String Authorization,
                                 @Query("year") String year);


    /**
     * 3.1.2 添加子女
     *
     * @param Authorization
     * @param name
     * @return
     */
    @POST(url + "addChild")
    @FormUrlEncoded
    Call<ResponseBody> addChilds(@Header("Authorization") String Authorization,
                                 @Field("name") String name);

    /**
     * 3.1.3 修改子女姓名
     *
     * @param Authorization
     * @param childId
     * @param name
     * @return
     */
    @POST(url + "updateChild")
    @FormUrlEncoded
    Call<ResponseBody> updateChild(@Header("Authorization") String Authorization,
                                   @Field("childId") String childId,
                                   @Field("name") String name);

    /**
     * 3.1.4 解除亲子关系
     *
     * @param Authorization
     * @param childId
     * @return
     */
    @POST(url + "deleteChild")
    @FormUrlEncoded
    Call<ResponseBody> deleteChild(@Header("Authorization") String Authorization,
                                   @Field("childId") String childId);

    /**
     * 3.2.1 亲子绑定码
     *
     * @param Authorization
     * @param childId
     * @return
     */
    @GET(url + "bindCode")
    Call<ResponseBody> bindCode(@Header("Authorization") String Authorization,
                                @Query("childId") String childId);

    /**
     * 3.2.2 亲子绑定
     *
     * @param Authorization
     * @param code
     * @return
     */
    @POST(url + "bindChild")
    @FormUrlEncoded
    Call<ResponseBody> bindChild(@Header("Authorization") String Authorization,
                                 @Field("code") String code);

    /**
     * 3.3.1 当前子女
     *
     * @param Authorization
     * @param childId
     * @return
     */
    @POST(url + "currentChild")
    @FormUrlEncoded
    Call<ResponseBody> setCurrentChild(@Header("Authorization") String Authorization,
                                       @Field("childId") String childId);

    /**
     * 3.3.2 获取当前子女
     *
     * @param Authorization
     * @return
     */
    @GET(url + "currentChild")
    Call<ResponseBody> getCurrentChild(@Header("Authorization") String Authorization);


}
