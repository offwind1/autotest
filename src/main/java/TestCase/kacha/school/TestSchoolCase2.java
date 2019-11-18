package TestCase.kacha.school;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODSchool;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.user.KCSuperAdmin;
import com.mizholdings.kacha.user.KCTeacher;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Allure;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestSchoolCase2 {
    private KCSuperAdmin superAdmin;
    private KCParent parent;
    private KCParent parent_other;
    private KCTeacher teacher;

    private String classId;
    private String schoolId;
    private String childId;
    private MODSchool modSchool;


    @BeforeClass
    public void beforeClass() {
        superAdmin = GlobalKC.init().getSuperAdmin();
        parent = GlobalKC.init().getParent();
        modSchool = new MODSchool(superAdmin);
    }

    @Test(description = "4_2_1 学校被删除后，班级是否还能加人学生")
    public void test4_2_1() {
        modSchool.setExecutor(superAdmin);

        JSONObject object = modSchool.schoolManageCreateNorm("newSchool");
        String schoolId = object.getJSONObject("data").getString("schoolId");

        object = modSchool.classManageCreat(schoolId, "newClass");
        String classId = object.getJSONObject("data").getString("classId");

        modSchool.schoolManageDelete(schoolId);

        modSchool.setExecutor(parent);
        parent.deleteAllChilds(GlobalKC.getChildId());
        object = parent.addChild("newChild");
        String userId = object.getJSONObject("data").getString("userId");

        modSchool.classStudentJoin(classId, userId);
    }

    @Test(description = "4_2_2 学生加入班级后，父母解绑学生，学生在班级中是否还存在")
    public void test4_2_2() {
        modSchool.setExecutor(superAdmin);

        //创建学校
        JSONObject object = modSchool.schoolManageCreateNorm("newSchool");
        String schoolId = object.getJSONObject("data").getString("schoolId");

        //新建班级
        object = modSchool.classManageCreat(schoolId, "newClass");
        String classId = object.getJSONObject("data").getString("classId");

        modSchool.setExecutor(parent);
        //新建子女
        parent.deleteAllChilds(GlobalKC.getChildId());
        object = parent.addChild("newChild");
        String userId = object.getJSONObject("data").getString("userId");

        //子女加入班级
        modSchool.classStudentJoin(classId, userId);

        //解绑子女
        parent.deleteChild(userId);

        //查看班级列表
        JSONObject object1 = modSchool.classMembers(schoolId, classId);
        //删除学校
        modSchool.schoolManageDelete(schoolId);

        if (object1.getJSONArray("data").stream().anyMatch(i -> {
            JSONObject o = (JSONObject) i;
            return userId.equals(o.getString("userId"));
        })) {
            throw new RuntimeException("班级中，依旧存在被解除绑定的子女");
        }
    }

    @Test(description = "4_2_3 已删除的班级不能再加入学生")
    public void test4_2_3() {
        modSchool.setExecutor(superAdmin);
        String schoolId = GlobalKC.getSchoolId();

        //新建班级
        JSONObject object = modSchool.classManageCreat(schoolId, "newClass");
        String classId = object.getJSONObject("data").getString("classId");

        //删除班级
        modSchool.classManageDelete(classId);

        //学生加入以删除的班级
        modSchool.setExecutor(parent);

        //新建子女
        String userId = parent.getNewChildId();
        object = modSchool.classStudentJoin(classId, userId);
        SampleAssert.assertEquals("班级不存在！", object);
    }

    @Test(description = "4_2_4 学生重复加入班级")
    public void test4_2_4() {
        modSchool.setExecutor(superAdmin);
        String schoolId = GlobalKC.getSchoolId();

        //新建班级
        JSONObject object = modSchool.classManageCreat(schoolId, "newClass");
        String classId = object.getJSONObject("data").getString("classId");

        //学生加入以删除的班级
        modSchool.setExecutor(parent);

        //新建子女
        String userId = parent.getNewChildId();
        //班级添加子女
        modSchool.classStudentJoin(classId, userId);

        //班级删除子女
        object = modSchool.classStudentExit(classId, userId);
        object = modSchool.classStudentExit(classId, userId);

        //查看班级列表
        modSchool.classMembers(schoolId, classId);
        //删除班级
        modSchool.classManageDelete(classId);

        SampleAssert.assertEquals("学生未加入班级", object);
    }

    @Test(description = "4_2_5 学生加入多个班级")
    public void test4_2_5() {
        //新建子女
        String userId = parent.getNewChildId();
        String schoolId = GlobalKC.getSchoolId();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            //新建班级
            JSONObject object = modSchool.setExecutor(superAdmin).classManageCreat(schoolId, "newClass");
            String classId = object.getJSONObject("data").getString("classId");
            object = modSchool.setExecutor(parent).classStudentJoin(classId, userId);
            SampleAssert.assertEquals("加入成功！", object);

            list.add(classId);
        }

        parent.getChilds();

        for (String classId : list) {
            modSchool.setExecutor(superAdmin).classMembers(schoolId, classId);
            modSchool.classManageDelete(classId);
        }

    }

    @Test(description = "4_2_6 子女加入班级后，班级删除，子女信息是否还有班级数据")
    public void test4_2_6() {
        //新建子女
        String userId = parent.getNewChildId();
        String schoolId = GlobalKC.getSchoolId();
        //新建班级
        JSONObject object = modSchool.setExecutor(superAdmin).classManageCreat(schoolId, "newClass");
        String classId = object.getJSONObject("data").getString("classId");
        //子女加入班级
        object = modSchool.setExecutor(parent).classStudentJoin(classId, userId);

        //删除班级
        modSchool.classManageDelete(classId);

        //获取子女信息
        object = parent.getChilds();
        List<Object> list = object.getJSONArray("data").stream().filter(i -> {
            JSONObject o = (JSONObject) i;
            return userId.equals(o.getString("id"));
        }).collect(Collectors.toList());

        if (list.size() > 0) {
            JSONObject userInfo = (JSONObject) list.get(0);
            Allure.addAttachment("用户信息", userInfo.toJSONString());
            throw new RuntimeException("依旧留有删除的班级信息");
        }
    }

}
