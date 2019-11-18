package com.mizholdings.kacha.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.mod.MODSchool2;
import com.mizholdings.kacha.playload.PLSchool;

public class KCSchooler extends KCUserBase {
    //    public static SchoolInterface2 schoolInterface2 = Requests.getService(SchoolInterface2.class);
    private MODSchool2 modSchool;

    public KCSchooler(String account, String password) {
        super("kcsj", account, password);
        modSchool = new MODSchool2(this);
    }


    /**
     * 用户学校列表
     *
     * @return
     */
    public JSONObject schools(String schoolName) {
        PLSchool plSchool = new PLSchool();
        plSchool.setSchoolUsersSchools(schoolName);
        return modSchool.schoolUsersSchools(plSchool);
    }

    /**
     * 班级列表
     *
     * @param schoolId
     * @return
     */
    public JSONObject classList(String schoolId) {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassList(schoolId, "", "1", "9999");
        return modSchool.classList(plSchool);
    }

    /**
     * 班级成员
     *
     * @param schoolId
     * @param classId
     * @return
     */
    public JSONObject classMembers(String schoolId, String classId) {
        return modSchool.classMembers(schoolId, classId, "3");
    }

}
