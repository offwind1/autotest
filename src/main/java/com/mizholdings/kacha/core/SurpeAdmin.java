package com.mizholdings.kacha.core;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.mizholdings.kacha.interfaces.SchoolInterface;
import com.mizholdings.kacha.model.SchoolModel;
import com.mizholdings.util.Funcs;
import com.mizholdings.util.Requests;

import java.util.HashMap;
import java.util.Map;

public class SurpeAdmin extends User {

    public static SchoolInterface schoolInterface = Requests.getService(SchoolInterface.class);

    public SurpeAdmin(String account, String password) {
        super("kcsj", account, password);
    }

    public JSONObject creatSchool(SchoolModel schoolModel) {
        Map<String, String> map = Funcs.javabeanToMap(schoolModel);
        return Requests.getJson(schoolInterface.creatSchool(token, map));
    }

    public JSONObject creatSchool(String schoolName) {
        SchoolModel schoolModel = new SchoolModel();
        schoolModel.setSchoolName(schoolName);
        return creatSchool(schoolModel);
    }

    public JSONObject updateSchool(SchoolModel schoolModel) {
        Map<String, String> map = Funcs.javabeanToMap(schoolModel);
        return Requests.getJson(schoolInterface.updateSchool(token, map));
    }

    public JSONObject updateSchool(String schoolId, String schoolName) {
        SchoolModel schoolModel = new SchoolModel();
        schoolModel.setSchoolId(schoolId);
        schoolModel.setSchoolName(schoolName);

        return updateSchool(schoolModel);
    }

    public JSONObject deleteSchool(String schoolId) {
        return Requests.getJson(schoolInterface.deleteSchool(token, schoolId));
    }

}
