package normalTest;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.util.Common;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class courseTestCase {

    private Teacher teacher;
    private Teacher other;
    private SuperAdmin superAdmin;
    private String courseId;

    @BeforeClass
    public void beforeClass() {
        teacher = Global.init().getTeacher();
        other = Global.init().getRandomTeacher();
        superAdmin = Global.init().getSuperAdmin();


        courseId = teacher.newCourseAndApply();
//        courseId = "3ccaa3fa332941f2be474c5a3c0c6178";
    }

    @Test(description = "资源库列表course/list")
    public void test_course_list() {
        JSONObject object = teacher.getWeb().courseAgent().list();
        assert object.getJSONObject("data").getJSONArray("list").size() > 0 : "返回数据为空";
    }

    @Test(description = "根据ID，获得资源详情course/getCourseById")
    public void test_course_getCourseById() {
        teacher.getWeb().courseAgent().getCourseById(courseId);
    }

    @Test(description = "根据ID获得资源子集course/getChildListById")
    public void test_course_getChildListById() {
        JSONObject object = teacher.getWeb().courseAgent().getChildListById(courseId);

        if (ObjectUtil.isNotNull(object.getJSONObject("data"))) {
            assert object.getJSONObject("data").getJSONArray("childList").size() > 0 : "返回数据为空";
        } else {
            throw new RuntimeException("返回数据为空 ：" + object.toJSONString());
        }
    }

    @Test(description = "设置资源信息course/editCourseware")
    public void test_course_editCourseware() {
        String name = Common.creatRandomString();
        JSONObject object = teacher.getWeb().courseAgent().editCourseware(courseId, name);
        SampleAssert.assertCode200(object);
    }

    @Test(description = "添加资源_从资源库选择添加course/addOldCourse")
    public void test_course_addOldCourse() {
        teacher.getWeb().courseAgent().addOldCourse(courseId, courseId);
    }

    @Test(description = "添加资源_新增添加course/addNewCourse")
    public void test_course_addNewCourse() {
        teacher.getWeb().courseAgent().addNewCourse(courseId);
    }

    @Test(description = "删除子资源中一个course/delChild", dependsOnMethods = {"test_course_addOldCourse"})
    public void test_course_delChild() {
        JSONObject object = teacher.getWeb().courseAgent().getChildListById(courseId);
        List<String> list = Common.map(object.getJSONObject("data").getJSONArray("childList"), "coursewareId");

        int i = Common.range(0, list.size());
        teacher.getWeb().courseAgent().delChild(courseId, list.get(i), String.valueOf(i));
    }

    @Test(description = "自己创建的资源列表course/mylist")
    public void test_course_mylist() {
        JSONObject object = teacher.getWeb().courseAgent().mylist();
        assert object.getJSONObject("data").getJSONArray("list").size() > 0 : "返回数据为空";
    }

    @Test(description = "用户购买资源列表course/buylist")
    public void test_course_buylist() {
        JSONObject object = teacher.getWeb().courseAgent().buylist();
        assert object.getJSONObject("data").getJSONArray("list").size() > 0 : "返回数据为空";
    }

    @Test(description = "根据ID获取详情，自己创建的资源（有已审批的、未审批的）course/getMyCosById")
    public void test_course_getMyCosById() {
        teacher.getWeb().courseAgent().getMyCosById(courseId);
    }

    @Test(description = "根据ID获得资源子集,自己创建的资源（有已审批的、未审批的）course/getMyChildListById")
    public void test_course_getMyChildListById() {
        teacher.getWeb().courseAgent().getMyChildListById(courseId);
    }

    @Test(description = "资源送审course/applyCourse")
    public void test_course_applyCourse() {
        teacher.getWeb().courseAgent().applyCourse(courseId);
    }

//    @Test(description = "审批资源列表course/applylist")
//    public void test_course_applylist() {
//        JSONObject object = superAdmin.getManage().courseAgent().applylist();
//        SampleAssert.assertCode200(object);
//    }

    @Test(description = "审批资源course/replyCourse")
    public void test_course_replyCourse() {
        JSONObject object = superAdmin.getManage().courseAgent().replyCourse(courseId);
        SampleAssert.assertCode200(object);
    }

//
//    @Test(description = "购买资源course/buyCourse")
//    public void test_course_buyCourse() {
//        JSONObject object = other.getWeb().courseAgent().buyCourse(courseId);
//        SampleAssert.assertCode200(object);
//    }

    @Test(description = "根据课程id查询订单course/getConsumByCourseId")
    public void test_course_getConsumByCourseId() {
        JSONObject object = teacher.getWeb().courseAgent().getConsumByCourseId(courseId);
        SampleAssert.assertCode200(object);
    }

    @Test(description = "下架资源course/banCourse")
    public void test_course_banCourse() {
        teacher.getWeb().courseAgent().banCourse(courseId);
    }

    @Test(description = "推荐资源course/recommendCourseware")
    public void test_course_recommendCourseware() {
        superAdmin.getManage().courseAgent().recommendCourseware(courseId);
    }

    @Test(description = "获取资源标签web/course/getTags")
    public void test_course_getTags() {
        teacher.getWeb().courseAgent().getTags(courseId);
    }

    @Test(description = "资源类型分类courseType/list")
    public void test_courseType_list() {
        teacher.getWeb().courseTypeAgent().list();
    }

    @AfterClass(description = "删除自己的资源(必须是未送审，或者已经审批过的)course/delMyCourse")
    public void test_course_delMyCourse() {
        teacher.getWeb().courseAgent().delMyCourse(courseId);
    }


}