package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface QiniuInterface {

    
/**
 * 获得uptoken
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/qiniu/getUptoken")
@FormUrlEncoded
Call<ResponseBody> getUptoken(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加课堂视频转码
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/qiniu/addClassVideoTranscoding")
@FormUrlEncoded
Call<ResponseBody> addClassVideoTranscoding(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加课件资源转码
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/qiniu/addCoursewareTranscoding")
@FormUrlEncoded
Call<ResponseBody> addCoursewareTranscoding(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}