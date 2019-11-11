package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLUsrtag extends PLJavaBean {

    private String tagCount;
    private String tagIds;

    /**
     * 查询用户标签
     *
     * @param tagCount int,要查询的标签数量，（选填，默认前5个）
     */
    public void setList(String tagCount) {
        this.tagCount = tagCount;

    }


    /**
     * 添加用户标签
     *
     * @param tagIds string,多个标签ID集合，逗号分隔
     */
    public void setAddusrtag(String tagIds) {
        this.tagIds = tagIds;

    }


}