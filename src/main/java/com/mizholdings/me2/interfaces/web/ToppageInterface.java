package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface ToppageInterface {


    /**
     * 推荐内容
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/topPage/recommend")
    @FormUrlEncoded
    Call<ResponseBody> recommend(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 推荐列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/topPage/topPageList")
    @FormUrlEncoded
    Call<ResponseBody> topPageList(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 修改推荐项
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/topPage/edit")
    @FormUrlEncoded
    Call<ResponseBody> edit(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 撤销推荐
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/topPage/delTopPage")
    @FormUrlEncoded
    Call<ResponseBody> delTopPage(@Field("token") String token,
                                  @FieldMap Map<String, String> map);


}