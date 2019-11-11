package com.mizholdings.kacha.playload;

import com.mizholdings.util.PLJavaBean;

public class PLWpa extends PLJavaBean {

    private String childId;

    /**
     * 17.1.1 查询关注班级事件
     *
     * @param *childId：子女ID
     */
    public void setMappScanClass(String childId) {
        this.childId = childId;

    }

    private String scanId;

    /**
     * 17.1.2 消费关注班级事件
     *
     * @param scanId：int
     */
    public void setMappScanConsume(String scanId) {
        this.scanId = scanId;

    }

    private String classId;

    /**
     * 17.1.3 微信公众号班级二维码
     *
     * @param *classId: 班级Id
     */
    public void setWeixinWxcode(String classId) {
        this.classId = classId;

    }


}
