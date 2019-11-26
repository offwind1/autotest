package com.mizholdings.me2.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface PayInterface {

    /**
     * 获得充值图标
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/rateList")
    @FormUrlEncoded
    Call<ResponseBody> rateList(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 用户充值
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/usrRecharge")
    @FormUrlEncoded
    Call<ResponseBody> usrRecharge(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 用户购买课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/buyLesson")
    @FormUrlEncoded
    Call<ResponseBody> buyLesson(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 购买资源
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/buyCourseware")
    @FormUrlEncoded
    Call<ResponseBody> buyCourseware(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 获取Ping++支付凭证
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/getPingxx")
    @FormUrlEncoded
    Call<ResponseBody> getPingxx(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 查询用户充值记录
     *
     * @param token
     * @return
     */
    @POST("mizhu/api/pay/userTrans")
    @FormUrlEncoded
    Call<ResponseBody> userTrans(@Field("token") String token);

    /**
     * 获取提现账号
     *
     * @param token
     * @return
     */
    @POST("mizhu/api/pay/drawAccount")
    @FormUrlEncoded
    Call<ResponseBody> drawAccount(@Field("token") String token);

    /**
     * 提现申请
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/drawApply")
    @FormUrlEncoded
    Call<ResponseBody> drawApply(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 扫码支付（支付宝或微信）
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/getPingxxScan")
    @FormUrlEncoded
    Call<ResponseBody> getPingxxScan(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 苹果支付成功后调用
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/applePayReturn")
    @FormUrlEncoded
    Call<ResponseBody> applePayReturn(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 获取充值图标
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/rateListForWeb")
    @FormUrlEncoded
    Call<ResponseBody> rateListForWeb(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * web微信充值
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/webUsrRecharge")
    @FormUrlEncoded
    Call<ResponseBody> webUsrRecharge(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 获取微信、支付宝二维码
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/getNative")
    @FormUrlEncoded
    Call<ResponseBody> getNative(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 获得充值图标(IOS端)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/rateForApple")
    @FormUrlEncoded
    Call<ResponseBody> rateForApple(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 转换橙币，和橙时光(IOS)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/pay/convertAmout")
    @FormUrlEncoded
    Call<ResponseBody> convertAmout(@Field("token") String token,
                                    @FieldMap Map<String, String> map);


    /**
     * 网页JSAPI支付
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/pay/buyLessonUseJSAPI")
    @FormUrlEncoded
    Call<ResponseBody> buyLessonUseJSAPI(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

    /**
     * 获取网页微信用户信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/pay/webWxGetUserInfo")
    @FormUrlEncoded
    Call<ResponseBody> webWxGetUserInfo(@Field("token") String token,
                                        @FieldMap Map<String, String> map);

    /**
     * 微信H5充值
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/pay/wxpayH5")
    @FormUrlEncoded
    Call<ResponseBody> wxpayH5(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 轮训检查充值结果
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/pay/getRechargeResult")
    @FormUrlEncoded
    Call<ResponseBody> getRechargeResult(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

}
