package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLAdvert extends PLJavaBean {

    private String advertName;
    private String cityName;
    private String advertSrc;
    private String useTime;
    private String currentPage;
    private String pageSize;

    /**
     * 广告列表
     *
     * @param advertName  string,广告名称
     * @param cityName    string,作用城市名称
     * @param advertSrc   string,广告转到URL
     * @param useTime     string,作用时间
     * @param currentPage int,当前页数
     * @param pageSize    int,每页页数
     */
    public void setList(String advertName, String cityName, String advertSrc, String useTime, String currentPage, String pageSize) {
        this.advertName = advertName;
        this.cityName = cityName;
        this.advertSrc = advertSrc;
        this.useTime = useTime;
        this.currentPage = currentPage;
        this.pageSize = pageSize;

    }


    private String advertImg;
    private String advertOrdery;
    private String startTime;
    private String endTime;
    private String advertTag;
    private String remark;
    private String comIds;
    private String advertType;
    private String srcType;

    /**
     * 添加广告
     *
     * @param advertName   string,广告名称
     * @param advertImg    string,封面图
     * @param advertSrc    string,广告转到URL
     * @param advertOrdery int,排序
     * @param startTime    string,广告开始时间
     * @param endTime      string,广告结束时间
     * @param advertTag    string,标签，用“，”分割
     * @param remark       string,说明
     * @param comIds       string,作用城市ID，用“，”分割
     * @param advertType   int 广告类型1横幅广告2弹窗广告
     * @param srcType      int 跳转类型 0链接 1推荐 2机构用户3名师4课程5课件资源6课堂
     */
    public void setAdd(String advertName, String advertImg, String advertSrc, String advertOrdery, String startTime, String endTime, String advertTag, String remark, String comIds, String advertType, String srcType) {
        this.advertName = advertName;
        this.advertImg = advertImg;
        this.advertSrc = advertSrc;
        this.advertOrdery = advertOrdery;
        this.startTime = startTime;
        this.endTime = endTime;
        this.advertTag = advertTag;
        this.remark = remark;
        this.comIds = comIds;
        this.advertType = advertType;
        this.srcType = srcType;

    }

    private String advertId;

    /**
     * 根据ID拿到广告详情
     *
     * @param advertId string,广告ID
     */
    public void setGetadvertbyid(String advertId) {
        this.advertId = advertId;

    }


    /**
     * 广告编辑
     *
     * @param advertId     string,广告ID
     * @param advertName   string,广告名称
     * @param advertImg    string,封面图
     * @param advertSrc    string,广告转到URL
     * @param advertOrdery int,排序
     * @param startTime    string,广告开始时间
     * @param endTime      string,广告结束时间
     * @param advertTag    string,标签，用“，”分割
     * @param remark       string,说明
     * @param comIds       string,作用城市ID，用“，”分割
     */
    public void setEdit(String advertId, String advertName, String advertImg, String advertSrc, String advertOrdery, String startTime, String endTime, String advertTag, String remark, String comIds) {
        this.advertId = advertId;
        this.advertName = advertName;
        this.advertImg = advertImg;
        this.advertSrc = advertSrc;
        this.advertOrdery = advertOrdery;
        this.startTime = startTime;
        this.endTime = endTime;
        this.advertTag = advertTag;
        this.remark = remark;
        this.comIds = comIds;

    }


    /**
     * 删除广告
     *
     * @param advertId string,广告ID
     */
    public void setDel(String advertId) {
        this.advertId = advertId;

    }


}