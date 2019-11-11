package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface CompartmentInterface {


/**
 * 查询省市列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/api/compartment/list")
@FormUrlEncoded
Call<ResponseBody> list(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询所有省和地市
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/api/compartment/alllist")
@FormUrlEncoded
Call<ResponseBody> alllist(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}