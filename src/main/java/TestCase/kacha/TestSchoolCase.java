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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
