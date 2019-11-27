package com.mizholdings.me2.interfaces.mizhumanage;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface ChanInterface {


    /**
     * 渠道信息列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chan/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 渠道信息新增
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chan/add")
    @FormUrlEncoded
    Call<ResponseBody> add(@Field("token") String token,
                           @FieldMap Map<String, String> map);

    /**
     * 渠道信息编辑
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chan/edit")
    @FormUrlEncoded
    Call<ResponseBody> edit(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 渠道信息删除
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chan/del")
    @FormUrlEncoded
    Call<ResponseBody> del(@Field("token") String token,
                           @FieldMap Map<String, String> map);

    /**
     * 渠道信息详情
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chan/info")
    @FormUrlEncoded
    Call<ResponseBody> info(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 渠道绑定群
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chan/banding")
    @FormUrlEncoded
    Call<ResponseBody> banding(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 用户通过渠道扫码进群
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/chan/usrClick")
    @FormUrlEncoded
    Call<ResponseBody> usrClick(@Field("token") String token,
                                @FieldMap Map<String, String> map);


}