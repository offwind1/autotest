package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.agent.web.AdvertAgent;
import com.mizholdings.me2.user.serve.ServeBase;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class TopAgent extends MODBase<TopAgent> {
//    public static TopInterface topInterface = Requests.getService(TopInterface.class);

    public TopAgent(User executor) {
        super(executor);
//        interfaced = topInterface;
    }


    /**
     * 主页轮播广告
     *
     * @param src_type it 链接类型 0链接 1推荐 2机构用户3名师4课程5课件资源6课堂
     * @return
     */
    public JSONObject advertList(AdvertAgent.SRC_TYPE src_type) {
        return exec("advertList", Parameter.creat().add("type", src_type.value)
        );
    }


    /**
     * 机构新闻更多
     *
     * @return
     */
    public JSONObject v2OrgMsgList() {
        return exec("v2OrgMsgList", Parameter.creat()
                .add("page", "1"));
    }

    public JSONObject v2topList(ServeBase.GRADEID gradeid, MADE_TYPE made_type) {
        return exec("v2topList", Parameter.creat()
                .add("gradeId", gradeid.value)
                .add("madeType", made_type.value));
    }

    public JSONObject v2topList(ServeBase.GRADEID gradeid) {
        return v2topList(gradeid, MADE_TYPE.NO_IN_JIGOU);
    }


    public enum MADE_TYPE {
        NO_IN_JIGOU("1", "非定制"),
        IN_JIGOU("2", "机构定制"),
        ;
        public String value;
        public String name;

        private MADE_TYPE(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }


    /**
     * 主页轮播广告
     *
     * @return json
     */
    @Step("主页轮播广告")
    public JSONObject advertList(Parameter parameter) {
        return exec("advertList", parameter);
    }

    /**
     * 学科列表
     *
     * @return json
     */
    @Step("学科列表")
    public JSONObject usrMenu(Parameter parameter) {
        return exec("usrMenu", parameter);
    }

    /**
     * 查询主页列表项
     *
     * @return json
     */
    @Step("查询主页列表项")
    public JSONObject topList(Parameter parameter) {
        return exec("topList", parameter);
    }

    /**
     * 主页，加载更多
     *
     * @return json
     */
    @Step("主页，加载更多")
    public JSONObject topMore(Parameter parameter) {
        return exec("topMore", parameter);
    }

    /**
     * 选课中心主页
     *
     * @return json
     */
    @Step("选课中心主页")
    public JSONObject chooseList(Parameter parameter) {
        return exec("chooseList", parameter);
    }

    /**
     * 导引页接口
     *
     * @return json
     */
    @Step("导引页接口")
    public JSONObject bootpage(Parameter parameter) {
        return exec("bootpage", parameter);
    }

    /**
     * 资源库主页
     *
     * @return json
     */
    @Step("资源库主页")
    public JSONObject coursList(Parameter parameter) {
        return exec("coursList", parameter);
    }

    /**
     * 选课中心，加载更多
     *
     * @return json
     */
    @Step("选课中心，加载更多")
    public JSONObject chooseMore(Parameter parameter) {
        return exec("chooseMore", parameter);
    }

    /**
     * 资源库，加载更多
     *
     * @return json
     */
    @Step("资源库，加载更多")
    public JSONObject coursMore(Parameter parameter) {
        return exec("coursMore", parameter);
    }

    /**
     * 查询直播课
     *
     * @return json
     */
    @Step("查询直播课")
    public JSONObject playLesson(Parameter parameter) {
        return exec("playLesson", parameter);
    }

    /**
     * 最近将要直播的10堂课
     *
     * @return json
     */
    @Step("最近将要直播的10堂课")
    public JSONObject minTimeLesson(Parameter parameter) {
        return exec("minTimeLesson", parameter);
    }

    /**
     * 搜索推荐
     *
     * @return json
     */
    @Step("搜索推荐")
    public JSONObject getSearchCem(Parameter parameter) {
        return exec("getSearchCem", parameter);
    }

}