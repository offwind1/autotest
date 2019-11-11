package com.mizholdings.me2.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface IntegInterface {
    /**
     * 积分增加(课堂举手，老师同意时调用)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/integ/execute")
    @FormUrlEncoded
    Call<ResponseBody> execute(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 课堂中第一次文字、图片互动
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/integ/words")
    @FormUrlEncoded
    Call<ResponseBody> words(@Field("token") String token,
                             @FieldMap Map<String, String> map);


    /**
     * 查询积分规则列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/integ/integList")
    @FormUrlEncoded
    Call<ResponseBody> integList(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 新增积分规则
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/integ/add")
    @FormUrlEncoded
    Call<ResponseBody> add(@Field("token") String token,
                           @FieldMap Map<String, String> map);

    /**
     * 根据积分规则id查询积分规则信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/integ/getIntegById")
    @FormUrlEncoded
    Call<ResponseBody> getIntegById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 修改积分规则
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/integ/editIntegRule")
    @FormUrlEncoded
    Call<ResponseBody> editIntegRule(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 删除积分规则
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/integ/delIntegRule")
    @FormUrlEncoded
    Call<ResponseBody> delIntegRule(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 用户积分查询
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/integ/userIntegList")
    @FormUrlEncoded
    Call<ResponseBody> userIntegList(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 修改用户积分
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/integ/editInteg")
    @FormUrlEncoded
    Call<ResponseBody> editInteg(@Field("token") String token,
                                 @FieldMap Map<String, String> map);


}
