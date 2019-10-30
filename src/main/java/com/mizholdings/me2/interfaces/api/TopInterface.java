package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TopInterface {
    /**
     * 首页列表
     * @param token
     * @param gradeId
     * @param orgId
     * @param madeType
     * @return
     */
    @POST("mizhu/api/top/v2topList")
    @FormUrlEncoded
    Call<ResponseBody> v2topList(@Field("token") String token,
                                 @Field("gradeId") int gradeId,
                                 @Field("orgId") int orgId,
                                 @Field("madeType") int madeType);

    /**
     * 直播课更多
     * @param token
     * @param gradeId
     * @param orgId
     * @param madeType
     * @param page
     * @return
     */
    @POST("mizhu/api/top/v2playList")
    @FormUrlEncoded
    Call<ResponseBody> v2playList(@Field("token") String token,
                                  @Field("gradeId") int gradeId,
                                  @Field("orgId") int orgId,
                                  @Field("madeType") int madeType,
                                  @Field("page") int page);

    /**
     * 精品课更多
     * @param token
     * @param gradeId
     * @param orgId
     * @param madeType
     * @param createUserName
     * @return
     */
    @POST("mizhu/api/top/v2lesList")
    @FormUrlEncoded
    Call<ResponseBody> v2lesList(@Field("token") String token,
                                 @Field("gradeId") int gradeId,
                                 @Field("orgId") int orgId,
                                 @Field("madeType") int madeType,
                                 @Field("createUserName") String createUserName);

    /**
     * 机构新闻更多
     * @param token
     * @param page
     * @return
     */
    @POST("mizhu/api/top/v2OrgMsgList")
    @FormUrlEncoded
    Call<ResponseBody> v2OrgMsgList(@Field("token") String token,
                                    @Field("page") int page);

    /**
     * 学科列表
     * @param token
     * @param gradeId
     * @param page
     * @return
     */
    @POST("mizhu/api/top/usrMenu")
    @FormUrlEncoded
    Call<ResponseBody> usrMenu(@Field("token") String token,
                               @Field("gradeId") int gradeId,
                               @Field("page") int page);


}
