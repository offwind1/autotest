package com.mizholdings.kacha.cases;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.Parent;
import com.mizholdings.kacha.core.SurpeAdmin;
import com.mizholdings.kacha.model.SchoolModel;
import com.myreport.Title;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSchoolCase {

    SurpeAdmin surpeAdmin;

    @BeforeClass
    public void beforeClass() {
        surpeAdmin = new SurpeAdmin("17857066666", "654321");
    }


    @Test
    @Title("创建并更新学校")
    public void test1() {

        JSONObject school = surpeAdmin.creatSchool("bbb");
        String schoolId = school.getJSONObject("data").getString("schoolId");

        school = surpeAdmin.updateSchool(schoolId, "ospd");

        school = surpeAdmin.deleteSchool(schoolId);
    }

}
