package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface MobileInterface {

    /**
     * 用户登录
     *
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/login")
    @FormUrlEncoded
    Call<ResponseBody> login(@FieldMap Map<String, String> map);

    /**
     * 获取用户信息
     *
     * @param token
     * @return
     */
    @POST("mizhu/api/mobile/userInfo")
    @FormUrlEncoded
    Call<ResponseBody> userInfo(@Field("token") String token);


    /**
     * 获取验证码(手机/邮箱)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/phoneCode")
    @FormUrlEncoded
    Call<ResponseBody> phoneCode(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * token自动登陆
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/tokenLogin")
    @FormUrlEncoded
    Call<ResponseBody> tokenLogin(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 用户退出
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/loginOut")
    @FormUrlEncoded
    Call<ResponseBody> loginOut(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 用户注册(手机号/账号/邮箱)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/userRegister")
    @FormUrlEncoded
    Call<ResponseBody> userRegister(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 忘记密码
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/findPassword")
    @FormUrlEncoded
    Call<ResponseBody> findPassword(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 修改手机号或者邮箱
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/updateContact")
    @FormUrlEncoded
    Call<ResponseBody> updateContact(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 修改用户信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/updateUserInfo")
    @FormUrlEncoded
    Call<ResponseBody> updateUserInfo(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 根据用户CODE，获得云信ID
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/userByCode")
    @FormUrlEncoded
    Call<ResponseBody> userByCode(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 根据ID获得用户信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/userInfoById")
    @FormUrlEncoded
    Call<ResponseBody> userInfoById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 收藏用户
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/keepUser")
    @FormUrlEncoded
    Call<ResponseBody> keepUser(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 取消收藏
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/rmkeepUser")
    @FormUrlEncoded
    Call<ResponseBody> rmkeepUser(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 机构用户管理的教师列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/orgUserList")
    @FormUrlEncoded
    Call<ResponseBody> orgUserList(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 用户修改密码
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/updatePassword")
    @FormUrlEncoded
    Call<ResponseBody> updatePassword(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 用户绑定手机(验证码类型为4)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/bingPhone")
    @FormUrlEncoded
    Call<ResponseBody> bingPhone(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 第三方登陆
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/otherLogin")
    @FormUrlEncoded
    Call<ResponseBody> otherLogin(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * APP扫码，登录页面端
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/login2")
    @FormUrlEncoded
    Call<ResponseBody> login2(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 机构用户/教师的课件(微课)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/orgCourseList")
    @FormUrlEncoded
    Call<ResponseBody> orgCourseList(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 扫码登陆web接口
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/scanLogin")
    @FormUrlEncoded
    Call<ResponseBody> scanLogin(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 分享页面注册
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/shareUserRegister")
    @FormUrlEncoded
    Call<ResponseBody> shareUserRegister(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

    /**
     * 根据手机获取用户信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/getUserInfoByPhone")
    @FormUrlEncoded
    Call<ResponseBody> getUserInfoByPhone(@Field("token") String token,
                                          @FieldMap Map<String, String> map);

    /**
     * 增加用户的米猪时光
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/getMizhuTime")
    @FormUrlEncoded
    Call<ResponseBody> getMizhuTime(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * ISO系统登陆
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/mobile/appleLogin")
    @FormUrlEncoded
    Call<ResponseBody> appleLogin(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

}
