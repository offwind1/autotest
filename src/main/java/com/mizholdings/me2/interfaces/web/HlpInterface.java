package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface HlpInterface {

    
/**
 * 根据ID获取好友助力列表（最近的前10个）
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/hlp/getHlpList")
@FormUrlEncoded
Call<ResponseBody> getHlpList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 *  根据code判断是否老用户，老用户则返回用户信息，新用户则不返回
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/hlp/getWxUserInfo")
@FormUrlEncoded
Call<ResponseBody> getWxUserInfo(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 老用户绑定微信账号（暂时不用）
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/hlp/bangdingWX")
@FormUrlEncoded
Call<ResponseBody> bangdingWX(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 参加助力
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/hlp/joinHelp")
@FormUrlEncoded
Call<ResponseBody> joinHelp(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 助力榜单
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/hlp/getTopList")
@FormUrlEncoded
Call<ResponseBody> getTopList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 获取WX签名字段
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/hlp/getWxsign")
@FormUrlEncoded
Call<ResponseBody> getWxsign(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 领取助力积分活动
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web//hlp/helperReward")
@FormUrlEncoded
Call<ResponseBody> helperReward(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}