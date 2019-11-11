package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface RefundInterface {

    
/**
 * 退课记录
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/refund/refundList")
@FormUrlEncoded
Call<ResponseBody> refundList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 退课老师审批
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/refund/teacherApply")
@FormUrlEncoded
Call<ResponseBody> teacherApply(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 退款流程查询
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/refund/refundInfo")
@FormUrlEncoded
Call<ResponseBody> refundInfo(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 退款金额查询
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/refund/refundMoney")
@FormUrlEncoded
Call<ResponseBody> refundMoney(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 老师主动退款
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/refund/teahcerDelStu")
@FormUrlEncoded
Call<ResponseBody> teahcerDelStu(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 管理员审批退课
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/refund/managerApply")
@FormUrlEncoded
Call<ResponseBody> managerApply(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}