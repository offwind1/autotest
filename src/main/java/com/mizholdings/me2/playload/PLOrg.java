package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLOrg extends PLJavaBean {

    private String provinceId;
    private String cityId;
    private String longitude;
    private String latitude;
    private String orgName;
    private String page;

    /**
     * 查询机构/学校列表
     *
     * @param provinceId int,省份ID（选填）
     * @param cityId     int,地市ID（选填）
     * @param longitude  string,经度（选填）
     * @param latitude   string,纬度（选填）
     * @param orgName    string,机构名称
     * @param page       int,页码，不分页传入0
     */
    public void setList(String provinceId, String cityId, String longitude, String latitude, String orgName, String page) {
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.orgName = orgName;
        this.page = page;

    }

    private String orgId;
    private String userId;

    /**
     * 获取机构新闻
     *
     * @param orgId  int,机构ID
     * @param page   int,页码
     * @param userId long,机构用户ID
     */
    public void setMsglist(String orgId, String page, String userId) {
        this.orgId = orgId;
        this.page = page;
        this.userId = userId;

    }

    private String msgId;

    /**
     * 新闻详情
     *
     * @param msgId string,新闻ID
     */
    public void setMsginfo(String msgId) {
        this.msgId = msgId;

    }

    private String orgUserId;

    /**
     * 用户同意加入机构
     *
     * @param orgUserId long,机构用户ID
     */
    public void setJoinorg(String orgUserId) {
        this.orgUserId = orgUserId;

    }

    private String orgImg;
    private String address;
    private String remark;

    /**
     * 添加机构
     *
     * @param orgName    string,机构名称
     * @param orgImg     string,机构封面URL
     * @param provinceId int,省份ID
     * @param cityId     int,地市ID
     * @param address    string,地址详情
     * @param longitude  double,经度
     * @param latitude   double,纬度
     * @param remark     String,备注
     */
    public void setCreate(String orgName, String orgImg, String provinceId, String cityId, String address, String longitude, String latitude, String remark) {
        this.orgName = orgName;
        this.orgImg = orgImg;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.remark = remark;

    }


    /**
     * 已经加入的机构列表
     *
     * @param page int,页码，不分页传入0
     */
    public void setJoinlist(String page) {
        this.page = page;

    }


    private String relId;

    /**
     * 退出机构
     *
     * @param relId string,用户机构关系ID,逗号分隔
     */
    public void setRemoveorg(String relId) {
        this.relId = relId;

    }


    /**
     * 禁止添加
     *
     * @param relId int,用户机构ID
     */
    public void setDisabled(String relId) {
        this.relId = relId;

    }


}