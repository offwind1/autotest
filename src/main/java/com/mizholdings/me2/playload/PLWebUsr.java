package com.mizholdings.me2.playload;

import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLWebUsr extends PLJavaBean {
    private String nickname;


    /**
     * 修改用户名
     *
     * @param nickname
     */
    public void setEditNickName(String nickname) {
        this.nickname = nickname;
    }


}
