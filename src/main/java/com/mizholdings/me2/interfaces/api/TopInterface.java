package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface TopInterface {


    /**
     * 主页轮播广告
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/advertList")
    @FormUrlEncoded
    Call<ResponseBody> advertList(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 学科列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/usrMenu")
    @FormUrlEncoded
    Call<ResponseBody> usrMenu(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 查询主页列表项
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/topList")
    @FormUrlEncoded
    Call<ResponseBody> topList(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 主页，加载更多
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/topMore")
    @FormUrlEncoded
    Call<ResponseBody> topMore(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 选课中心主页
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/chooseList")
    @FormUrlEncoded
    Call<ResponseBody> chooseList(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 导引页接口
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/bootpage")
    @FormUrlEncoded
    Call<ResponseBody> bootpage(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 资源库主页
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/coursList")
    @FormUrlEncoded
    Call<ResponseBody> coursList(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 选课中心，加载更多
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/chooseMore")
    @FormUrlEncoded
    Call<ResponseBody> chooseMore(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 资源库，加载更多
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/coursMore")
    @FormUrlEncoded
    Call<ResponseBody> coursMore(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 查询直播课
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/playLesson")
    @FormUrlEncoded
    Call<ResponseBody> playLesson(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 最近将要直播的10堂课
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/minTimeLesson")
    @FormUrlEncoded
    Call<ResponseBody> minTimeLesson(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 搜索推荐
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/getSearchCem")
    @FormUrlEncoded
    Call<ResponseBody> getSearchCem(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 机构新闻更多
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/v2OrgMsgList")
    @FormUrlEncoded
    Call<ResponseBody> v2OrgMsgList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);


    /**
     * 首页列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/top/v2topList")
    @FormUrlEncoded
    Call<ResponseBody> v2topList(@Field("token") String token,
                                 @FieldMap Map<String, String> map);


}
