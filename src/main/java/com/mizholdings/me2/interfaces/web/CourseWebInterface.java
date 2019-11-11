package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface CourseWebInterface {

    
/**
 * 资源库列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/list")
@FormUrlEncoded
Call<ResponseBody> list(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 初始化新增资源
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/initCourse")
@FormUrlEncoded
Call<ResponseBody> initCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据ID，获得资源详情
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/getCourseById")
@FormUrlEncoded
Call<ResponseBody> getCourseById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据ID获得资源子集
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/getChildListById")
@FormUrlEncoded
Call<ResponseBody> getChildListById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 设置资源信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/editCourseware")
@FormUrlEncoded
Call<ResponseBody> editCourseware(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 删除子资源中一个
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/delChild")
@FormUrlEncoded
Call<ResponseBody> delChild(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 自己创建的资源列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/mylist")
@FormUrlEncoded
Call<ResponseBody> mylist(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 用户购买资源列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/buylist")
@FormUrlEncoded
Call<ResponseBody> buylist(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加资源_新增添加
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/addNewCourse")
@FormUrlEncoded
Call<ResponseBody> addNewCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加资源_从资源库选择添加
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/addOldCourse")
@FormUrlEncoded
Call<ResponseBody> addOldCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据ID获取详情，自己创建的资源（有已审批的、未审批的）
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/getMyCosById")
@FormUrlEncoded
Call<ResponseBody> getMyCosById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据ID获得资源子集,自己创建的资源（有已审批的、未审批的）
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/getMyChildListById")
@FormUrlEncoded
Call<ResponseBody> getMyChildListById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据ID获取详情，已购买的
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/getBuyCosById")
@FormUrlEncoded
Call<ResponseBody> getBuyCosById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据ID获得资源子集,已购买的
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/getBuyChildListById")
@FormUrlEncoded
Call<ResponseBody> getBuyChildListById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 资源送审
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/applyCourse")
@FormUrlEncoded
Call<ResponseBody> applyCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 审批资源列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/applylist")
@FormUrlEncoded
Call<ResponseBody> applylist(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 审批资源
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/replyCourse")
@FormUrlEncoded
Call<ResponseBody> replyCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 删除自己的资源(必须是未送审，或者已经审批过的)
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/delMyCourse")
@FormUrlEncoded
Call<ResponseBody> delMyCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 下架资源
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/shutdownCourse")
@FormUrlEncoded
Call<ResponseBody> shutdownCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 购买资源
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/buyCourse")
@FormUrlEncoded
Call<ResponseBody> buyCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据课程id查询订单
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/getConsumByCourseId")
@FormUrlEncoded
Call<ResponseBody> getConsumByCourseId(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 新增ppt
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/uploadPpt")
@FormUrlEncoded
Call<ResponseBody> uploadPpt(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 下架资源
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/banCourse")
@FormUrlEncoded
Call<ResponseBody> banCourse(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 推荐资源
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/recommendCourseware")
@FormUrlEncoded
Call<ResponseBody> recommendCourseware(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 上传文件
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/uploadFile")
@FormUrlEncoded
Call<ResponseBody> uploadFile(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 资源转换状态回调地址 
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/courseCallback")
@FormUrlEncoded
Call<ResponseBody> courseCallback(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据ID删除子集资源
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/deleteMyChildListById")
@FormUrlEncoded
Call<ResponseBody> deleteMyChildListById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 向教师推荐资源
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/course/courseForTeacher")
@FormUrlEncoded
Call<ResponseBody> courseForTeacher(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}