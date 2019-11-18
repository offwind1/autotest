package com.mizholdings.kacha.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.interfaces.SchoolInterface;
import com.mizholdings.kacha.playload.PLSchool;
import com.mizholdings.kacha.user.KCUserBase;
import com.mizholdings.util.Funcs;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import io.qameta.allure.Step;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.util.List;
import java.util.Map;

public class MODSchool extends MODBase<MODSchool> {
    public static SchoolInterface schoolInterface = Requests.getService(SchoolInterface.class);

    public MODSchool(KCUserBase executor) {
        super(executor);
        this.interfaced = schoolInterface;
    }


    /**
     * 4.1.1 学生加入班级
     *
     * @return
     */
    @Step("学生加入班级")
    public JSONObject classStudentJoin(String classId, String childId) {
        Parameter parameter = Parameter.creat()
                .add("classId", classId)
                .add("childId", childId);
        return exec("classStudentJoin", parameter);
    }

    /**
     * 4.1.2 退出班级
     *
     * @return
     */
    @Step("退出班级")
    public JSONObject classStudentExit(String classId, String childId) {
        return exec("classStudentExit", Parameter.creat()
                .add("classId", classId)
                .add("childId", childId));
    }

    /**
     * 4.1.3 成员列表
     *
     * @return
     */
    @Step("成员列表")
    public JSONObject classMembers(String schoolId, String classId, String type) {
        return exec("classMembers", Parameter.creat()
                .add("schoolId", schoolId)
                .add("classId", classId)
                .add("type", type).add("page", "1").add("pageSize", "9999"));
    }

    @Step("学生成员列表")
    public JSONObject classMembers(String schoolId, String classId) {
        return classMembers(schoolId, classId, "3");
    }

    @Step("学校成员列表")
    public JSONObject classMembers(String schoolId) {
        return exec("classMembers", Parameter.creat()
                .add("schoolId", schoolId)
                .add("type", "1").add("page", "1").add("pageSize", "9999"));
    }


    /**
     * 4.1.4 超级管理员页面学生数据
     *
     * @param schoolModel
     * @return
     */
    @Step("超级管理员页面学生数据")
    public JSONObject classMembersForSA(PLSchool schoolModel) {
        return exec("classMembersForSA", schoolModel);
    }

    /**
     * 4.2.1 班级信息
     *
     * @param schoolModel
     * @return
     */
    @Step("班级信息")
    public JSONObject classDetail(Parameter schoolModel) {
        return exec("classDetail", schoolModel);
    }

    /**
     * 4.2.3班级信息返回
     *
     * @param schoolModel
     * @return
     */
    @Step("班级信息返回")
    public JSONObject classInfo(PLSchool schoolModel) {
        return exec("classInfo", schoolModel);
    }

    /**
     * 4.2.4 班级列表
     *
     * @param schoolModel
     * @return
     */
    @Step("班级列表")
    public JSONObject classList(PLSchool schoolModel) {
        return exec("classList", schoolModel);
    }

    /**
     * 4.3 班级教师
     *
     * @param schoolModel
     * @return
     */
    @Step("班级教师")
    public JSONObject classDetailOwner(PLSchool schoolModel) {
        return exec("classDetailOwner", schoolModel);
    }

    /**
     * 4.3.1教师星标收藏
     *
     * @param schoolModel
     * @return
     */
    @Step("教师星标收藏")
    public JSONObject classTeacherCollect(PLSchool schoolModel) {
        return exec("classTeacherCollect", schoolModel);
    }

    /**
     * 4.3.2 新建班级
     *
     * @return
     */
    @Step("新建班级")
    public JSONObject classManageCreat(String schoolId, String className,
                                       String gradeId, String years,
                                       String adminId, String des) {
        return exec("classManageCreat", Parameter.creat().add("schoolId", schoolId)
                .add("className", className).add("gradeId", gradeId).add("years", years)
                .add("adminId", adminId).add("des", des));
    }

    public JSONObject classManageCreat(String schoolId, String className) {
        return exec("classManageCreat", Parameter.creat().add("schoolId", schoolId)
                .add("className", className).add("gradeId", "9").add("years", "2019"));
    }

    public JSONObject classManageCreat(String schoolId, String className, String gradeId) {
        return exec("classManageCreat", Parameter.creat().add("schoolId", schoolId)
                .add("className", className).add("gradeId", gradeId).add("years", "2019"));
    }

    /**
     * 4.3.3 新建班级
     *
     * @param schoolModel
     * @return
     */
    @Step("新建班级")
    public JSONObject creatManageCreatExcel(PLSchool schoolModel) {
        Map<String, String> map = Funcs.javabeanToMap(schoolModel);
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM);
        File file = new File(map.remove("filename"));

        for (String key : map.keySet()) {
            String value = map.get(key);
            builder.addFormDataPart(key, value);
        }

        RequestBody imageBody = RequestBody.create(MediaType.parse("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"), file);
        builder.addFormDataPart("excelFile", file.getName(), imageBody);
        List<MultipartBody.Part> parts = builder.build().parts();

