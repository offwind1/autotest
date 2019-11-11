package com.mizholdings.kacha.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface VipInterface {


    /**
     * 13.1.1 会员信息
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("vip/op/vipInfo")
    Call<ResponseBody> opVipinfo(@Header("Authorization") String Authorization,
                                 @QueryMap Map<String, String> map);

    /**
     * 13.1.2 获得价格信息
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("vip/op/price")
    Call<ResponseBody> opPrice(@Header("Authorization") String Authorization,
                               @QueryMap Map<String, String> map);




    /**
     * 13.2.1 vip微信小程序支付
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("vip/op/wxPay")
    @FormUrlEncoded
    Call<ResponseBody> opWxpay(@Header("Authorization") String Authorization,
                               @FieldMap Map<String, String> map);






}
