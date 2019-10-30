package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GradeInterface {

    @POST("mizhu/api/grade/list")
    @FormUrlEncoded
    Call<ResponseBody> grade_list(@Field("token") String token);

}
