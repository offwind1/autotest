package com.mizholdings.kacha.box;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.mod.MODSchool2;
import com.mizholdings.kacha.playload.PLSchool;
import com.mizholdings.kacha.user.KCUserBase;

public class KCSchoolBox {
    private MODSchool2 modSchool;
    private KCUserBase executor;

    public KCSchoolBox(KCUserBase executor) {
        this.executor = executor;
        modSchool = new MODSchool2(executor);
    }

    public KCSchoolBox setExecutor(KCUserBase executor) {
        this.executor = executor;
        modSchool.setExecutor(executor);
        return this;
    }

    public PLSchool getPL() {
        return new PLSchool();
    }

    public JSONObject getClassInfo(String classId) {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassInfo(classId);
        return modSchool.classInfo(plSchool);
    }

    public JSONObject getClassList(String schoolId) {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassList(schoolId);
        return modSchool.classList(plSchool);
    }

    public JSONObject creatClass(String schoolId, String className) {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassManageCreat(schoolId, className);
        return modSchool.classManageCreat(plSchool);
    }

    public JSONObject deleteClass(String classId) {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassManageDelete(classId);
        return modSchool.classManageDelete(plSchool);
    }

    public JSONObject classStudentJoin(String classId, String childId) {
//        PLSchool plSchool = getPL();
//        plSchool.setClassStudentJoin(classId, childId);
//        return modSchool.classStudentJoin(plSchool);
        return null;
    }



}
