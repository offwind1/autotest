package com.mizholdings.kacha.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLAuth extends PLJavaBean {
    private String userId;
    private String schoolId;
    private String year;
    private String roleName;
    private String grade;
    private String classId;


    public void setHeadteacher(String userId, String schoolId, String classId) {
        this.userId = userId;
        this.schoolId = schoolId;
        this.classId = classId;
        year = "2019";
        roleName = "headteacher";
    }
}
