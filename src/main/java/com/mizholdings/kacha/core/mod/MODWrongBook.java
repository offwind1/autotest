package com.mizholdings.kacha.core.mod;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.kacha.core.user.KCUserBase;
import com.mizholdings.kacha.interfaces.WrongbookInterface;
import com.mizholdings.kacha.playload.PLWrongbook;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Requests;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class MODWrongBook extends MODBase<MODWrongBook> {

    public static WrongbookInterface wrongbookInterface = Requests.getService(WrongbookInterface.class);

    public MODWrongBook(KCUserBase executor) {
        super(executor);
        this.interfaced = wrongbookInterface;
    }


    /**
     * 11.1.1 题目学科选择器
     *
     * @param wrongbook
     * @return
     */
    public JSONObject questionSelector(PLWrongbook wrongbook) {
        return exec("questionSelector", wrongbook);
    }

    /**
     * 11.1.2 查看错题列表
     *
     * @param wrongbook
     * @return
     */
    @Step("查看错题列表")
    public JSONObject questions(PLWrongbook wrongbook) {
        return exec("questions", wrongbook);
    }


    /**
     * 11.1.4 查看错题详情
     *
     * @param wrongbook
     * @return
     */
    public JSONObject questionDetail(PLWrongbook wrongbook) {
        return exec("questionDetail", wrongbook);
    }


    /**
     * 11.1.5 题目匹配错误反馈
     *
     * @param wrongbook
     * @return
     */
    public JSONObject questionFeedback(PLWrongbook wrongbook) {
        return exec("questionFeedback", wrongbook);
    }


    /**
     * 11.1.6 查看页面列表
     *
     * @param wrongbook
     * @return
     */
    public JSONObject pages(PLWrongbook wrongbook) {
        return exec("pages", wrongbook);
    }


    /**
     * 11.1.7 学生掌握状态
     *
     * @param wrongbook
     * @return
     */
    public JSONObject questionGrasp(PLWrongbook wrongbook) {
        return exec("questionGrasp", wrongbook);
    }


    /**
     * 11.2.1上传页面
     *
     * @param wrongbook
     * @return
     */
    public JSONObject page(PLWrongbook wrongbook) {
        return exec("page", wrongbook);
    }


    /**
     * 11.2.2 提交错题
     *
     * @return
     */
    public JSONObject commit(String jsonData) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonData);
        return Requests.getJson(wrongbookInterface.commit(executor.getToken(), body));
    }


    /**
     * 11.2.3提交报告
     *
     * @param wrongbook
     * @return
     */
    public JSONObject commitReport(PLWrongbook wrongbook) {
        return exec("commitReport", wrongbook);
    }


    /**
     * 11.3.3 作业报告
     *
     * @param wrongbook
     * @return
     */
    public JSONObject reportQuerychildreprotgz(PLWrongbook wrongbook) {
        return exec("reportQuerychildreprotgz", wrongbook);
    }

    public JSONObject dataExportPage(PLJavaBean javaBean) {
        return exec("dataExportPage", javaBean);
    }

}
