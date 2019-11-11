package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface CourseApiInterface {


    /**
     * 资源列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 资源详情
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/coursewareInfo")
    @FormUrlEncoded
    Call<ResponseBody> coursewareInfo(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 资源筛选条件
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/screen")
    @FormUrlEncoded
    Call<ResponseBody> screen(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 获得资源评论列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/courseScore")
    @FormUrlEncoded
    Call<ResponseBody> courseScore(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 资源评论
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/score")
    @FormUrlEncoded
    Call<ResponseBody> score(@Field("token") String token,
                             @FieldMap Map<String, String> map);

    /**
     * 点赞资源
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/likedCourse")
    @FormUrlEncoded
    Call<ResponseBody> likedCourse(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 取消点赞
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/rmlikedCourse")
    @FormUrlEncoded
    Call<ResponseBody> rmlikedCourse(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 收藏资源
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/keepCourse")
    @FormUrlEncoded
    Call<ResponseBody> keepCourse(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 取消收藏
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/rmkeepCourse")
    @FormUrlEncoded
    Call<ResponseBody> rmkeepCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 相关推荐
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/relatedList")
    @FormUrlEncoded
    Call<ResponseBody> relatedList(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 我的资源
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/mylist")
    @FormUrlEncoded
    Call<ResponseBody> mylist(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 课堂中，更换课件时，课件详情
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/infoByClassroom")
    @FormUrlEncoded
    Call<ResponseBody> infoByClassroom(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 单纯查询子资源列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/childList")
    @FormUrlEncoded
    Call<ResponseBody> childList(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 上传ppt
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/uploadPpt")
    @FormUrlEncoded
    Call<ResponseBody> uploadPpt(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 我创建的资源列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/myCreate")
    @FormUrlEncoded
    Call<ResponseBody> myCreate(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 查询我购买的资源列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/myBuy")
    @FormUrlEncoded
    Call<ResponseBody> myBuy(@Field("token") String token,
                             @FieldMap Map<String, String> map);

    /**
     * 上传图片文件
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/uploadFile")
    @FormUrlEncoded
    Call<ResponseBody> uploadFile(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 我的资源PC
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/course/myBuyPC")
    @FormUrlEncoded
    Call<ResponseBody> myBuyPC(@Field("token") String token,
                               @FieldMap Map<String, String> map);


}
