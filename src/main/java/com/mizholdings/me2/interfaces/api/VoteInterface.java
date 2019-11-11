package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface VoteInterface {


    /**
     * 老师发起投票
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/vote/insert")
    @FormUrlEncoded
    Call<ResponseBody> insert(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 查询课堂中所有投票
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/vote/getList")
    @FormUrlEncoded
    Call<ResponseBody> getList(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 提交投票结果
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/vote/subOption")
    @FormUrlEncoded
    Call<ResponseBody> subOption(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 获得投票用户列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/vote/getOptionUser")
    @FormUrlEncoded
    Call<ResponseBody> getOptionUser(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 结束投票
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/vote/voteEnd")
    @FormUrlEncoded
    Call<ResponseBody> voteEnd(@Field("token") String token,
                               @FieldMap Map<String, String> map);

}
