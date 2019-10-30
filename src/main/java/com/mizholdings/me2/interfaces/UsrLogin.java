package com.mizholdings.me2.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UsrLogin {

    @POST("mizhu/web/usr/login")
    @FormUrlEncoded
    Call<ResponseBody> user_login(@Field("userName") String userName,
                                  @Field("password") String password);

}