        return Requests.getJson(schoolInterface.creatManageCreatExcel(executor.getToken(),
                parts));
    }


    /**
     * 4.3.4 更新班级
     *
     * @param schoolModel
     * @return
     */
    @Step("更新班级")
    public JSONObject classManageUpdate(PLSchool schoolModel) {
        return exec("classManageUpdate", schoolModel);
    }

    @Step("更新班级")
    public JSONObject classManageUpdate(Parameter parameter) {
        return exec("classManageUpdate", parameter);
    }


    /**
     * 4.3.5 删除班级
     *
     * @return
     */
    @Step("删除班级")
    public JSONObject classManageDelete(String classId) {
        return exec("classManageDelete", Parameter.creat().add("classId", classId));
    }


    /**
     * 4.3.6 一键升级班级
     *
     * @param schoolModel
     * @return
     */
    @Step("一键升级班级")
    public JSONObject classManagePromotion(PLSchool schoolModel) {
        return exec("classManagePromotion", schoolModel);
    }


    /**
     * 4.3.7 管理学生加班
     *
     * @param schoolModel
     * @return
     */
    @Step("管理学生加班")
    public JSONObject classManageUserJoin(PLSchool schoolModel) {
        return exec("classManageUserJoin", schoolModel);
    }

    /**
     * 4.3.8 管理学生退班
     *
     * @return
     */
    @Step("管理学生退班")
    public JSONObject classManageUserExit(String userId, String classId) {
        return exec("classManageUserExit", Parameter.creat()
                .add("userId", userId)
                .add("classId", classId));
    }

    /**
     * 4.3.9 管理学生是否推送一错一练
     *
     * @param schoolModel
     * @return
     */
    @Step("管理学生是否推送一错一练")
    public JSONObject classManageUserPushmarker(PLSchool schoolModel) {
        return exec("classManageUserPushmarker", schoolModel);
    }

    /**
     * 4.4.1 学校可用学年
     *
     * @param schoolModel
     * @return
     */
    @Step("学校可用学年")
    public JSONObject schoolInfoYears(PLSchool schoolModel) {
        return exec("schoolInfoYears", schoolModel);
    }


    /**
     * 4.5.1 学校学科列表
     *
     * @return
     */
    @Step("学校学科列表")
    public JSONObject schoolSubjectSchool() {
        return exec("schoolSubjectSchool");
    }

    /**
     * 4.5.2 班级学科列表
     *
     * @param schoolModel
     * @return
     */
    @Step("班级学科列表")
    public JSONObject schoolSubjectClass(PLSchool schoolModel) {
        return exec("schoolSubjectClass", schoolModel);
    }

    /**
     * 4.5.3 用户学科列表
     *
     * @return
     */
    @Step("用户学科列表")
    public JSONObject schoolSubjectUser() {
        return exec("schoolSubjectUser");
    }


    /**
     * 4.5.4任职为班主任的班级和学科列表（班主任和校管）
     *
     * @param schoolModel
     * @return
     */
    @Step("任职为班主任的班级和学科列表（班主任和校管）")
    public JSONObject schoolClassUserTeachingclasses(PLSchool schoolModel) {
        return exec("schoolClassUserTeachingclasses", schoolModel);
    }

    /**
     * 4.6.1 学校列表返回
     *
     * @param schoolModel
     * @return
     */
    @Step("学校列表返回")
    public JSONObject schoolInfoSchoollist(PLSchool schoolModel) {
        return exec("schoolInfoSchoollist", schoolModel);
    }

    @Step("学校列表返回")
    public JSONObject schoolInfoSchoollist(String schoolName) {
        return exec("schoolInfoSchoollist", Parameter.creat()
                .add("pageNum", "1").add("pageSize", "100").add("schoolName", schoolName));
    }

    /**
     * 4.6.2 学校信息返回
     *
     * @param schoolModel
     * @return
     */
    @Step("学校信息返回")
    public JSONObject schoolInfoDetail(PLSchool schoolModel) {
        return exec("schoolInfoDetail", schoolModel);
    }


    /**
     * 新建学校简单
     *
     * @param schoolName
     * @return
     */
    @Step("新建学校")
    public JSONObject schoolManageCreateSample(String schoolName) {
        return exec("schoolManageCreate", Parameter.creat()
                .add("schoolName", schoolName));
    }

    /**
     * 新建学校 标准
     *
     * @param schoolName
     * @return
     */
    @Step("新建学校")
    public JSONObject schoolManageCreateNorm(String schoolName) {
        return exec("schoolManageCreate", Parameter.creat()
                        .add("schoolName", schoolName)
//                .add("province", "E").add("city", "E")
//                .add("area", "E").add("address", "E")
//                .add("masterName", "").add("phone", "")
//                .add("des", "des")
//                .add("phaseId", "1")
                        .add("schoolType", "0")
        );
    }


    @Step("新建学校")
    public JSONObject schoolManageCreate(String schoolName, String effStart,
                                         String effEnd, String province,
                                         String city, String area,
                                         String address, String masterName,
                                         String phone, String des,
                                         String phaseId, String upperLimit,
                                         String schoolType) {
        return exec("schoolManageCreate", Parameter.creat()
                .add("schoolName", schoolName)
                .add("effStart", effStart).add("effEnd", effEnd)
                .add("province", province).add("city", city)
                .add("area", area).add("address", address)
                .add("masterName", masterName).add("phone", phone)
                .add("des", des).add("phaseId", phaseId)
                .add("upperLimit", upperLimit).add("schoolType", schoolType));
    }


    /**
     * 4.7.2 更新学校
     *
     * @param schoolModel
     * @return
     */
    @Step("更新学校")
    public JSONObject schoolManageUpdate(PLSchool schoolModel) {
        return exec("schoolManageUpdate", schoolModel);
    }

    /**
     * 4.7.3 删除学校
     *
     * @return
     */
    @Step("删除学校")
    public JSONObject schoolManageDelete(String schoolId) {
        return exec("schoolManageDelete", Parameter.creat().add("schoolId", schoolId));
    }

    /**
     * 4.8.1 用户班级列表
     *
     * @param schoolModel
     * @return
     */
    @Step("用户班级列表")
    public JSONObject schoolUsersClass(PLSchool schoolModel) {
        return exec("schoolUsersClass", schoolModel);
    }


    /**
     * 4.8.2 用户学校列表
     *
     * @return
     */
    @Step("用户学校列表")
    public JSONObject schoolUsersSchools(String schoolName) {
        return exec("schoolUsersSchools", Parameter.creat().add("schoolName", schoolName));
    }


    /**
     * 4.8.3用户登录返回个人信息
     *
     * @param schoolModel
     * @return
     */
    @Step("用户登录返回个人信息")
    public JSONObject schoolUsersPageuser(PLSchool schoolModel) {
        return exec("schoolUsersPageuser", schoolModel);
    }

    @Step("用户登录返回个人信息")
    public JSONObject schoolUsersPageuser(Parameter parameter) {
        return exec("schoolUsersPageuser", parameter);
    }

    @Step("用户登录返回个人信息")
    public JSONObject schoolUsersPageuser(String schoolId, String classId) {
        return schoolUsersPageuser(Parameter.creat()
                .add("schoolId", schoolId).add("classId", classId)
                .add("pageSize", "1").add("pageNum", "10"));
    }


    /**
     * 4.8.4 新建用户
     *
     * @return
     */
    @Step("新建用户")
    public JSONObject schoolUsersCreat(String name, String phone, String schoolId, String classId, String subjectId) {
        return exec("schoolUsersCreat", Parameter.creat()
                .add("name", name)
                .add("phone", phone)
                .add("schoolId", schoolId)
                .add("classId", classId)
                .add("subjectId", subjectId));
    }

    @Step("新建用户")
    public JSONObject schoolUsersCreat(String phone, String schoolId) {
        return exec("schoolUsersCreat", Parameter.creat()
                .add("name", "name")
                .add("phone", phone)
                .add("schoolId", schoolId));
    }

    @Step("新建用户")
    public JSONObject schoolUsersCreat(String phone, String schoolId, String classId) {
        return exec("schoolUsersCreat", Parameter.creat()
                .add("name", "name")
                .add("phone", phone)
                .add("schoolId", schoolId)
                .add("classId", classId)
                .add("subjectId", "10"));
    }


    /**
     * 4.8.5 学校用户信息
     *
     * @param schoolModel
     * @return
     */
    @Step("学校用户信息")
    public JSONObject schoolUsersMineSchools(PLSchool schoolModel) {
        return exec("schoolUsersMineSchools", schoolModel);
    }

    @Step("学校用户信息")
    public JSONObject schoolUsersMineSchools() {
        return exec("schoolUsersMineSchools", Parameter.creat().add("roleName", "headteacher"));
    }


    /**
     * 4.9.1根据学校ID获取年级列表
     *
     * @param schoolModel
     * @return
     */
    @Step("根据学校ID获取年级列表")
    public JSONObject schoolGradeList(PLSchool schoolModel) {
        return exec("schoolGradeList", schoolModel);
    }

    @Step("根据学校ID获取年级列表")
    public JSONObject schoolGradeList(String schoolId) {
        return exec("schoolGradeList", Parameter.creat().add("schoolId", schoolId));
    }

    /**
     * 4.9.2根据年级获取班级列表
     *
     * @param schoolModel
     * @return
     */
    @Step("根据年级获取班级列表")
    public JSONObject schoolGradeClass(PLSchool schoolModel) {
        return exec("schoolGradeClass", schoolModel);
    }

    @Step("根据年级获取班级列表")
    public JSONObject schoolGradeClass(String schoolId, String gradeId) {
        return exec("schoolGradeClass", Parameter.creat()
                .add("schoolId", schoolId).add("gradeId", gradeId));
    }


}
