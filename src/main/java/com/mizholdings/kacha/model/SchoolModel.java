package com.mizholdings.kacha.model;

import lombok.Data;

@Data
public class SchoolModel {
    private String schoolId;
    private String schoolName;
    private String effStart;
    private String effEnd;
    private String province = "E";
    private String city = "E";
    private String area = "E";
    private String address;
    private String masterName;
    private String phone;
    private String des;
    private String phaseId;     //学段ID 1-小学 2-初中 3-高中 4-全学段
    private String upperLimit;  //累积使用人上限
    private String schoolType;  //0-学校(默认)  1-机构
    private String managerNames = "";    //校管姓名集合（注意和校管电话一一对应）
    private String managerPhones = "";   //校管电话集合
}
