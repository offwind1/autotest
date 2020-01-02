package com.mizholdings.me2;

import com.mizholdings.me2.user.Jigou;
import com.mizholdings.me2.user.SuperAdmin;
import com.mizholdings.me2.user.Teacher;
import com.mizholdings.me2.user.UserBase;
import com.mizholdings.util.Requests;
import com.mizholdings.util.XmlTool.ElementMine;
import com.mizholdings.util.XmlTool.XmlTool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.*;

public class Global {
    private static Global global;
    public Properties properties;
    private final static Log logger = LogFactory.getLog(Requests.class);

    private Teacher teacher;
    private SuperAdmin superAdmin;
    private Jigou fb_Jigou;
    private Jigou op_Jigou;
    private UserBase userBase;

    private static Map<String, ElementMine> map = new HashMap<>();

    public static Global init() {
        if (global == null) {
            global = new Global();
        }
        return global;
    }

    public static ElementMine getServe(String serve) {
        if (map.containsKey(serve)) {
            return map.get(serve);
        } else {
            ElementMine elementMine = XmlTool.readXML(String.format("serve/%s.xml", serve));
            map.put(serve, elementMine);
            return elementMine;
        }
    }

    private Global() {
        InputStream stream = Requests.class.getClassLoader().getResourceAsStream("testConfig.properties");
        properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    public static String getProperties(String key) {
        return init().properties.getProperty(key);
    }


    public static List<String> getUserIds(int num) {
        InputStream stream = Requests.class.getClassLoader().getResourceAsStream("userIds");
        Reader reader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        List<String> strings = new ArrayList<>();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.shuffle(strings);
        return strings.subList(0, num < strings.size() ? num : strings.size());
    }


    public Teacher getTeacher() {
        if (teacher == null) {
            String account = properties.getProperty("me2.teacher.account");
            String password = properties.getProperty("me2.teacher.password");
            teacher = new Teacher(account, password);
        }
        return teacher;
    }


    public static String getFengBiOrgId() {
        return init().properties.getProperty("me2.jigou.fengbi.orgId");
    }

    public static String getFengBiAppname() {
        return init().properties.getProperty("me2.jigou.fengbi.appname");
    }


    public Jigou getFengBiJigou() {
        if (fb_Jigou == null) {
            String account = properties.getProperty("me2.jigou.fengbi.jigou.account");
            String password = properties.getProperty("me2.jigou.fengbi.jigou.password");
            fb_Jigou = new Jigou(account, password);
        }
        return fb_Jigou;
    }

    public Jigou getOpenBiJigou() {
        if (op_Jigou == null) {
            String account = properties.getProperty("me2.jigou.open.jigou.account");
            String password = properties.getProperty("me2.jigou.open.jigou.password");
            op_Jigou = new Jigou(account, password);
        }
        return op_Jigou;
    }


    public UserBase getUser() {
        if (userBase == null) {
            String account = properties.getProperty("me2.student.account");
            String password = properties.getProperty("me2.student.password");
            userBase = new UserBase(account, password, "app");
        }
        return userBase;
    }

    public String getAccount() {
        return String.format(properties.getProperty("me2.student.account.format"),
                new Random().nextInt(200) + 1);
    }

    public String getPassword() {
        return properties.getProperty("me2.student.password.format");
    }

    public UserBase getUserBase() {
        return new UserBase(getAccount(), getPassword(), "app");
    }

    public Teacher getRandomTeacher() {
        return new Teacher(getAccount(), getPassword());
    }

//    public static SuperAdmin getSuperAdmin() {
//        return init()._getSuperAdmin();
//    }

    public SuperAdmin getSuperAdmin() {
        if (superAdmin == null) {
            String account = properties.getProperty("me2.superAdmin.account");
            String password = properties.getProperty("me2.superAdmin.password");
            superAdmin = new SuperAdmin(account, password);
        }
        return superAdmin;
    }

    public static String getImageUrl() {
        return init().properties.getProperty("me2.imageUrl");
    }

    public static String getVideoPath() {
        return init().properties.getProperty("me2.videoPath");
    }

}
