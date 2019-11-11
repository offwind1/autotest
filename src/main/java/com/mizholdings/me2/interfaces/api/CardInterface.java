package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface CardInterface {


/**
 * 试听卡兑换
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/api/card/exchange")
@FormUrlEncoded
Call<ResponseBody> exchange(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}