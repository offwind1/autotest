package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface ShareInterface {

    
/**
 * 分享资源
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/share/course")
@FormUrlEncoded
Call<ResponseBody> course(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 机构分享
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/share/org")
@FormUrlEncoded
Call<ResponseBody> org(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 课程分享
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/share/lesson")
@FormUrlEncoded
Call<ResponseBody> lesson(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 分享教师
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/share/teacher")
@FormUrlEncoded
Call<ResponseBody> teacher(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}