package com.mizholdings.kacha.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.kacha.core.user.KCUserBase;
import com.mizholdings.kacha.interfaces.SchoolInterface;
import com.mizholdings.kacha.playload.PLSchool;
import com.mizholdings.util.Funcs;
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
     * @param schoolModel
     * @return
     */
    @Step("学生加入班级")
    public JSONObject classStudentJoin(PLSchool schoolModel) {
        return exec("classStudentJoin", schoolModel);
//        return Requests.getJson(schoolInterface.classStudentJoin(executor.getToken(), Funcs.javabeanToMap(schoolModel)));
    }

    /**
     * 4.1.2 退出班级
     *
     * @param schoolModel
     * @return
     */
    @Step("退出班级")
    public JSONObject classStudentExit(PLSchool schoolModel) {
//        return Requests.getJson(schoolInterface.classStudentExit(executor.getToken(), Funcs.javabeanToMap(schoolModel)));
        return exec("classStudentExit", schoolModel);
    }

    /**
     * 4.1.3 成员列表
     *
     * @param schoolModel
     * @return
     */
    @Step("成员列表")
    public JSONObject classMembers(PLSchool schoolModel) {
//        return Requests.getJson(schoolInterface.classMembers(executor.getToken(), Funcs.javabeanToMap(schoolModel)));
        return exec("classMembers", schoolModel);
    }

    /**
     * 4.1.4 超级管理员页面学生数据
     *
     * @param schoolModel
     * @return
     */
    @Step("超级管理员页面学生数据")
    public JSONObject classMembersForSA(PLSchool schoolModel) {
//        return Requests.getJson(schoolInterface.classMembersForSA(executor.getToken(), Funcs.javabeanToMap(schoolModel)));
        return exec("classMembersForSA", schoolModel);
    }

    /**
     * 4.2.1 班级信息
     *
     * @param schoolModel
     * @return
     */
    @Step("班级信息")
    public JSONObject classDetail(PLSchool schoolModel) {
//        return Requests.getJson(schoolInterface.classDetail(executor.getToken(), Funcs.javabeanToMap(schoolModel)));
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
//        return Requests.getJson(schoolInterface.classInfo(executor.getToken(), Funcs.javabeanToMap(schoolModel)));
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
     * @param schoolModel
     * @return
     */
    @Step("新建班级")
    public JSONObject classManageCreat(PLSchool schoolModel) {
        return exec("classManageCreat", schoolModel);
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


    /**
     * 4.3.5 删除班级
     *
     * @param schoolModel
     * @return
     */
    @Step("删除班级")
    public JSONObject classManageDelete(PLSchool schoolModel) {
        return exec("classManageDelete", schoolModel);
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
     * @param schoolModel
     * @return
     */
    @Step("管理学生退班")
    public JSONObject classManageUserExit(PLSchool schoolModel) {
        return exec("classManageUserExit", schoolModel);
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
     * 4.7.1 新建学校
     *
     * @param schoolModel
     * @return
     */
    @Step("新建学校")
    public JSONObject schoolManageCreate(PLSchool schoolModel) {
        return exec("schoolManageCreate", schoolModel);
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
     * @param schoolModel
     * @return
     */
    @Step("删除学校")
    public JSONObject schoolManageDelete(PLSchool schoolModel) {
        return exec("schoolManageDelete", schoolModel);
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
     * @param schoolModel
     * @return
     */
    @Step("用户学校列表")
    public JSONObject schoolUsersSchools(PLSchool schoolModel) {
        return exec("schoolUsersSchools", schoolModel);
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


    /**
     * 4.8.4 新建用户
     *
     * @param schoolModel
     * @return
     */
    @Step("新建用户")
    public JSONObject schoolUsersCreat(PLSchool schoolModel) {
        return exec("schoolUsersCreat", schoolModel);
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


}
