package com.mizholdings.me2.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface AdvertInterface {

    /**
     * 获取弹窗广告
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/advert/getAlertAdvert")
    @FormUrlEncoded
    Call<ResponseBody> getAlertAdvert(@Field("token") String token,
                                      @FieldMap Map<String, String> map);




    /**
     * 广告列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/advert/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 添加广告
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/advert/add")
    @FormUrlEncoded
    Call<ResponseBody> add(@Field("token") String token,
                           @FieldMap Map<String, String> map);

    /**
     * 根据ID拿到广告详情
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/advert/getAdvertById")
    @FormUrlEncoded
    Call<ResponseBody> getAdvertById(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 广告编辑
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/advert/edit")
    @FormUrlEncoded
    Call<ResponseBody> edit(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 删除广告
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/advert/del")
    @FormUrlEncoded
    Call<ResponseBody> del(@Field("token") String token,
                           @FieldMap Map<String, String> map);


}
