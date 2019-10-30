package com.mizholdings.kacha.interfaces;

import com.mizholdings.util.Env;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface AuthInterface {
    @FormUrlEncoded
    @POST("auth/login/{project}")
    Call<ResponseBody> login(@Path("project") String project,
                             @Field("account") String account,
                             @Field("password") String password);

    @GET("auth/permission/info")
    Call<ResponseBody> getPermissionInfo(@Header("Authorization") String Authorization);
}
