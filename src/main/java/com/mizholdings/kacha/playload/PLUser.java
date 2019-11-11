package com.mizholdings.kacha.playload;


import com.mizholdings.util.PLJavaBean;
import lombok.Data;

@Data
public class PLUser extends PLJavaBean {
    private String name;
    private String nickname;
    private String avatarUrl;
    private String phone;
    private String phoneNumber;
}
