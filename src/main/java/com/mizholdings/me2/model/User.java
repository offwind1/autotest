package com.mizholdings.me2.model;

import lombok.Data;

@Data
public class User {
    private String token;
    private String userId;
    private int orgId;
}
