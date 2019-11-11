package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface WebUsrInterface {

    @POST("mizhu/web/usr/editUser")
    @FormUrlEncoded
    Call<ResponseBody> editUser(@Field("token") String token,
                                @FieldMap Map<String, String> map);


}
