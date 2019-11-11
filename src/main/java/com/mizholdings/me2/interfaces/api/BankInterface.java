package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface BankInterface {

    /**
     * 银行列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/bank/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 获取提现账号
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/bank/drawAccount")
    @FormUrlEncoded
    Call<ResponseBody> drawAccount(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 设置支付密码
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/bank/paypwd")
    @FormUrlEncoded
    Call<ResponseBody> paypwd(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 申请提现
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/bank/drawApply")
    @FormUrlEncoded
    Call<ResponseBody> drawApply(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 绑定银行卡
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/bank/binding")
    @FormUrlEncoded
    Call<ResponseBody> binding(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 解除银行卡绑定
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/bank/rmBinding")
    @FormUrlEncoded
    Call<ResponseBody> rmBinding(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 用户钱包主界面
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/bank/userWallet")
    @FormUrlEncoded
    Call<ResponseBody> userWallet(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 用户直播界面数据
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/bank/userDirect")
    @FormUrlEncoded
    Call<ResponseBody> userDirect(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

}
