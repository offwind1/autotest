package com.mizholdings.kacha.mod;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.MODBase;
import com.mizholdings.kacha.user.KCUserBase;
import com.mizholdings.kacha.interfaces.WrongbookInterface;
import com.mizholdings.kacha.playload.PLWrongbook;
import com.mizholdings.util.PLJavaBean;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.Requests;
import io.qameta.allure.Step;
import lombok.Data;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public JSONObject questionSelector(Parameter parameter) {
        return exec("questionSelector", parameter);
    }

    public JSONObject questionSelector(String subjectId, String childId) {
        return exec("questionSelector", Parameter.creat()
                .add("subjectId", subjectId).add("childId", childId));
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

    @Step("查看错题列表")
    public JSONObject questions(Parameter parameter) {
        return exec("questions", parameter);
    }

    @Step("查看错题列表")
    public JSONObject questions(String subjectId, String childId) {
        return questions(Parameter.creat()
                .add("subjectId", subjectId).add("childId", childId)
                .add("page", "1").add("pageSize", "10"));
    }


    @Step("删除错题")
    public JSONObject delete(String childId, JSONObject question) {
        JSONObject object = new JSONObject();
        List<JSONObject> list = Arrays.asList(question);
        object.put("childId", childId);
        object.put("questions", list);

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), object.toJSONString());
        return Requests.getJson(wrongbookInterface.commit(executor.getToken(), body));
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

    public JSONObject questionDetail(Parameter parameter) {
        return exec("questionDetail", parameter);
    }

    public JSONObject questionDetail(String wrongId) {
        return questionDetail(Parameter.creat().add("wrongId", wrongId));
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

    public JSONObject pages(Parameter parameter) {
        return exec("pages", parameter);
    }

    public JSONObject pages(String subjectId, String childId) {
        return exec("pages", Parameter.creat()
                .add("subjectId", subjectId).add("childId", childId)
                .add("page", "1").add("pageSize", "100"));
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

    public JSONObject page(Parameter parameter) {
        return exec("page", parameter);
    }

    public JSONObject page(String url, String childId) {
        return page(Parameter.creat().add("url", url).add("childId", childId));
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
     * 提交错题，通过 上传页面返回的JsonObject
     *
     * @param object jsonObject
     * @return
     */
    public JSONObject commit(JSONObject object, String childId) {
        //提交错题
        String s = creat_wrongbook_data(object, childId);
        return commit(s);
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

    public JSONObject commitReport(Parameter parameter) {
        return exec("commitReport", parameter);
    }

    public JSONObject commitReport(String childId) {
        return commitReport(Parameter.creat().add("childId", childId));
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

    public JSONObject reportQuerychildreprotgz(Parameter parameter) {
        return exec("reportQuerychildreprotgz", parameter);
    }

    public JSONObject reportQuerychildreprotgz(String childId) {
        return reportQuerychildreprotgz(Parameter.creat().add("childId", childId));
    }


    public JSONObject dataExportPage(PLJavaBean javaBean) {
        return exec("dataExportPage", javaBean);
    }


    public String creat_wrongbook_data(JSONObject object, String childId) {
        String pageId = object.getJSONObject("data").getString("pageId");
        JSONArray array = object.getJSONObject("data").getJSONArray("questions");

        List<WrongQuestion> questions = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            JSONObject imagdata = array.getJSONObject(i)
                    .getJSONArray("areas")
                    .getJSONObject(0);

            WrongQuestion question = new WrongQuestion();
            question.setPage(pageId);
            question.setNum(String.valueOf(i));
            question.setX(imagdata.getString("x"));
            question.setY(imagdata.getString("y"));
            question.setY(imagdata.getString("y"));
            question.setWidth(imagdata.getString("width"));
            question.setHeight(imagdata.getString("height"));

            List<String> list = new ArrayList<>();
            list.add(imagdata.getString("imgUrl"));
            question.setQuestionUrls(list);
            question.setCollect("1");
            questions.add(question);
        }

        PageQuestion pageQuestion = new PageQuestion();
        pageQuestion.setPageId(pageId);
        pageQuestion.setQuestions(questions);

        List<PageQuestion> list = new ArrayList<>();
        list.add(pageQuestion);

        Commit commit = new Commit();
        commit.setPages(list);
        commit.setSubjectId("10");
        commit.setChildId(childId);

        return JSONObject.toJSONString(commit);
    }

}


@Data
class Commit {
    private List<com.mizholdings.kacha.mod.PageQuestion> pages;
    private String subjectId = "10";
    private String childId;
}

@Data
class PageQuestion {
    private String pageId;
    private List<com.mizholdings.kacha.mod.WrongQuestion> questions;
}

@Data
class WrongQuestion {
    private String page;
    private String num;
    private String x;
    private String y;
    private String width;
    private String height;
    private List<String> questionUrls;
    private String collect;
}