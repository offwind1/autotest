package com.mizholdings.me2;

import com.mizholdings.me2.user.Me2Jigou;
import com.mizholdings.me2.user.Me2SuperAdmin;
import com.mizholdings.me2.user.Me2Teacher;
import com.mizholdings.me2.user.Me2UserBase;
import com.mizholdings.util.Requests;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

public class GlobalMe2 {
    private static GlobalMe2 global;
    public Properties properties;
    private final static Log logger = LogFactory.getLog(Requests.class);

    private Me2Teacher teacher;
    private Me2SuperAdmin superAdmin;
    private Me2Jigou fb_me2Jigou;
    private Me2UserBase userBase;

    public static GlobalMe2 init() {
        if (global == null) {
            global = new GlobalMe2();
        }
        return global;
    }

    private GlobalMe2() {
        InputStream stream = Requests.class.getClassLoader().getResourceAsStream("testConfig.properties");
        properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    public Me2Teacher getTeacher() {
        if (teacher == null) {
            String account = properties.getProperty("me2.teacher.account");
            String password = properties.getProperty("me2.teacher.password");
            teacher = new Me2Teacher(account, password);
        }
        return teacher;
    }


    public static String getFengBiOrgId() {
        return init().properties.getProperty("me2.jigou.fengbi.orgId");
    }

    public static String getFengBiAppname() {
        return init().properties.getProperty("me2.jigou.fengbi.appname");
    }


    public Me2Jigou getFengBiJigou() {
        if (fb_me2Jigou == null) {
            String account = properties.getProperty("me2.jigou.fengbi.jigou.account");
            String password = properties.getProperty("me2.jigou.fengbi.jigou.password");
            fb_me2Jigou = new Me2Jigou(account, password);
        }
        return fb_me2Jigou;
    }

    public Me2UserBase getUser() {
        if (userBase == null) {
            String account = properties.getProperty("me2.student.account");
            String password = properties.getProperty("me2.student.password");
            userBase = new Me2UserBase(account, password, "app");
        }
        return userBase;
    }

    public Me2UserBase getUserBase() {
        String format = properties.getProperty("me2.student.account.format");
        String account = String.format(format, new Random().nextInt(1000));
        String password = properties.getProperty("me2.student.password.format");
        return new Me2UserBase(account, password, "app");
    }


    public Me2SuperAdmin getSuperAdmin() {
        if (superAdmin == null) {
            String account = properties.getProperty("me2.superAdmin.account");
            String password = properties.getProperty("me2.superAdmin.password");
            superAdmin = new Me2SuperAdmin(account, password);
        }
        return superAdmin;
    }

    public static String getImageUrl() {
        return init().properties.getProperty("me2.imageUrl");
    }

}
