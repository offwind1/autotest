package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLUsrcoll extends PLJavaBean {

    private String collectionName;
    private String page;
    private String collectionType;

    /**
     * 用户收藏列表
     *
     * @param collectionName string,收藏名称，用于模糊搜索
     * @param page           int,页码
     * @param collectionType int,类型，1用户，2课程，3课件资源,4机构
     */
    public void setList(String collectionName, String page, String collectionType) {
        this.collectionName = collectionName;
        this.page = page;
        this.collectionType = collectionType;

    }


}