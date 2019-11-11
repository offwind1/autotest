package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface AgentInterface {


    /**
     * 代理商充值查询
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/recordList")
    @FormUrlEncoded
    Call<ResponseBody> recordList(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 查询代理商信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/getAgentInfoById")
    @FormUrlEncoded
    Call<ResponseBody> getAgentInfoById(@Field("token") String token,
                                        @FieldMap Map<String, String> map);

    /**
     * 根据账号查询代理商下的用户
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/getAgentUserByaAccount")
    @FormUrlEncoded
    Call<ResponseBody> getAgentUserByaAccount(@Field("token") String token,
                                              @FieldMap Map<String, String> map);

    /**
     * 代理商给用户充值
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/rechargeToUser")
    @FormUrlEncoded
    Call<ResponseBody> rechargeToUser(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 修改代理商信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/edit")
    @FormUrlEncoded
    Call<ResponseBody> edit(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 检验代理商原密码是否正确
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/checkPassword")
    @FormUrlEncoded
    Call<ResponseBody> checkPassword(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 代理商管理
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/agentList")
    @FormUrlEncoded
    Call<ResponseBody> agentList(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 新增代理商
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/addAgentUser")
    @FormUrlEncoded
    Call<ResponseBody> addAgentUser(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 检验代理商信息重复
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/checkAgent")
    @FormUrlEncoded
    Call<ResponseBody> checkAgent(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 根据代理商id获取代理商信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/getAgentUserById")
    @FormUrlEncoded
    Call<ResponseBody> getAgentUserById(@Field("token") String token,
                                        @FieldMap Map<String, String> map);

    /**
     * 修改代理商密码
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/changePassword")
    @FormUrlEncoded
    Call<ResponseBody> changePassword(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 查看代理商下的用户
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/agentUserList")
    @FormUrlEncoded
    Call<ResponseBody> agentUserList(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 删除代理商
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/deleteAgentUser")
    @FormUrlEncoded
    Call<ResponseBody> deleteAgentUser(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 修改代理商账户
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/editAgentBank")
    @FormUrlEncoded
    Call<ResponseBody> editAgentBank(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 代理商提现
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/agentDrawcash")
    @FormUrlEncoded
    Call<ResponseBody> agentDrawcash(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 获取代理商折扣区间
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/agent/getAgentDiscountById")
    @FormUrlEncoded
    Call<ResponseBody> getAgentDiscountById(@Field("token") String token,
                                            @FieldMap Map<String, String> map);


}