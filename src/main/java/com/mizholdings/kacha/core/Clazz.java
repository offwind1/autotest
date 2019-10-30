package com.mizholdings.kacha.core;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.interfaces.SchoolInterface;
import com.mizholdings.util.Requests;

public class Clazz {

    private String classId;
    public static SchoolInterface schoolInterface = Requests.getService(SchoolInterface.class);

    public Clazz(String classId) {
        this.classId = classId;
    }


}
