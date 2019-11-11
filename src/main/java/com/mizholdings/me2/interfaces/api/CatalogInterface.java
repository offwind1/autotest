package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface CatalogInterface {


    /**
     * 查询用户的试题
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/catalog/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 根据试题ID查询题目
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/catalog/quesByCatalogId")
    @FormUrlEncoded
    Call<ResponseBody> quesByCatalogId(@Field("token") String token,
                                       @FieldMap Map<String, String> map);


}