package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLHeadimg extends PLJavaBean {
    private String ownId;

    /**
     * 头像列表
     *
     * @param ownId int,头像所属（选填）
     */
    public void setList(String ownId) {
        this.ownId = ownId;

    }


}