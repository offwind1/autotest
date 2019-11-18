package TestCase.kacha.report;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODReport;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.user.KCSuperAdmin;
import com.mizholdings.kacha.playload.PLReport;
import com.mizholdings.util.SampleAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestReportCase2 {

    private KCParent parent;
    private KCSuperAdmin surpeAdmin;
    private MODReport modReport;
    private String classId;
    private String schoolId;

    @BeforeClass
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
        surpeAdmin = GlobalKC.init().getSuperAdmin();

        modReport = new MODReport(surpeAdmin);
        classId = "642";
        schoolId = "8767";
    }

    @Test(description = "18.1.1 获取省市区")
    public void test1() {
        JSONObject object = modReport.sysAdministrativedivision();
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "18.1.4 查询当前系统时间")
    public void test2() {
        JSONObject object = modReport.sysSystemtime();
        System.out.println(object);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "18.2.3 查询月份列表")
    public void test3() {
        PLReport plReport = new PLReport();
        plReport.setDbQrmonthlist(classId, "2019", "10");

        JSONObject object = modReport.dbQrmonthlist(plReport);
        System.out.println(object);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }


    @Test(description = "18.2.4 查询数据报告详情")
    public void test4() {
        PLReport plReport = new PLReport();
        plReport.setDbQrdetail(classId, "2019", "10");

        JSONObject object = modReport.dbQrdetail(plReport);
        System.out.println(object);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }


    @Test(description = "18.2.9 查询报告学生统计")
    public void test5() {
        PLReport plReport = new PLReport();
        plReport.setDbQrstudentcount(classId, "10", "2019");

        JSONObject object = modReport.dbQrstudentcount(plReport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }


    @Test(description = "18.2.11 查询校级报告")
    public void test6() {
        PLReport plReport = new PLReport();
        plReport.setDbSchooldatareport(schoolId, classId, "10", "1572199609522");

        JSONObject object = modReport.dbSchooldatareport(plReport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "18.2.12 查询班级报告")
    public void test7() {
        PLReport plReport = new PLReport();
        plReport.setDbClassdatareport(classId, "10", "1567267200657");

        JSONObject object = modReport.dbClassdatareport(plReport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "18.2.13 查询时间戳")
    public void test8() {
        PLReport plReport = new PLReport();
        plReport.setDbTimestamp("2019");

        JSONObject object = modReport.dbTimestamp(plReport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "18.2.14 查询学生提交情况")
    public void test9() {
        PLReport plReport = new PLReport();
        plReport.setDbQueryqrdetailforgz(classId, "10", "0");
        plReport.setPageNum("1");
        plReport.setPageSize("10");

        JSONObject object = modReport.dbQueryqrdetailforgz(plReport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);

    }

    @Test(description = "18.2.18 获取百度搜索链接")
    public void test10() {
        PLReport plReport = new PLReport();
        plReport.setDbSearchlink("11111");

        JSONObject object = modReport.dbSearchlink(plReport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }


    @Test(description = "18.2.19 根据班级ID获取知识点列表")
    public void test11() {
        PLReport plReport = new PLReport();
        plReport.setDbKnowledgelist(classId, "2019", "10", "1");

        JSONObject object = modReport.dbKnowledgelist(plReport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }


    @Test(description = "18.2.20 学生统计信息")
    public void test12() {
        PLReport plReport = new PLReport();
        plReport.setDbQueryqrstudentcountforgz(classId, "10", "1");

        JSONObject object = modReport.dbQueryqrstudentcountforgz(plReport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }

    @Test(description = "18.2.21 题目统计信息")
    public void test13() {
        PLReport plReport = new PLReport();
        plReport.setDbQueryqrstudentcountforgz("10", "4656214247377920", "1");
        plReport.setPageSize("10");
        plReport.setPageNum("1");

        JSONObject object = modReport.dbQueryqrstudentcountforgz(plReport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("查询成功!", object);
    }






}
