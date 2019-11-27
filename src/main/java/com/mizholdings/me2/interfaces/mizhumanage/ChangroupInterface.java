package com.mizholdings.me2.interfaces.mizhumanage;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface ChangroupInterface {


    /**
     * 渠道群管理
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chanGroup/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 渠道群添加
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chanGroup/add")
    @FormUrlEncoded
    Call<ResponseBody> add(@Field("token") String token,
                           @FieldMap Map<String, String> map);

    /**
     * 渠道群编辑
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chanGroup/edit")
    @FormUrlEncoded
    Call<ResponseBody> edit(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 渠道群删除
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chanGroup/del")
    @FormUrlEncoded
    Call<ResponseBody> del(@Field("token") String token,
                           @FieldMap Map<String, String> map);


}