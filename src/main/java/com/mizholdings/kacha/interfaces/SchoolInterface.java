package com.mizholdings.kacha.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface SchoolInterface {
    String path = "school";
    String url = path + "/";

    /**
     * 4.1.1 学生加入班级
     *
     * @param Authorization
     * @param classId
     * @param childId
     * @return
     */
    @POST(url + "class/student/join")
    @FormUrlEncoded
    Call<ResponseBody> studentJoinClass(@Header("Authorization") String Authorization,
                                        @Field("classId") String classId,
                                        @Field("childId") String childId);

    /**
     * 4.1.2 退出班级
     *
     * @param Authorization
     * @param classId
     * @param childId
     * @return
     */
    @POST(url + "class/student/exit")
    @FormUrlEncoded
    Call<ResponseBody> studentExitClass(@Header("Authorization") String Authorization,
                                        @Field("classId") String classId,
                                        @Field("childId") String childId);

    /**
     * 4.1.3 成员列表
     *
     * @param Authorization
     * @param schoolId
     * @param classId
     * @param type
     * @return
     */
    @GET(url + "class/members")
    Call<ResponseBody> getClassMembers(@Header("Authorization") String Authorization,
                                       @Query("schoolId") String schoolId,
                                       @Query("classId") String classId,
                                       @Query("type") String type);

    /**
     * 4.1.4 超级管理员页面学生数据
     *
     * @param Authorization
     * @param classId
     * @param subjectId
     * @param startTime
     * @param endTime
     * @return
     */
    @GET(url + "class/membersForSA")
    Call<ResponseBody> getClassMembersForSA(@Header("Authorization") String Authorization,
                                            @Query("classId") String classId,
                                            @Query("subjectId") String subjectId,
                                            @Query("startTime") String startTime,
                                            @Query("endTime") String endTime);

    /**
     * 4.2.1 班级信息
     *
     * @param Authorization
     * @param classId
     * @return
     */
    @GET(url + "class/detail")
    Call<ResponseBody> getClassDetail(@Header("Authorization") String Authorization,
                                      @Query("classId") String classId);


    /**
     * 4.2.2 班级信息
     *
     * @param Authorization
     * @param schoolId
     * @param year
     * @param ownerPhone
     * @return
     */
    @GET(url + "class/detail")
    Call<ResponseBody> getClassDetail(@Header("Authorization") String Authorization,
                                      @Query("schoolId") String schoolId,
                                      @Query("year") String year,
                                      @Query("ownerPhone") String ownerPhone);

    /**
     * 4.2.3班级信息返回
     *
     * @param Authorization
     * @param schoolId
     * @return
     */
    @GET(url + "class/info")
    Call<ResponseBody> getClassInfo(@Header("Authorization") String Authorization,
                                    @Query("classId") String schoolId);


    /**
     * 4.2.4 班级列表
     *
     * @param Authorization
     * @param schoolId：     学校ID
     * @param pageSize：     分页大小
     * @param pageNum:      页码
     * @param className:    班级名称（模糊）
     * @return
     */
    @GET(url + "class/list")
    Call<ResponseBody> getClassList(@Header("Authorization") String Authorization,
                                    @Query("classId") String schoolId,
                                    @Query("pageSize") String pageSize,
                                    @Query("pageNum") String pageNum,
                                    @Query("className") String className);

    /**
     * 4.3 班级教师
     *
     * @param Authorization
     * @param name          ：string 教师姓名
     * @param phone         ： int 教师电话号码
     * @param year          ：学年
     * @return
     */
    @GET(url + "class/detail/owner")
    Call<ResponseBody> getClassDetailOwner(@Header("Authorization") String Authorization,
                                           @Query("name") String name,
                                           @Query("phone") String phone,
                                           @Query("year") String year);

    /**
     * 4.3.1教师星标收藏
     *
     * @param Authorization
     * @param uqId
     * @param type
     * @return
     */
    @GET(url + "class/teacherCollect")
    Call<ResponseBody> getClassTeacherCollect(@Header("Authorization") String Authorization,
                                              @Query("uqId") String uqId,
                                              @Query("type") String type);

    /**
     * 4.3.2 新建班级
     *
     * @param Authorization
     * @param schoolId
     * @param className
     * @param gradeId
     * @param years
     * @param adminId
     * @param des
     * @return
     */
    @POST(url + "class/manage/creat")
    @FormUrlEncoded
    Call<ResponseBody> creatClass(@Header("Authorization") String Authorization,
                                  @Field("schoolId") String schoolId,
                                  @Field("className") String className,
                                  @Field("gradeId") String gradeId,
                                  @Field("years") String years,
                                  @Field("adminId") String adminId,
                                  @Field("des") String des);

    /**
     * 4.3.3 新建班级
     *
     * @param Authorization
     * @param map           *schoolName: 学校名称
     *                      effStart: 生效时间
     *                      effEnd: 失效时间
     *                      province: 省份
     *                      city: 城市
     *                      area: 区域
     *                      address: 学校地址
     *                      masterName: 管理员姓名
     *                      phone: 管理员手机
     *                      des: 学校备注
     *                      phaseId: 学段ID 1-小学 2-初中 3-高中 4-全学段
     *                      upperLimit：累积使用人上限
     *                      schoolType：0-学校(默认)  1-机构
     * @return
     */
    // TODO: 2019/10/29  @POST(url + "class/manage/creat/excel")
    @POST(url + "manage/create")
    @FormUrlEncoded
    Call<ResponseBody> creatSchool(@Header("Authorization") String Authorization,
                                   @FieldMap Map<String, String> map);

    @POST(url + "manage/update")
    @FormUrlEncoded
    Call<ResponseBody> updateSchool(@Header("Authorization") String Authorization,
                                    @FieldMap Map<String, String> map);

    @POST(url + "manage/delete")
    @FormUrlEncoded
    Call<ResponseBody> deleteSchool(@Header("Authorization") String Authorization,
                                    @Field("schoolId") String schoolId);


}
