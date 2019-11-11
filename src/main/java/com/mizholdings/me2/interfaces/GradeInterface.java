package com.mizholdings.me2.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface GradeInterface {

    //api
    /**
     * 查询年级列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/grade/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 查询年级列表(标签类型)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/grade/taglist")
    @FormUrlEncoded
    Call<ResponseBody> taglist(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 年级列表（绑定学科）
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/grade/gradelist")
    @FormUrlEncoded
    Call<ResponseBody> gradelist(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 根据机构ID查询年级和学科列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/grade/listByOrgId")
    @FormUrlEncoded
    Call<ResponseBody> listByOrgId(@Field("token") String token,
                                   @FieldMap Map<String, String> map);


    //web

    @POST("mizhu/web/grade/addClass")
    @FormUrlEncoded
    Call<ResponseBody> addClass(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    @POST("mizhu/web/grade/classList")
    @FormUrlEncoded
    Call<ResponseBody> classList(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    @POST("mizhu/web/grade/delClass")
    @FormUrlEncoded
    Call<ResponseBody> delClass(@Field("token") String token,
                                @FieldMap Map<String, String> map);


}
