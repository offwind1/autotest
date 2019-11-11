package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface FullschInterface {


    /**
     * 全文检索
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/fullsch/searchAll")
    @FormUrlEncoded
    Call<ResponseBody> searchAll(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 首页搜索2
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/fullsch/searchAll2")
    @FormUrlEncoded
    Call<ResponseBody> searchAll2(@Field("token") String token,
                                  @FieldMap Map<String, String> map);


}
