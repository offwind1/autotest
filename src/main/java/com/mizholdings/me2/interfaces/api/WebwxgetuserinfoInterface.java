package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface WebwxgetuserinfoInterface {


    /**
     * 网页微信用户信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/webWxGetUserInfo")
    @FormUrlEncoded
    Call<ResponseBody> webWxGetUserInfo(@Field("token") String token,
                                        @FieldMap Map<String, String> map);


}