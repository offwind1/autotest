package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface GradeInterface {

    
/**
 * 年级列表，分页查询
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/grade/list")
@FormUrlEncoded
Call<ResponseBody> list(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查询所有年级
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/grade/allList")
@FormUrlEncoded
Call<ResponseBody> allList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加班级
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/grade/addClass")
@FormUrlEncoded
Call<ResponseBody> addClass(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 班级列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/grade/classList")
@FormUrlEncoded
Call<ResponseBody> classList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 编辑班级
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/grade/editClass")
@FormUrlEncoded
Call<ResponseBody> editClass(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 删除班级
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/grade/delClass")
@FormUrlEncoded
Call<ResponseBody> delClass(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 查看班级中的学生
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/grade/userByStuId")
@FormUrlEncoded
Call<ResponseBody> userByStuId(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 从年级中删除学生
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/grade/delStudent")
@FormUrlEncoded
Call<ResponseBody> delStudent(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}