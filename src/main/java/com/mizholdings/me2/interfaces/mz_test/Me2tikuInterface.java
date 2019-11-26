package com.mizholdings.me2.interfaces.mz_test;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface Me2tikuInterface {


    /**
     * 题库章节查询
     *
     * @param map
     * @return
     */
    @POST("me2tiku/web/qb/queryChaptersTree")
    @FormUrlEncoded
    Call<ResponseBody> queryChaptersTree(@FieldMap Map<String, String> map);

    /**
     * 题库知识点查询
     *
     * @param map
     * @return
     */
    @POST("me2tiku/web/qb/queryKnowledgeList")
    @FormUrlEncoded
    Call<ResponseBody> queryKnowledgeList(@FieldMap Map<String, String> map);


}
