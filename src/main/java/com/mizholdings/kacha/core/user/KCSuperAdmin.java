package com.mizholdings.kacha.core.user;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.playload.PLAuth;
import com.mizholdings.util.Funcs;
import com.mizholdings.util.Requests;

import java.util.Map;

public class KCSuperAdmin extends KCUserBase {
//    public static SchoolInterface2 schoolInterface2 = Requests.getService(SchoolInterface2.class);

    public KCSuperAdmin(String account, String password) {
        super("kcsj", account, password);
    }

//    public JSONObject deleteSchool(String schoolId) {
//        return Requests.getJson(schoolInterface2.deleteSchool(token, schoolId));
//    }
//
//    /**
//     * 超级管理员 查询班级成员
//     *
//     * @param classId   班级id
//     * @param subjectId 学科id
//     * @return json
//     */
//    public JSONObject searchClassMembers(String classId, String subjectId) {
//        return Requests.getJson(schoolInterface2.getClassMembersForSA(token,
//                classId,
//                subjectId,
//                "",
//                ""));
//    }

    /**
     * 指派用户权限
     *
     * @param authModel
     * @return
     */
    public JSONObject assignAuth(PLAuth authModel) {
        Map<String, String> map = Funcs.javabeanToMap(authModel);
        return Requests.getJson(authInterface.assignAuth(token, map));
    }


}
