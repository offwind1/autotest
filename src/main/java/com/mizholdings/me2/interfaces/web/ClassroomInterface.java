package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface ClassroomInterface {

    
/**
 * 课节绑定知识点
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/bangdingKnowledge")
@FormUrlEncoded
Call<ResponseBody> bangdingKnowledge(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据课程ID，查询课节信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/listByLessonId")
@FormUrlEncoded
Call<ResponseBody> listByLessonId(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 新增课节
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/add")
@FormUrlEncoded
Call<ResponseBody> add(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据课节ID，获得课节信息
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/getClassroomById")
@FormUrlEncoded
Call<ResponseBody> getClassroomById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 编辑课节
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/edit")
@FormUrlEncoded
Call<ResponseBody> edit(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 申请发布
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/apply")
@FormUrlEncoded
Call<ResponseBody> apply(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 审批发布的申请
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/reply")
@FormUrlEncoded
Call<ResponseBody> reply(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 根据课节ID删除记录
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/delClassroomById")
@FormUrlEncoded
Call<ResponseBody> delClassroomById(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 课节申请列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/applylist")
@FormUrlEncoded
Call<ResponseBody> applylist(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查看课堂附件
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/classroomOptions")
@FormUrlEncoded
Call<ResponseBody> classroomOptions(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 直播课管理
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/onlineList")
@FormUrlEncoded
Call<ResponseBody> onlineList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 新增课堂视频
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/addClassVideo")
@FormUrlEncoded
Call<ResponseBody> addClassVideo(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 修改课堂视频
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/editClassVideo")
@FormUrlEncoded
Call<ResponseBody> editClassVideo(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 删除课堂视频
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/deleteClassVideo")
@FormUrlEncoded
Call<ResponseBody> deleteClassVideo(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 直播课管理（V2）
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/classroom/onlineListV2")
@FormUrlEncoded
Call<ResponseBody> onlineListV2(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}