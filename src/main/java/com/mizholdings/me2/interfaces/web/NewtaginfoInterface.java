package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface NewtaginfoInterface {

    
/**
 * 获取标签列表
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/newTagInfo/tagList")
@FormUrlEncoded
Call<ResponseBody> tagList(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 添加标签
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/newTagInfo/addTag")
@FormUrlEncoded
Call<ResponseBody> addTag(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 删除标签
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/newTagInfo/deleteTag")
@FormUrlEncoded
Call<ResponseBody> deleteTag(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    
/**
 * 修改标签
 *
 * @param token
 * @param map
 * @return
 */
@POST("mizhu/web/newTagInfo/editTag")
@FormUrlEncoded
Call<ResponseBody> editTag(@Field("token") String token,
                                    @FieldMap Map<String, String> map);
                                    

}