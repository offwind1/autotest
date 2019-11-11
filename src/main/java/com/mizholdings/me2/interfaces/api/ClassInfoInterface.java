package com.mizholdings.me2.interfaces.api;

import io.qameta.allure.Step;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface ClassInfoInterface {

    /**
     * 获得课堂CODE
     *
     * @param token
     * @return
     */
    @POST("mizhu/api/classInfo/getCode")
    @FormUrlEncoded
    Call<ResponseBody> getCode(@Field("token") String token);


    /**
     * 根据课程ID获得课堂列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/listByLessonId")
    @FormUrlEncoded
    Call<ResponseBody> listByLessonId(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 拿到课堂附加资源列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/optionList")
    @FormUrlEncoded
    Call<ResponseBody> optionList(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 申请开课，添加视频表信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/classroomStart")
    @FormUrlEncoded
    Call<ResponseBody> classroomStart(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 课堂结束，保存信息
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/classroomEnd")
    @FormUrlEncoded
    Call<ResponseBody> classroomEnd(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 用户加入课堂
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/classroomAddUser")
    @FormUrlEncoded
    Call<ResponseBody> classroomAddUser(@Field("token") String token,
                                        @FieldMap Map<String, String> map);

    /**
     * 用户根据课堂CODE加入课堂
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/classroomCodeAddUser")
    @FormUrlEncoded
    Call<ResponseBody> classroomCodeAddUser(@Field("token") String token,
                                            @FieldMap Map<String, String> map);

    /**
     * 用户退出课堂
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/classroomRemoveUser")
    @FormUrlEncoded
    Call<ResponseBody> classroomRemoveUser(@Field("token") String token,
                                           @FieldMap Map<String, String> map);

    /**
     * 获得课堂CODE
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/getCode")
    @FormUrlEncoded
    Call<ResponseBody> getCode(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 快速开课
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/quickStart")
    @FormUrlEncoded
    Call<ResponseBody> quickStart(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 群组禁言
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/muteTlistAll")
    @FormUrlEncoded
    Call<ResponseBody> muteTlistAll(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 回填课堂视频URL
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/classVideo")
    @FormUrlEncoded
    Call<ResponseBody> classVideo(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 拿到课堂的课件
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/getCourse")
    @FormUrlEncoded
    Call<ResponseBody> getCourse(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 获取7牛直播推流URL
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/pushUrl")
    @FormUrlEncoded
    Call<ResponseBody> pushUrl(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 获取7牛直播观看URL
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/pullUrl")
    @FormUrlEncoded
    Call<ResponseBody> pullUrl(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 课堂中用户举手
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/handsUp")
    @FormUrlEncoded
    Call<ResponseBody> handsUp(@Field("token") String token,
                               @FieldMap Map<String, String> map);

    /**
     * 教师同意用户举手
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/agreeHandsUp")
    @FormUrlEncoded
    Call<ResponseBody> agreeHandsUp(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 老师点赞学生答案
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/laudStudent")
    @FormUrlEncoded
    Call<ResponseBody> laudStudent(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 7牛连麦——创建连麦房间
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/qiniuCreateRoom")
    @FormUrlEncoded
    Call<ResponseBody> qiniuCreateRoom(@Field("token") String token,
                                       @FieldMap Map<String, String> map);

    /**
     * 7牛连麦——获得鉴权
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/qiniuRoomToken")
    @FormUrlEncoded
    Call<ResponseBody> qiniuRoomToken(@Field("token") String token,
                                      @FieldMap Map<String, String> map);

    /**
     * 7牛连麦——连麦房间观看地址
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/qiniuRoomUrl")
    @FormUrlEncoded
    Call<ResponseBody> qiniuRoomUrl(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 获得七牛连麦的APP列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/rtcAppList")
    @FormUrlEncoded
    Call<ResponseBody> rtcAppList(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 课堂结束，保存信息(白板服务器调用)
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/whiteHouseEnd")
    @FormUrlEncoded
    Call<ResponseBody> whiteHouseEnd(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 查询课堂类型和资料
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/classroomInfo")
    @FormUrlEncoded
    Call<ResponseBody> classroomInfo(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 根据课堂CODE查询正在开课的
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/lessonByCode")
    @FormUrlEncoded
    Call<ResponseBody> lessonByCode(@Field("token") String token,
                                    @FieldMap Map<String, String> map);

    /**
     * 查询是否存在正在开课的课堂
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/notClose")
    @FormUrlEncoded
    Call<ResponseBody> notClose(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 课堂重连
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/reconnect")
    @FormUrlEncoded
    Call<ResponseBody> reconnect(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 课堂进行时，截取课堂封面
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/videoFace")
    @FormUrlEncoded
    Call<ResponseBody> videoFace(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * PC端调用答题接口
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/pcAnswer")
    @FormUrlEncoded
    Call<ResponseBody> pcAnswer(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 课堂时间
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/timeSwitch")
    @FormUrlEncoded
    Call<ResponseBody> timeSwitch(@Field("token") String token,
                                  @FieldMap Map<String, String> map);

    /**
     * 获取老师当天要开得课堂列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/listByToday")
    @FormUrlEncoded
    Call<ResponseBody> listByToday(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 获取今天课堂列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/roomToday")
    @FormUrlEncoded
    Call<ResponseBody> roomToday(@Field("token") String token,
                                 @FieldMap Map<String, String> map);

    /**
     * 管理员系统调用关闭课堂
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/adminClassEnd")
    @FormUrlEncoded
    Call<ResponseBody> adminClassEnd(@Field("token") String token,
                                     @FieldMap Map<String, String> map);

    /**
     * 课堂中老师发起抢答
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/answerfirst")
    @FormUrlEncoded
    Call<ResponseBody> answerfirst(@Field("token") String token,
                                   @FieldMap Map<String, String> map);

    /**
     * 校正用户考勤记录
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/revise")
    @FormUrlEncoded
    Call<ResponseBody> revise(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * web端白板url
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/weburl")
    @FormUrlEncoded
    Call<ResponseBody> weburl(@Field("token") String token,
                              @FieldMap Map<String, String> map);

    /**
     * 未来两周的待上课节
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/weekRoom")
    @FormUrlEncoded
    Call<ResponseBody> weekRoom(@Field("token") String token,
                                @FieldMap Map<String, String> map);

    /**
     * 获取课堂用户列表
     *
     * @param token
     * @param map
     * @return
     */
    @POST("mizhu/api/classInfo/roomUser")
    @FormUrlEncoded
    Call<ResponseBody> roomUser(@Field("token") String token,
                                @FieldMap Map<String, String> map);


}
