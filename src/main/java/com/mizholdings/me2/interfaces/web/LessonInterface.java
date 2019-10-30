package com.mizholdings.me2.interfaces.web;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LessonInterface {

    @POST("mizhu/web/lesson/add")
    @FormUrlEncoded
    Call<ResponseBody> add(
            @Field("token") String token,
            @Field("gradeIds") String gradeIds,
            @Field("gradeNames") String gradeNames,

            @Field("lessonTypeId") int lessonTypeId,
            @Field("lessonName") String lessonName,
            @Field("lessonTerm") int lessonTerm,
            @Field("lessonTag") String lessonTag,
            @Field("lessRemark") String lessRemark,

            @Field("tryLook") int tryLook,
            @Field("apply") int apply,
            @Field("free") int free,

            @Field("faceImg") String faceImg,
            @Field("startTime") String startTime,
            @Field("endTime") String endTime,

            @Field("classroomCount") int classroomCount,
            @Field("classroomPrice") double classroomPrice,
            @Field("classTime") int classTime,
            @Field("classInfo") String classInfo,
            @Field("studentCount") int studentCount,

            @Field("price") int price,
            @Field("discount") double discount,
            @Field("buyType") int buyType,
            @Field("custRelease") int custRelease
    );


    @POST("mizhu/web/lessonType/list")
    @FormUrlEncoded
    Call<ResponseBody> lessonType_list(@Field("token") String token);


}
