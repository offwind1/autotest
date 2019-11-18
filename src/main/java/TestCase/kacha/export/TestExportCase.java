package TestCase.kacha.export;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.box.SLOTWrongBook;
import com.mizholdings.kacha.mod.MODExport;
import com.mizholdings.kacha.mod.MODWrongBook;
import com.mizholdings.kacha.playload.PLExport;
import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.util.SampleAssert;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

@Feature("错题本测试")
public class TestExportCase {

    private KCParent parent;
    //    private SLOTWrongBook slotWrongBook;
    private MODExport modExport;
    private MODWrongBook modWrongBook;

    @BeforeClass(description = "初始化")
    public void beforeClass() {
        parent = GlobalKC.init().getParent();
//        slotWrongBook = new SLOTWrongBook(parent);
        modExport = new MODExport(parent);
        modWrongBook = new MODWrongBook(parent);
    }

    public String getUqldStr() {
        JSONObject object = modWrongBook.questions("10", GlobalKC.getChildId());
        SampleAssert.assertEquals("查询成功", object);

        List<String> list = object.getJSONObject("data").getJSONArray("list").stream().map(i -> {
            JSONObject o = (JSONObject) i;
            return o.getString("wrongId");
        }).collect(Collectors.toList());
        return String.join(",", list);
    }


    @Test(description = "6_1_1  学生错题导出")
    public void test6_1_1() {
        String uqldsStr = getUqldStr();
        JSONObject object1 = modExport.pdfMakestudentwb(uqldsStr, GlobalKC.getChildId());
        SampleAssert.assertResult("0", object1);
    }

    @Test(description = "6_1_2 一错一练选择错题导出")
    public void test6_1_2() {
        String uqldsStr = getUqldStr();
        JSONObject object = modExport.pdfMakeselectwb(uqldsStr, GlobalKC.getChildId(), GlobalKC.getClassId());
        SampleAssert.assertResult("0", object);
        SampleAssert.assertEquals("生成成功!", object);
    }

    @Test(description = "6_1_3 一错一练知识点错题导出")
    public void test6_1_3() {
        // TODO 知识点ID 获取
    }

    @Test(description = "6_1_4 按时间导出用户错题本")
    public void test6_1_4() {
        JSONObject object = modExport.pdfMakeuserdatewb(GlobalKC.getChildId(), "10");
        SampleAssert.assertResult("0", object);
    }

    @Test(description = "6_1_5 用户导出错题压缩包")
    public void test6_1_5() {
        JSONObject object = modExport.pdfExportstudentpdf(GlobalKC.getChildId(), "10");
        SampleAssert.assertResult("0", object);
    }

    @Test(description = "6_1_6 查询导出记录")
    public void test6_1_6() {
        // TODO 获取exportId
    }


}
