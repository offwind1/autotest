package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLHeart extends PLJavaBean {
    private String ismaster;
    private String classroomId;
    private String platform;

    /**
     * 课堂心跳
     *
     * @param ismaster    int,是否聊天室创建者,1是创建者，其他不是
     * @param classroomId string,课堂ID
     * @param platform    来源，1苹果，2安卓，3电脑端
     */
    public void setClassroom(String ismaster, String classroomId, String platform) {
        this.ismaster = ismaster;
        this.classroomId = classroomId;
        this.platform = platform;

    }


}