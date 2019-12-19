package com.mizholdings.me2.agent.app;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.*;
import io.qameta.allure.Step;

public class CourseAgent extends MODBase<CourseAgent> {
    public CourseAgent(User executor) {
        super(executor);
    }

    /**
     * 资源详情
     *
     * @param coursewareId 资源ID
     * @return
     */
    @Step("资源详情")
    public JSONObject coursewareInfo(String coursewareId) {
        return exec("coursewareInfo", Parameter.creat().add("coursewareId", coursewareId));
    }

    /**
     * 上传图片文件
     *
     * @param sourceUrl 资源地址
     * @return
     */
    @Step("上传图片文件")
    public JSONObject uploadFile(String sourceUrl) {
        return exec("uploadFile", Parameter.creat()
                .add("coursewareType", "7")
                .add("sourceUrl", sourceUrl)
                .add("faceImg", "http://images.mizholdings.com/DPMIt6inrH3L~w9g.png"));
    }

    /**
     * 创建默认图片课件
     *
     * @return 课件ID
     */
    public JSONObject uploadFile() {
        return uploadFile("http://images.mizholdings.com/4za05KCt1IHwCk~B.png");
    }


    /**
     * 资源列表
     *
     * @return json
     */
    @Step("资源列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 资源详情
     *
     * @return json
     */
    @Step("资源详情")
    public JSONObject coursewareInfo(Parameter parameter) {
        return exec("coursewareInfo", parameter);
    }

    /**
     * 资源筛选条件
     *
     * @return json
     */
    @Step("资源筛选条件")
    public JSONObject screen(Parameter parameter) {
        return exec("screen", parameter);
    }

    /**
     * 获得资源评论列表
     *
     * @return json
     */
    @Step("获得资源评论列表")
    public JSONObject courseScore(Parameter parameter) {
        return exec("courseScore", parameter);
    }

    /**
     * 资源评论
     *
     * @return json
     */
    @Step("资源评论")
    public JSONObject score(Parameter parameter) {
        return exec("score", parameter);
    }

    /**
     * 点赞资源
     *
     * @return json
     */
    @Step("点赞资源")
    public JSONObject likedCourse(Parameter parameter) {
        return exec("likedCourse", parameter);
    }

    /**
     * 取消点赞
     *
     * @return json
     */
    @Step("取消点赞")
    public JSONObject rmlikedCourse(Parameter parameter) {
        return exec("rmlikedCourse", parameter);
    }

    /**
     * 收藏资源
     *
     * @return json
     */
    @Step("收藏资源")
    public JSONObject keepCourse(Parameter parameter) {
        return exec("keepCourse", parameter);
    }

    /**
     * 取消收藏
     *
     * @return json
     */
    @Step("取消收藏")
    public JSONObject rmkeepCourse(Parameter parameter) {
        return exec("rmkeepCourse", parameter);
    }

    /**
     * 相关推荐
     *
     * @return json
     */
    @Step("相关推荐")
    public JSONObject relatedList(Parameter parameter) {
        return exec("relatedList", parameter);
    }

    /**
     * 我的资源
     *
     * @return json
     */
    @Step("我的资源")
    public JSONObject mylist(Parameter parameter) {
        return exec("mylist", parameter);
    }

    /**
     * 课堂中，更换课件时，课件详情
     *
     * @return json
     */
    @Step("课堂中，更换课件时，课件详情")
    public JSONObject infoByClassroom(Parameter parameter) {
        return exec("infoByClassroom", parameter);
    }

    /**
     * 单纯查询子资源列表
     *
     * @return json
     */
    @Step("单纯查询子资源列表")
    public JSONObject childList(Parameter parameter) {
        return exec("childList", parameter);
    }

    /**
     * 上传ppt
     *
     * @return json
     */
    @Step("上传ppt")
    public JSONObject uploadPpt(Parameter parameter) {
        return exec("uploadPpt", parameter);
    }

    /**
     * 我创建的资源列表
     *
     * @return json
     */
    @Step("我创建的资源列表")
    public JSONObject myCreate(Parameter parameter) {
        return exec("myCreate", parameter);
    }

    /**
     * 查询我购买的资源列表
     *
     * @return json
     */
    @Step("查询我购买的资源列表")
    public JSONObject myBuy(Parameter parameter) {
        return exec("myBuy", parameter);
    }

    /**
     * 上传图片文件
     *
     * @return json
     */
    @Step("上传图片文件")
    public JSONObject uploadFile(Parameter parameter) {
        return exec("uploadFile", parameter);
    }

    /**
     * 我的资源PC
     *
     * @return json
     */
    @Step("我的资源PC")
    public JSONObject myBuyPC(Parameter parameter) {
        return exec("myBuyPC", parameter);
    }


}