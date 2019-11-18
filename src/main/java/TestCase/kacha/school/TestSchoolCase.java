package TestCase.kacha.school;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.box.KCSchoolBox;
import com.mizholdings.kacha.mod.MODSchool;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.user.KCSuperAdmin;
import com.mizholdings.kacha.user.KCTeacher;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Description;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestSchoolCase {
    private KCSuperAdmin superAdmin;
    private KCParent parent;
    private KCParent parent_other;
    private KCTeacher teacher;

    //    private String classId;
//    private String schoolId;
//    private String childId;
    private MODSchool modSchool;
    private String phone = "19900000101";

    @BeforeClass
    public void beforeClass() {
        superAdmin = GlobalKC.init().getSuperAdmin();
        parent = GlobalKC.init().getParent();
        modSchool = new MODSchool(superAdmin);
    }

    @Test(description = "4_1_1_1 创建学校时，未输入“schoolType”参数。执行正常流程")
    public void test4_1_1_1() {
        JSONObject object = modSchool.schoolManageCreateSample("newSchool");
        String schoolId = object.getJSONObject("data").getString("schoolId");

        schoolNormalTest(schoolId);
    }

    @Test(description = "4_1_1_2 创建学校时，输入“schoolType”参数，执行正常流程")
    public void test4_1_1_2() {
        JSONObject object = modSchool.schoolManageCreateNorm("newSchool");
        String schoolId = object.getJSONObject("data").getString("schoolId");

        schoolNormalTest(schoolId);
    }


    public void schoolNormalTest(String schoolId) {
        JSONObject object = modSchool.classManageCreat(schoolId, "newClass");
        String classId = object.getJSONObject("data").getString("classId");

        parent.deleteAllChilds(GlobalKC.getChildId());
        object = parent.addChild("newChild");
        String userId = object.getJSONObject("data").getString("userId");

        modSchool.setExecutor(parent);
        object = modSchool.classStudentJoin(classId, userId);
        modSchool.setExecutor(superAdmin);
        modSchool.schoolManageDelete(schoolId);

        SampleAssert.assertResult("0", object);
    }

    @Test(description = "4_1_3_1 学校添加教师 不带classId 参数")
    public void test4_1_3_1() {
        String schoolId = GlobalKC.init().getNewSchool();

        modSchool.schoolUsersCreat(phone, schoolId);
        JSONObject object1 = modSchool.classMembers(schoolId);
        modSchool.schoolManageDelete(schoolId);

        assert object1.getJSONArray("data").stream().anyMatch(i -> {
            JSONObject object2 = (JSONObject) i;
            return phone.equals(object2.getString("phone"));
        }) : "学校成员中，未查询出该教师";
    }

    @Test(description = "4_1_3_2 学校添加教师 带classId 参数")
    public void test4_1_3_2() {
        String schoolId = GlobalKC.init().getNewSchool();
        JSONObject object = modSchool.classManageCreat(schoolId, "newClass");
        String classId = object.getJSONObject("data").getString("classId");

        modSchool.schoolUsersCreat(phone, schoolId, classId);
        JSONObject object1 = modSchool.classMembers(schoolId);
        modSchool.schoolManageDelete(schoolId);

        assert object1.getJSONArray("data").stream().anyMatch(i -> {
            JSONObject object2 = (JSONObject) i;
            return phone.equals(object2.getString("phone"));
        }) : "学校成员中，未查询出该教师";
    }

    @Test(description = "4_1_3_1 学校添加教师 schoolId和classId没有相关性")
    public void test4_1_3_3() {
        String schoolId = GlobalKC.init().getNewSchool();
        JSONObject object = modSchool.classManageCreat(schoolId, "newClass");
        String classId = object.getJSONObject("data").getString("classId");

        object = modSchool.schoolUsersCreat(phone, GlobalKC.init().getNewSchool(), classId);
        SampleAssert.assertEquals("查询成功", object);
        JSONObject object1 = modSchool.classMembers(schoolId);
        modSchool.schoolManageDelete(schoolId);

        assert object1.getJSONArray("data").stream().anyMatch(i -> {
            JSONObject object2 = (JSONObject) i;
            return phone.equals(object2.getString("phone"));
        }) : "学校成员中，未查询出该教师";
    }


    @Test(description = "4_1_2 学校删除，非当前班级的教师")
    public void test4_1_2() {
        String schoolId = GlobalKC.init().getNewSchool();

        JSONObject object = modSchool.classManageCreat(schoolId, "newClass");
        String classId1 = object.getJSONObject("data").getString("classId");

        object = modSchool.classManageCreat(schoolId, "newClass");
        String classId2 = object.getJSONObject("data").getString("classId");

        modSchool.schoolUsersCreat(phone, schoolId, classId1);
        JSONObject object1 = modSchool.classMembers(schoolId);
        List<Object> list = object1.getJSONArray("data").stream().filter(i -> {
            JSONObject object2 = (JSONObject) i;
            return phone.equals(object2.getString("phone"));
        }).collect(Collectors.toList());
        assert list.size() > 0 : "学校成员中，未查询出该教师";

        JSONObject userInfo = (JSONObject) list.get(0);
        String userId = userInfo.getString("userId");

        object = modSchool.classManageUserExit(userId, classId2);
        assert !"查询成功".equals(object.getString("msg")) : "删除非班级的用户，依旧返回查询成功";
        modSchool.classMembers(schoolId);
    }

    @Test(description = "4_1_4_1 获取年级列表 ")
    @Description("加入年级为3,9.15 的班级")
    public void test4_1_4_1() {
        modSchool.setExecutor(superAdmin);
        String schoolId = GlobalKC.init().getNewSchool();
        List<String> list = Arrays.asList("3", "9", "15");

        for (String gradeId : list) {
            modSchool.classManageCreat(schoolId, "className", gradeId);
        }

        JSONObject object = modSchool.schoolGradeList(schoolId);
        assert object.getJSONArray("data").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return list.lastIndexOf(o.getString("id")) >= 0;
        });
    }

    @Test(description = "4_1_4_2 获取年级列表 删除班级")
    @Description("加入年级为3,9.15 的班级，之后删除年级为15的班级")
    public void test4_1_4_2() {
        modSchool.setExecutor(superAdmin);
        String schoolId = GlobalKC.init().getNewSchool();
        List<String> list = Arrays.asList("3", "9", "15");
        JSONObject object = null;

        for (String gradeId : list) {
            object = modSchool.classManageCreat(schoolId, "className", gradeId);
        }

        String classId = object.getJSONObject("data").getString("classId");
        modSchool.classManageDelete(classId);


        object = modSchool.schoolGradeList(schoolId);
        assert object.getJSONArray("data").stream().allMatch(i -> {
            JSONObject o = (JSONObject) i;
            return list.lastIndexOf(o.getString("id")) >= 0;
        });
    }

    @Test(description = "4_1_5 根据年级获取班级列表")
    public void test4_1_5() {
        modSchool.setExecutor(superAdmin);

        String schoolId = GlobalKC.init().getNewSchool();
        List<String> list = Arrays.asList("3", "3", "5", "5", "5");
        JSONObject object = null;
        int i = 0;
        for (String gradeId : list) {
            object = modSchool.classManageCreat(schoolId, "className" + String.valueOf(i) + "_" + gradeId, gradeId);
            i++;
        }

        String classId = object.getJSONObject("data").getString("classId");
        modSchool.classManageUpdate(Parameter.creat().add("classId", classId).add("gradeId", "9"));

        modSchool.schoolGradeClass(schoolId, "3");
        modSchool.schoolGradeClass(schoolId, "5");
        modSchool.schoolGradeClass(schoolId, "9");
    }

    @Test(description = "4_1_5 根据年级获取班级列表")
    public void test() {
        modSchool.schoolUsersPageuser(GlobalKC.getSchoolId(), GlobalKC.getClassId());
    }


}
