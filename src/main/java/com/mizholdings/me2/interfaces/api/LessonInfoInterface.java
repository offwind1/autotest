package com.mizholdings.me2.interfaces.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface LessonInfoInterface {


    /**
     * 相关推荐
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/relatedList")
    @FormUrlEncoded
    Call<ResponseBody> relatedList(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 选课中心筛选条件
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/screen")
    @FormUrlEncoded
    Call<ResponseBody> screen(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 课程列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/list")
    @FormUrlEncoded
    Call<ResponseBody> list(@Field("token") String token,
                            @FieldMap Map<String, String> map);

    /**
     * 课程详情
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/lessonInfo")
    @FormUrlEncoded
    Call<ResponseBody> lessonInfo(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 课程评论
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/score")
    @FormUrlEncoded
    Call<ResponseBody> score(@Field("token") String token,
                             @FieldMap Map<String, String> map);

    /**
     * 查询用户课程列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api//lessonInfo/usrLesson")
    @FormUrlEncoded
    Call<ResponseBody> usrLesson(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 我要听课，我要上课的日历列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/studyLesson")
    @FormUrlEncoded
    Call<ResponseBody> studyLesson(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 点赞课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/likedLesson")
    @FormUrlEncoded
    Call<ResponseBody> likedLesson(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 取消点赞
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/rmlikedLesson")
    @FormUrlEncoded
    Call<ResponseBody> rmlikedLesson(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 收藏课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/keepLesson")
    @FormUrlEncoded
    Call<ResponseBody> keepLesson(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 取消收藏
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/rmkeepLesson")
    @FormUrlEncoded
    Call<ResponseBody> rmkeepLesson(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 查询课程评论
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/lessonScore")
    @FormUrlEncoded
    Call<ResponseBody> lessonScore(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 我的课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/myLesson")
    @FormUrlEncoded
    Call<ResponseBody> myLesson(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 获取退课款项
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/retreat")
    @FormUrlEncoded
    Call<ResponseBody> retreat(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 退课申请
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/refundApply")
    @FormUrlEncoded
    Call<ResponseBody> refundApply(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 查询退课状态
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/refundStatus")
    @FormUrlEncoded
    Call<ResponseBody> refundStatus(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 我创建的课程
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/myCreateLesson")
    @FormUrlEncoded
    Call<ResponseBody> myCreateLesson(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 删除私课
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/delLesson")
    @FormUrlEncoded
    Call<ResponseBody> delLesson(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 新增视频回放记录
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/setVideoRecord")
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
    @POST("mizhu/api/lessonInfo/getTotalPlays")
    @FormUrlEncoded
    Call<ResponseBody> getTotalPlays(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 免费课程列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/freeList")
    @FormUrlEncoded
    Call<ResponseBody> freeList(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 我的课程(我购买的)PC
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/myLessonPC")
    @FormUrlEncoded
    Call<ResponseBody> myLessonPC(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 更新视频回放，观看时长
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/updateVideoTime")
    @FormUrlEncoded
    Call<ResponseBody> updateVideoTime(@Field("token") String token,
                                       @FieldMap Map<String, String> map);
    /**
     * 获取视频回放记录
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/lessonInfo/getVideoRecord")
    @FormUrlEncoded
    Call<ResponseBody> getVideoRecord(@Field("token") String token,
                                       @FieldMap Map<String, String> map);


}
