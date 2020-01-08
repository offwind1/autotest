package com.mizholdings.me2.agent.manage;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.me2.Global;
import com.mizholdings.util.Common;
import com.mizholdings.util.MODBase;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.User;
import io.qameta.allure.Step;

public class AdvertAgent extends MODBase<ChanAdvAgent> {
    //    public static AdvertInterface advertInterface = Requests.getService(AdvertInterface.class);
    public AdvertAgent(User executor) {
        super(executor);
//        interfaced = advertInterface;
    }

    /**
     * startTime:
     * endTime:
     * comIds:
     * currentPage: 1
     * pageSize: 10
     *
     * @return
     */
    @Step("广告列表advert/list")
    public JSONObject list(String startTime, String endTime, String comIds) {
        return exec("list", Parameter.creat()
                .add("startTime", startTime)
                .add("endTime", endTime)
                .add("comIds", comIds)
                .add("currentPage", "1")
                .add("pageSize", "10")
        );
    }

    public JSONObject list() {
        return list("", "", "");
    }


    public enum ADVERT_TYPE {
        HENG_FU("1", "横幅广告"),
        TAN_CHUANG("2", "弹窗广告");

        public String value;
        public String name;

        private ADVERT_TYPE(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }

    public enum SRC_TYPE {
        LINK("0", "连接"),
        RECOMMEND("1", "推荐"),
        JIGOU("2", "机构用户"),
        TEACHER("3", "名师"),
        LESSON("4", "课程"),
        COURSE("5", "课件资源"),
        CLASSROOM("6", "课堂"),
        ;
        public String value;
        public String name;

        private SRC_TYPE(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }

    /**
     * @return
     */
    @Step("添加广告advert/add")
    public JSONObject add(String advertImg, String advertSrc, String remark, ADVERT_TYPE advert_type, SRC_TYPE src_type, String orgId) {
        return exec("add", Parameter.creat()
                .add("advertImg", advertImg)
                .add("advertSrc", advertSrc)
                .add("advertOrdery", "1")
                .add("startTime", Common.getNowTime())
                .add("endTime", Common.getEndTime(1))
                .add("remark", remark)
                .add("comIds", "1")
                .add("advertType", advert_type.value)
                .add("srcType", src_type.value)
                .add("orgId", orgId)

        );
    }

    public JSONObject add(String remark) {
        return add(Global.getImageUrl(), "https://www.baidu.com", remark, ADVERT_TYPE.HENG_FU, SRC_TYPE.LINK, "0");
    }

    public JSONObject add(String remark, String orgId) {
        return add(Global.getImageUrl(), "https://www.baidu.com", remark, ADVERT_TYPE.HENG_FU, SRC_TYPE.LINK, orgId);
    }

    @Step("根据ID拿到广告详情advert/getAdvertById")
    public JSONObject getAdvertById(String advertId) {
        return exec("getAdvertById", Parameter.creat().add("advertId", advertId));
    }

    @Step("广告编辑advert/edit")
    public JSONObject edit(String advertId, String advertImg, String advertSrc, String remark, ADVERT_TYPE advert_type, SRC_TYPE src_type) {
        return exec("edit", Parameter.creat()
                .add("advertId", advertId)
                .add("advertImg", advertImg)
                .add("advertSrc", advertSrc)
                .add("advertOrdery", "1")
                .add("startTime", Common.getNowTime())
                .add("endTime", Common.getEndTime(1))
                .add("remark", remark)
                .add("comIds", "1")
                .add("advertType", advert_type.value)
                .add("srcType", src_type.value)
        );
    }

    public JSONObject edit(String advertId, String remark) {
        return edit(advertId, Global.getImageUrl(), "https://www.baidu.com", remark, ADVERT_TYPE.HENG_FU, SRC_TYPE.LINK);
    }


    @Step("删除广告advert/del")
    public JSONObject del(String advertId) {
        return exec("del", Parameter.creat().add("advertId", advertId));
    }


    /**
     * 广告列表
     *
     * @return json
     */
    @Step("广告列表")
    public JSONObject list(Parameter parameter) {
        return exec("list", parameter);
    }

    /**
     * 添加广告
     *
     * @return json
     */
    @Step("添加广告")
    public JSONObject add(Parameter parameter) {
        return exec("add", parameter);
    }

    /**
     * 根据ID拿到广告详情
     *
     * @return json
     */
    @Step("根据ID拿到广告详情")
    public JSONObject getAdvertById(Parameter parameter) {
        return exec("getAdvertById", parameter);
    }

    /**
     * 广告编辑
     *
     * @return json
     */
    @Step("广告编辑")
    public JSONObject edit(Parameter parameter) {
        return exec("edit", parameter);
    }

    /**
     * 删除广告
     *
     * @return json
     */
    @Step("删除广告")
    public JSONObject del(Parameter parameter) {
        return exec("del", parameter);
    }


}