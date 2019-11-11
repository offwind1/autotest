package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface PushInterface {

    
/**
 * 查询标签列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/tagList")
@FormUrlEncoded
Call<ResponseBody> tagList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加标签
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/addTag")
@FormUrlEncoded
Call<ResponseBody> addTag(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据id查询标签详情
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/getTagById")
@FormUrlEncoded
Call<ResponseBody> getTagById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 修改标签信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/edit")
@FormUrlEncoded
Call<ResponseBody> edit(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 删除标签
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/deleteById")
@FormUrlEncoded
Call<ResponseBody> deleteById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 推送列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/pushList")
@FormUrlEncoded
Call<ResponseBody> pushList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 新增推送
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/addPush")
@FormUrlEncoded
Call<ResponseBody> addPush(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 审批推送
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/applyPush")
@FormUrlEncoded
Call<ResponseBody> applyPush(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 删除推送
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/deletePush")
@FormUrlEncoded
Call<ResponseBody> deletePush(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据推送id获取推送信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/getPushById")
@FormUrlEncoded
Call<ResponseBody> getPushById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 推送消息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/push/pushMessage")
@FormUrlEncoded
Call<ResponseBody> pushMessage(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}