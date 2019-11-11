package com.mizholdings.kacha.interfaces;

import com.mizholdings.util.Env;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface AuthInterface {
    @FormUrlEncoded
    @POST("auth/login/{project}")
    Call<ResponseBody> login(@Path("project") String project,
                             @Field("account") String account,
                             @Field("password") String password);

    /**
     * 1.4.1 获取用户权限
     *
     * @param Authorization
     * @return
     */
    @GET("auth/permission/info")
    Call<ResponseBody> getPermissionInfo(@Header("Authorization") String Authorization);

    /**
     * @param Authorization
     * @param map           {
     *                      *userId：       被指派的用户ID
     *                      *schoolId：     学校ID
     *                      *year：         学年
     *                      *roleName：     角色名
     *                      grade：         年级（暂时不传）
     *                      classId：       班级（指派班主任时需要传）
     *                      }
     * @return
     */
    @POST("auth/role/assign")
    @FormUrlEncoded
    Call<ResponseBody> assignAuth(@Header("Authorization") String Authorization,
                                  @FieldMap Map<String, String> map);

}
