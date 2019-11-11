package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface LebuInterface {


/**
 * url免密登陆通用接口
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/api/Lebu/autoLogin")
@FormUrlEncoded
Call<ResponseBody> autoLogin(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}