package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface ChanadvInterface {

    
/**
 * 渠道广告列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/chanAdv/list")
@FormUrlEncoded
Call<ResponseBody> list(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加新广告
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/chanAdv/add")
@FormUrlEncoded
Call<ResponseBody> add(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 广告编辑
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/chanAdv/edit")
@FormUrlEncoded
Call<ResponseBody> edit(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 广告删除
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/chanAdv/del")
@FormUrlEncoded
Call<ResponseBody> del(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}