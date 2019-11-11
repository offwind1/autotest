package com.mizholdings.me2.core;

import com.mizholdings.me2.core.user.Me2Student;
import com.mizholdings.me2.core.user.Me2Teacher;
import com.mizholdings.util.Requests;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalMe2 {
    private static GlobalMe2 global;
    public Properties properties;
    private final static Log logger = LogFactory.getLog(Requests.class);

    private Me2Teacher teacher;
    private Me2Student student;


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

    public Me2Student getStudent() {
        if (student == null) {
            String account = properties.getProperty("me2.student.account");
            String password = properties.getProperty("me2.student.password");
            student = new Me2Student(account, password);
        }
        return student;
    }


}
