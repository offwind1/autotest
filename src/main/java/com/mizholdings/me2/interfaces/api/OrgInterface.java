package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface OrgInterface {

    /**
     * 查询机构/学校列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/org/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 获取机构新闻
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/org/msglist")
    @FormUrlEncoded
    Call<ResponseBody> msglist(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 新闻详情
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/org/msgInfo")
    @FormUrlEncoded
    Call<ResponseBody> msgInfo(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 用户同意加入机构
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/org/joinOrg")
    @FormUrlEncoded
    Call<ResponseBody> joinOrg(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 添加机构
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/org/create")
    @FormUrlEncoded
    Call<ResponseBody> create(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 已经加入的机构列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/org/joinList")
    @FormUrlEncoded
    Call<ResponseBody> joinList(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 退出机构
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/org/removeOrg")
    @FormUrlEncoded
    Call<ResponseBody> removeOrg(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 禁止添加
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/org/disabled")
    @FormUrlEncoded
    Call<ResponseBody> disabled(@Field("token") String token,
                                @FieldMap Map<String, String> map);

}
