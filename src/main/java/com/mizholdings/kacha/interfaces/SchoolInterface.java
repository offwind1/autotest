package com.mizholdings.kacha.interfaces;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface SchoolInterface {

    /**
     * 4.1.1 学生加入班级
     *
     * @param Authorization
     * @param map{          classId ：int 班级id
     *                      childId :子女id 不填时 自己添加进班级    }
     * @return
     */
    @POST("school/class/student/join")
    @FormUrlEncoded
    Call<ResponseBody> classStudentJoin(@Header("Authorization") String Authorization,
                                        @FieldMap Map<String, String> map);

    /**
     * 4.1.2 退出班级
     *
     * @param Authorization
     * @param map           {	classId ：int 班级id
     *                      childId :子女id 不填时 自己添加进班级}
     * @return
     */
    @POST("school/class/student/exit")
    @FormUrlEncoded
    Call<ResponseBody> classStudentExit(@Header("Authorization") String Authorization,
                                        @FieldMap Map<String, String> map);

    /**
     * 4.1.3 成员列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/class/members")
    Call<ResponseBody> classMembers(@Header("Authorization") String Authorization,
                                    @QueryMap Map<String, String> map);

    /**
     * 4.1.4 超级管理员页面学生数据
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/class/membersForSA")
    Call<ResponseBody> classMembersForSA(@Header("Authorization") String Authorization,
                                         @QueryMap Map<String, String> map);

    /**
     * 4.2.1 班级信息
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/class/detail")
    Call<ResponseBody> classDetail(@Header("Authorization") String Authorization,
                                   @QueryMap Map<String, String> map);

    /**
     * 4.2.3班级信息返回
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/class/info")
    Call<ResponseBody> classInfo(@Header("Authorization") String Authorization,
                                 @QueryMap Map<String, String> map);

    /**
     * 4.2.4 班级列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/class/list")
    Call<ResponseBody> classList(@Header("Authorization") String Authorization,
                                 @QueryMap Map<String, String> map);

    /**
     * 4.3 班级教师
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/class/detail/owner")
    Call<ResponseBody> classDetailOwner(@Header("Authorization") String Authorization,
                                        @QueryMap Map<String, String> map);

    /**
     * 4.3.1教师星标收藏
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/class/teacherCollect")
    @FormUrlEncoded
    Call<ResponseBody> classTeacherCollect(@Header("Authorization") String Authorization,
                                           @FieldMap Map<String, String> map);

    /**
     * 4.3.2 新建班级
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/class/manage/creat")
    @FormUrlEncoded
    Call<ResponseBody> classManageCreat(@Header("Authorization") String Authorization,
                                        @FieldMap Map<String, String> map);

    /**
     * 4.3.3 新建班级(excel
     *
     * @param Authorization
     * @param partList
     * @return
     */
    @POST("school/class/manage/creat/excel")
    @Multipart
    Call<ResponseBody> creatManageCreatExcel(@Header("Authorization") String Authorization,
                                             @Part List<MultipartBody.Part> partList);

    /**
     * 4.3.4 更新班级
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/class/manage/update")
    @FormUrlEncoded
    Call<ResponseBody> classManageUpdate(@Header("Authorization") String Authorization,
                                         @FieldMap Map<String, String> map);


    /**
     * 4.3.5 删除班级
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/class/manage/delete")
    @FormUrlEncoded
    Call<ResponseBody> classManageDelete(@Header("Authorization") String Authorization,
                                         @FieldMap Map<String, String> map);


    /**
     * 4.3.6 一键升级班级
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/class/manage/promotion")
    @FormUrlEncoded
    Call<ResponseBody> classManagePromotion(@Header("Authorization") String Authorization,
                                            @FieldMap Map<String, String> map);

    /**
     * 4.3.7 管理学生加班
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/class/manage/user/join")
    @FormUrlEncoded
    Call<ResponseBody> classManageUserJoin(@Header("Authorization") String Authorization,
                                           @FieldMap Map<String, String> map);

    /**
     * 4.3.8 管理学生退班
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/class/manage/user/exit")
    @FormUrlEncoded
    Call<ResponseBody> classManageUserExit(@Header("Authorization") String Authorization,
                                           @FieldMap Map<String, String> map);

    /**
     * 4.3.9 管理学生是否推送一错一练
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/class/manage/user/pushMarker")
    @FormUrlEncoded
    Call<ResponseBody> classManageUserPushmarker(@Header("Authorization") String Authorization,
                                                 @FieldMap Map<String, String> map);


    /**
     * 4.4.1 学校可用学年
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/info/years")
    Call<ResponseBody> schoolInfoYears(@Header("Authorization") String Authorization,
                                       @QueryMap Map<String, String> map);


    /**
     * 4.5.1 学校学科列表
     *
     * @param Authorization
     * @return
     */
    @GET("school/subject/school")
    Call<ResponseBody> schoolSubjectSchool(@Header("Authorization") String Authorization);


    /**
     * 4.5.2 班级学科列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/subject/class")
    Call<ResponseBody> schoolSubjectClass(@Header("Authorization") String Authorization,
                                          @QueryMap Map<String, String> map);


    /**
     * 4.5.3 用户学科列表
     *
     * @param Authorization
     * @return
     */
    @GET("school/subject/user")
    Call<ResponseBody> schoolSubjectUser(@Header("Authorization") String Authorization);

    /**
     * 4.5.4任职为班主任的班级和学科列表（班主任和校管）
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/class/user/teachingClasses")
    Call<ResponseBody> schoolClassUserTeachingclasses(@Header("Authorization") String Authorization,
                                                      @QueryMap Map<String, String> map);

    /**
     * 4.6.1 学校列表返回
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/info/schoollist")
    Call<ResponseBody> schoolInfoSchoollist(@Header("Authorization") String Authorization,
                                            @QueryMap Map<String, String> map);

    /**
     * 4.6.2 学校信息返回
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/info/detail")
    Call<ResponseBody> schoolInfoDetail(@Header("Authorization") String Authorization,
                                        @QueryMap Map<String, String> map);

    /**
     * 4.7.1 新建学校
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/manage/create")
    @FormUrlEncoded
    Call<ResponseBody> schoolManageCreate(@Header("Authorization") String Authorization,
                                          @FieldMap Map<String, String> map);

    /**
     * 4.7.2 更新学校
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/manage/update")
    @FormUrlEncoded
    Call<ResponseBody> schoolManageUpdate(@Header("Authorization") String Authorization,
                                          @FieldMap Map<String, String> map);

    /**
     * 4.7.3 删除学校
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/manage/delete")
    @FormUrlEncoded
    Call<ResponseBody> schoolManageDelete(@Header("Authorization") String Authorization,
                                          @FieldMap Map<String, String> map);

    /**
     * 4.8.1 用户班级列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/users/class")
    Call<ResponseBody> schoolUsersClass(@Header("Authorization") String Authorization,
                                        @QueryMap Map<String, String> map);

    /**
     * 4.8.2 用户学校列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/users/schools")
    Call<ResponseBody> schoolUsersSchools(@Header("Authorization") String Authorization,
                                          @QueryMap Map<String, String> map);

    /**
     * 4.8.3用户登录返回个人信息
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/users/pageUser")
    Call<ResponseBody> schoolUsersPageuser(@Header("Authorization") String Authorization,
                                           @QueryMap Map<String, String> map);

    /**
     * 4.8.4 新建用户
     *
     * @param Authorization
     * @param map
     * @return
     */
    @POST("school/users/creat")
    @FormUrlEncoded
    Call<ResponseBody> schoolUsersCreat(@Header("Authorization") String Authorization,
                                        @FieldMap Map<String, String> map);

    /**
     * 4.8.5 学校用户信息
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/users/mine/schools")
    Call<ResponseBody> schoolUsersMineSchools(@Header("Authorization") String Authorization,
                                              @QueryMap Map<String, String> map);

    /**
     * 4.9.1根据学校ID获取年级列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/grade/list")
    Call<ResponseBody> schoolGradeList(@Header("Authorization") String Authorization,
                                       @QueryMap Map<String, String> map);

    /**
     * 4.9.2根据年级获取班级列表
     *
     * @param Authorization
     * @param map
     * @return
     */
    @GET("school/grade/class")
    Call<ResponseBody> schoolGradeClass(@Header("Authorization") String Authorization,
                                        @QueryMap Map<String, String> map);

}
