package com.mizholdings.me2.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface LessonTypeInterface {


    /**
     * 查询学科分类
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lessonType/list")
    @FormUrlEncoded
    Call<ResponseBody> webList(@Field("token") String token,
                               @FieldMap Map<String, String> map);


    /**
     * 查询学科列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonType/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 查询用户选择的学科列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonType/userlist")
    @FormUrlEncoded
    Call<ResponseBody> userlist(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 学科编辑保存
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonType/savelist")
    @FormUrlEncoded
    Call<ResponseBody> savelist(@Field("token") String token,
                                @FieldMap Map<String, String> map);

}
