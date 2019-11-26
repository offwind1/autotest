package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface OrginfoInterface {


    /**
     * 分页列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 根据ID拿到机构
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/getOrgById")
    @FormUrlEncoded
    Call<ResponseBody> getOrgById(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 添加机构
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/insert")
    @FormUrlEncoded
    Call<ResponseBody> insert(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 更新机构信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/editOrg")
    @FormUrlEncoded
    Call<ResponseBody> editOrg(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 查询认证机构
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/applylist")
    @FormUrlEncoded
    Call<ResponseBody> applylist(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 认证机构审批
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/replyOrg")
    @FormUrlEncoded
    Call<ResponseBody> replyOrg(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 机构用户注册
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/orgSignUp")
    @FormUrlEncoded
    Call<ResponseBody> orgSignUp(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 验证机构名称重复
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/orgNameCheck")
    @FormUrlEncoded
    Call<ResponseBody> orgNameCheck(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 修改机构审核信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/editOrgAuthen")
    @FormUrlEncoded
    Call<ResponseBody> editOrgAuthen(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 机构添加教师
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/addTeacher")
    @FormUrlEncoded
    Call<ResponseBody> addTeacher(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 获取待审批机构消息列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/orgMessageList")
    @FormUrlEncoded
    Call<ResponseBody> orgMessageList(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 审批机构新闻
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhumanage/web/orgInfo/replyOrgMessage")
    @FormUrlEncoded
    Call<ResponseBody> replyOrgMessage(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 根据id获取机构新闻详情
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/getMessageById")
    @FormUrlEncoded
    Call<ResponseBody> getMessageById(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 新增新闻
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/insertMessage")
    @FormUrlEncoded
    Call<ResponseBody> insertMessage(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 修改新闻
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/editMessage")
    @FormUrlEncoded
    Call<ResponseBody> editMessage(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 删除新闻
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/delMessage")
    @FormUrlEncoded
    Call<ResponseBody> delMessage(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 新闻提交审核
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/applyMessage")
    @FormUrlEncoded
    Call<ResponseBody> applyMessage(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 机构添加学生
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/addStudentToOrg")
    @FormUrlEncoded
    Call<ResponseBody> addStudentToOrg(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 推荐机构
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/recommendOrg")
    @FormUrlEncoded
    Call<ResponseBody> recommendOrg(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 机构学生列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/orgStudentList")
    @FormUrlEncoded
    Call<ResponseBody> orgStudentList(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 验证账号重复
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/orgInfo/accountCheck")
    @FormUrlEncoded
    Call<ResponseBody> accountCheck(@Field("token") String token,
                                    @FieldMap Map<String, String> map);


}