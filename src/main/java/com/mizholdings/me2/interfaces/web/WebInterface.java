package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface WebInterface {

    
/**
 * 获取资源标签
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/web/course/getTags")
@FormUrlEncoded
Call<ResponseBody> getTags(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 新用户领取课程
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/web/usr/reverseLesson")
@FormUrlEncoded
Call<ResponseBody> reverseLesson(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}