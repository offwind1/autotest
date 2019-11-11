package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLCompartment extends PLJavaBean {

    private String pid;

    /**
     * 查询省市列表
     *
     * @param pid int,上一级ID，没有则传入0
     */
    public void setList(String pid) {
        this.pid = pid;

    }


}