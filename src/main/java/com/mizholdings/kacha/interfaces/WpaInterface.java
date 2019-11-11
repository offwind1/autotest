package com.mizholdings.kacha.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface WpaInterface {


    /**
     * 17.1.1 查询关注班级事件
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("wpa/mapp/scan/class")
    Call<ResponseBody> mappScanClass(@Header("Authorization") String Authorization,
                                     @QueryMap Map<String, String> map);


    /**
     * 17.1.2 消费关注班级事件
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("wpa/mapp/scan/consume")
    @FormUrlEncoded
    Call<ResponseBody> mappScanConsume(@Header("Authorization") String Authorization,
                                       @FieldMap Map<String, String> map);


    /**
     * 17.1.3 微信公众号班级二维码
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("wpa/weixin/wxCode")
    @FormUrlEncoded
    Call<ResponseBody> weixinWxcode(@Header("Authorization") String Authorization,
                                    @FieldMap Map<String, String> map);


}
