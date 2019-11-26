package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface ItemInterface {

    /**
     * 查询收费列表
     */
    @POST("/mizhu/web/item/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token, @FieldMap Map<String, String> map);

    /**
     * 添加收款项目
     */
    @POST("/mizhu/web/item/add")
    @FormUrlEncoded
    Call<ResponseBody> add(@Field("token") String token, @FieldMap Map<String, String> map);

    /**
     * 修改收款项目
     */
    @POST("/mizhu/web/item/update")
    @FormUrlEncoded
    Call<ResponseBody> update(@Field("token") String token, @FieldMap Map<String, String> map);

    /**
     * 查询收款项目信息item/getById
     */
    @POST("/mizhu/web/item/getById")
    @FormUrlEncoded
    Call<ResponseBody> getById(@Field("token") String token, @FieldMap Map<String, String> map);


}
