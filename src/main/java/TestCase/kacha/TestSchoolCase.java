package TestCase.kacha;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.GlobalKC;
import com.mizholdings.kacha.core.mod.MODSchool;
import com.mizholdings.kacha.core.user.KCParent;
import com.mizholdings.kacha.core.user.KCSuperAdmin;
import com.mizholdings.kacha.playload.PLSchool;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

@Feature("学校模块")
public class TestSchoolCase {


    //    private final static Log logger = LogFactory.getLog(TestSchoolCase2.class);
    private KCSuperAdmin superAdmin;
    private KCParent parent;

    private String classId;
    private String schoolId;
    private String childId;
    private MODSchool modSchool;

    @BeforeClass
    public void beforeClass() {
        superAdmin = GlobalKC.init().getSuperAdmin();
        parent = GlobalKC.init().getParent();

        classId = GlobalKC.getClassId();
        schoolId = GlobalKC.getSchoolId();
        childId = GlobalKC.getChildId();

        modSchool = new MODSchool(parent);
    }

    //学生加入班级后，父母解绑学生。学生在班级中的状态
    @Test(description = "学生加入班级后，父母解绑学生。学生在班级中的状态")
    public void test1() {
        //新建子女
        String userId = parent.getNewChildId("asd222");

        //子女加入班级
        PLSchool plSchool = new PLSchool();
        plSchool.setClassStudentJoin(classId, userId);
        JSONObject object = modSchool.classStudentJoin(plSchool);

        //查询班级成员列表
        plSchool = new PLSchool();
        plSchool.setClassMembers(schoolId, classId, "3");
        object = modSchool.classMembers(plSchool);

        //解绑子女
        object = parent.deleteChild(userId);

        //查询班级成员列表
        plSchool = new PLSchool();
        plSchool.setClassMembers(schoolId, classId, "3");
        object = modSchool.classMembers(plSchool);

        // 退出班级
        plSchool = new PLSchool();
        plSchool.setClassStudentExit(classId, userId);
        object = modSchool.classStudentExit(plSchool);
    }


    @Test(description = "查看班级信息")
    public void test2() {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassDetail(classId);
        JSONObject object = modSchool.classDetail(plSchool);
        SampleAssert.assertEquals("获取成功！", object);

        plSchool = new PLSchool();
        plSchool.setClassDetail(schoolId, "2019", "19900000002");
        object = modSchool.classDetail(plSchool);
        SampleAssert.assertEquals("查询成功", object);
    }


    @Test(description = "班级教室")
    public void test3() {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassDetailOwner("培老师", "19900000002", "2019");
        JSONObject object = modSchool.classDetailOwner(plSchool);
        SampleAssert.assertEquals("获取成功", object);
    }

    private String newClassId;
    String className = "新建的班级";

    public JSONObject getClassInfo(String classId) {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassInfo(classId);
        return modSchool.classInfo(plSchool);
    }

    public JSONObject getClassList() {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassList(schoolId);
        return modSchool.classList(plSchool);
    }

    public JSONObject creatClass() {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassManageCreat(schoolId, className);
        return modSchool.classManageCreat(plSchool);
    }

    public JSONObject deleteClass(String classId) {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassManageDelete(classId);
        return modSchool.classManageDelete(plSchool);
    }

    @Test(description = "新建班级", groups = {"class_test"})
    public void test4() {
        JSONObject object = creatClass();
        SampleAssert.assertEquals("查询成功", object);
        newClassId = object.getJSONObject("data").getString("classId");

        object = getClassList();
        assert object.getJSONObject("data").getJSONArray("list").stream().anyMatch(x -> {
            JSONObject o = (JSONObject) x;
            return newClassId.equals(o.getString("classId"));
        }) : "新建班级在学校班级列表中没有查出";
    }

    @Test(dependsOnMethods = {"test4"}, groups = {"class_test"}, description = "更新班级")
    public void updateClass() {
        PLSchool plSchool = new PLSchool();
        plSchool.setClassId(newClassId);
        plSchool.setClassName(className + "new");
        plSchool.setYears("2018");
        plSchool.setDes("这是简介");

        JSONObject object = modSchool.classManageUpdate(plSchool);
        SampleAssert.assertEquals("查询成功", object);

        object = getClassList();
        List<Object> list = object.getJSONObject("data").getJSONArray("list").stream().filter(x -> {
            JSONObject o = (JSONObject) x;
            return newClassId.equals(o.getString("classId"));
        }).collect(Collectors.toList());

        assert list.size() > 0 : "未查询到 新建的班级";
        object = (JSONObject) list.get(0);
        assert object.getString("className").equals(className + "new");
        assert object.getString("years").equals("2018");
    }

    @AfterGroups(groups = {"class_test"}, description = "删除班级")
    public void after_creat_class_test() {
        if (newClassId != null) {
            JSONObject object = deleteClass(newClassId);
            SampleAssert.assertEquals("查询成功", object);

            object = getClassList();
            assert object.getJSONObject("data").getJSONArray("list").stream().allMatch(x -> {
                JSONObject o = (JSONObject) x;
                return !newClassId.equals(o.getString("classId"));
            }) : "删除后，还能在学校列表里查到";
        }
    }

    @Test(description = "以删除的班级，不能加入学生")
    public void test5() {
        //新建班级
        JSONObject object = creatClass();
        String delete_classId = object.getJSONObject("data").getString("classId");
        //删除班级
        object = deleteClass(delete_classId);

        //查询班级信息
        object = getClassInfo(delete_classId);

        //尝试加人班级
        PLSchool plSchool = new PLSchool();
        plSchool.setClassStudentJoin(delete_classId, childId);
        object = modSchool.classStudentJoin(plSchool);
        SampleAssert.assertEquals("班级不存在！", object);
    }


    //    @Test(description = "创建并更新学校")
//    @Title("创建并更新学校")
    public void test11() {
        MODSchool schoolMod = new MODSchool(superAdmin);
        String schoolName = "testSchool";
        JSONObject object;

        // 创建学校
        PLSchool schoolModel = new PLSchool();
        schoolModel.setSchoolManageCreate(schoolName);
        object = schoolMod.schoolManageCreate(schoolModel);
        SampleAssert.assertEquals("查询成功", object);
        System.out.println(object);

        // 查询学校
        schoolModel = new PLSchool();
        schoolModel.setSchoolInfoSchoollist(schoolName);
        object = schoolMod.schoolInfoSchoollist(schoolModel);

        JSONArray array = object.getJSONObject("data").getJSONArray("list");
        Assert.assertTrue(array != null);
        String schoolid = array.getJSONObject(0).getString("schoolId");


        // 修改学校
        schoolName = schoolName + "111";
        schoolModel = new PLSchool();
        schoolModel.setSchoolManageUpdate(schoolid, schoolName);
        object = schoolMod.schoolManageUpdate(schoolModel);
        SampleAssert.assertEquals("查询成功", object);

        // 查看学校详情
        schoolModel = new PLSchool();
        schoolModel.setSchoolInfoDetail(schoolid);
        object = schoolMod.schoolInfoDetail(schoolModel);
        SampleAssert.assertEquals("查询成功", object);

        // 删除学校
        schoolModel = new PLSchool();
        schoolModel.setSchoolManageDelete(schoolid);
        object = schoolMod.schoolManageDelete(schoolModel);
        SampleAssert.assertEquals("查询成功", object);

    }


}
