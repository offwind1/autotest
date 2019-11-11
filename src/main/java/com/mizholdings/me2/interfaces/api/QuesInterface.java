package com.mizholdings.me2.interfaces.api;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface QuesInterface {

    /**
     * 题目类型查询
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/ques/getQuestionType")
    @FormUrlEncoded
    Call<ResponseBody> getQuestionType(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 题库查询
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/ques/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 根据ID查询题目
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/ques/getQuestionById")
    @FormUrlEncoded
    Call<ResponseBody> getQuestionById(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 学生答题
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/ques/studentAnswer")
    @FormUrlEncoded
    Call<ResponseBody> studentAnswer(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 根据题目ID，获取用户答案列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/ques/questionAnswerList")
    @FormUrlEncoded
    Call<ResponseBody> questionAnswerList(@Field("token") String token,
                                          @FieldMap Map<String, String> map);

    /**
     * 老师评语和批改
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/ques/teacherComment")
    @FormUrlEncoded
    Call<ResponseBody> teacherComment(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 课堂答题统计
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/ques/questionAnswerStatistics")
    @FormUrlEncoded
    Call<ResponseBody> questionAnswerStatistics(@Field("token") String token,
                                                @FieldMap Map<String, String> map);

    /**
     * 根据题目ID集合拿到题目
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/ques/getQuestionByIds")
    @FormUrlEncoded
    Call<ResponseBody> getQuestionByIds(@Field("token") String token,
                                        @FieldMap Map<String, String> map);

    /**
     * 老师在课堂中添加试题使用，为了统计本堂课一共有多少试题
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/ques/joinQuestions")
    @FormUrlEncoded
    Call<ResponseBody> joinQuestions(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

}
