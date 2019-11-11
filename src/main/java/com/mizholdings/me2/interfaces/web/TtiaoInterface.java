package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface TtiaoInterface {

    
/**
 * 获取课程价格
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/ttiao/getLesson")
@FormUrlEncoded
Call<ResponseBody> getLesson(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 开始报名
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/ttiao/enroll")
@FormUrlEncoded
Call<ResponseBody> enroll(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询订单支付状态
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/ttiao/orderStatus")
@FormUrlEncoded
Call<ResponseBody> orderStatus(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}