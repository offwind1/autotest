package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface UsrauthenInterface {


/**
 * 用户认证
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/api/usrAuthen/addAuthen")
@FormUrlEncoded
Call<ResponseBody> addAuthen(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询用户认证列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/api/usrAuthen/list")
@FormUrlEncoded
Call<ResponseBody> list(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}