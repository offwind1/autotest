package TestCase.kacha.export;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODExport;
import com.mizholdings.kacha.box.SLOTWrongBook;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.playload.PLExport;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

@Feature("错题本测试")
public class TestExportCase2 {
    private KCParent parent;
    private SLOTWrongBook slotWrongBook;
    private MODExport modExport;

    @BeforeClass(description = "初始化")
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
        slotWrongBook = new SLOTWrongBook(parent);
        modExport = new MODExport(parent);
    }

    @Test(description = "12.1 学生错题导出")
    public void test1() {
        JSONObject object = slotWrongBook.getQuestions();
        SampleAssert.assertEquals("查询成功", object);

        List<String> list = object.getJSONObject("data").getJSONArray("list").stream().map(i -> {
            JSONObject o = (JSONObject) i;
            return o.getString("wrongId");
        }).collect(Collectors.toList());

        String uqldsStr = String.join(",", list);

        PLExport plExport = new PLExport();
        plExport.setPdfMakestudentwb(uqldsStr, parent.currentChild(), "0");

        JSONObject object1 = modExport.pdfMakestudentwb(plExport);
        SampleAssert.assertResult("0", object1);
    }

    @Test(description = "一错一练选择错题导出")
    public void test2() {
        JSONObject object = slotWrongBook.getQuestions();
        SampleAssert.assertEquals("查询成功", object);

        List<String> list = object.getJSONObject("data").getJSONArray("list").stream().map(i -> {
            JSONObject o = (JSONObject) i;
            return o.getString("wrongId");
        }).collect(Collectors.toList());

        String uqldsStr = String.join(",", list.subList(0, 3));

        PLExport plExport = new PLExport();
        plExport.setPdfMakeselectwb(uqldsStr, parent.currentChild());

        JSONObject object1 = modExport.pdfMakeselectwb(plExport);
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("生成成功!", object1);
    }

    @Test(description = "一错一练知识点错题导出")
    public void test3() {
        PLExport plExport = new PLExport();
        plExport.setPdfMakeknowledgewb("111", parent.currentChild());

        JSONObject object = modExport.pdfMakeknowledgewb(plExport);
        SampleAssert.assertResult("0", object);
    }

    @Test(description = "按时间导出用户错题本")
    public void test4() {
        PLExport plExport = new PLExport();
        plExport.setPdfMakeuserdatewb(parent.currentChild(), "10", "2019-10-01", "2019-11-01", "1");

        JSONObject object = modExport.pdfMakeuserdatewb(plExport);
        SampleAssert.assertResult("0", object);
    }

    @Test(description = "用户导出错题压缩包")
    public void test5() {
        PLExport plExport = new PLExport();
        plExport.setPdfExportstudentpdf(parent.currentChild(), "10", "2019-10-01", "2019-11-01", "1");

        JSONObject object = modExport.pdfExportstudentpdf(plExport);
        SampleAssert.assertResult("0", object);
    }

    @Test(description = "查询导出记录")
    public void test6() {
        PLExport plExport = new PLExport();
        plExport.setRecordInfo("11");
        JSONObject object = modExport.recordInfo(plExport);
        SampleAssert.assertResult("0", object);
    }


}
