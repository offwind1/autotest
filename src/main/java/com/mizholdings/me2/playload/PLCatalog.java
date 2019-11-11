package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLCatalog extends PLJavaBean {

    private String catalogId;
    private String page;


    /**
     * 根据试题ID查询题目
     *
     * @param catalogId int,试题ID
     * @param page      int,页码，0表示不分页
     */
    public void setQuesbycatalogid(String catalogId, String page) {
        this.catalogId = catalogId;
        this.page = page;

    }


}