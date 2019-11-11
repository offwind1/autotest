package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface UsrtagInterface {


/**
 * 查询用户标签
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/api/usrTag/list")
@FormUrlEncoded
Call<ResponseBody> list(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加用户标签
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/api/usrTag/addUsrTag")
@FormUrlEncoded
Call<ResponseBody> addUsrTag(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}