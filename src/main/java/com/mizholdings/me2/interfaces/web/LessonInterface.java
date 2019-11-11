package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface LessonInterface {


    /**
     * 课程绑定知识点
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/bangdingKnowledge")
    @FormUrlEncoded
    Call<ResponseBody> bangdingKnowledge(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

    /**
     * 课程分页列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 课程新增
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/add")
    @FormUrlEncoded
    Call<ResponseBody> add(@Field("token") String token,
                           @FieldMap Map<String, String> map);

    /**
     * 根据ID获得课程信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/getLessonInfoById")
    @FormUrlEncoded
    Call<ResponseBody> getLessonInfoById(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

    /**
     * 根据课程ID拿到评论（一级）
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/getLessonScoreById")
    @FormUrlEncoded
    Call<ResponseBody> getLessonScoreById(@Field("token") String token,
                                          @FieldMap Map<String, String> map);

    /**
     * 编辑课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/edit")
    @FormUrlEncoded
    Call<ResponseBody> edit(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 根据课程ID，删除课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/delLessonInfoById")
    @FormUrlEncoded
    Call<ResponseBody> delLessonInfoById(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

    /**
     * 课程审批
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web//lesson/lessonReply")
    @FormUrlEncoded
    Call<ResponseBody> lessonReply(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 老师回复评论
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/teacherScore")
    @FormUrlEncoded
    Call<ResponseBody> teacherScore(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 老师删除评论
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/delScore")
    @FormUrlEncoded
    Call<ResponseBody> delScore(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 根据课程id拿到课堂视频
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/getVideo")
    @FormUrlEncoded
    Call<ResponseBody> getVideo(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 下架课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/banLesson")
    @FormUrlEncoded
    Call<ResponseBody> banLesson(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 冻结课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/freezeLesson")
    @FormUrlEncoded
    Call<ResponseBody> freezeLesson(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 课程提交审批
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/apply")
    @FormUrlEncoded
    Call<ResponseBody> apply(@Field("token") String token,
                             @FieldMap Map<String, String> map);

    /**
     * 推荐课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/recommendLesson")
    @FormUrlEncoded
    Call<ResponseBody> recommendLesson(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 课程评论列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/scoreList")
    @FormUrlEncoded
    Call<ResponseBody> scoreList(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 审核评论
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/replyScore")
    @FormUrlEncoded
    Call<ResponseBody> replyScore(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 关闭课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/lessonClose")
    @FormUrlEncoded
    Call<ResponseBody> lessonClose(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 老师添加学生
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/addTeacherStudent")
    @FormUrlEncoded
    Call<ResponseBody> addTeacherStudent(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

    /**
     * 添加cc课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/addCCLesson")
    @FormUrlEncoded
    Call<ResponseBody> addCCLesson(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 我购买的课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/myLesson")
    @FormUrlEncoded
    Call<ResponseBody> myLesson(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 新增视频回放记录
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/setVideoRecord")
    @FormUrlEncoded
    Call<ResponseBody> setVideoRecord(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 根据视频id查询播放量
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/getTotalPlays")
    @FormUrlEncoded
    Call<ResponseBody> getTotalPlays(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 上传导入学生1
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/uploadFile")
    @FormUrlEncoded
    Call<ResponseBody> uploadFile(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 加入班级，根据导入文件
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/joinClassByFile")
    @FormUrlEncoded
    Call<ResponseBody> joinClassByFile(@Field("token") String token,
                                       @FieldMap Map<String, String> map);


    /**
     * 根据班级ID添加学生
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web//lesson/studentByClassId")
    @FormUrlEncoded
    Call<ResponseBody> studentByClassId(@Field("token") String token,
                                        @FieldMap Map<String, String> map);

    /**
     * 返回课程中的班级
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/web/lesson/groupByClass")
    @FormUrlEncoded
    Call<ResponseBody> groupByClass(@Field("token") String token,
                                    @FieldMap Map<String, String> map);


    @POST("mizhu/web/lesson/userListByAccount")
    @FormUrlEncoded
    Call<ResponseBody> userListByAccount(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

    @POST("mizhu/web/lesson/joinClassByUserId")
    @FormUrlEncoded
    Call<ResponseBody> joinClassByUserId(@Field("token") String token,
                                         @FieldMap Map<String, String> map);

}
