package com.mizholdings.kacha;

import com.mizholdings.kacha.user.KCParent;
import com.mizholdings.kacha.user.KCSuperAdmin;
import com.mizholdings.kacha.user.KCTeacher;
import com.mizholdings.util.Requests;
import com.mizholdings.util.Warehouse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;

public class GlobalKC {
    private static GlobalKC global;
    public static String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

    public Properties properties;
    private final static Log logger = LogFactory.getLog(Requests.class);
    private KCSuperAdmin surpeAdmin;
    private KCTeacher teacher;
    private KCParent parent;

    private String schoolId;
    private String classId;
    private String childId;

    private Warehouse warehouse;

    public static GlobalKC init() {
        if (global == null) {
            global = new GlobalKC();
        }
        return global;
    }

    private GlobalKC() {
        InputStream stream = Requests.class.getClassLoader().getResourceAsStream("testConfig.properties");
        properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
        schoolId = properties.getProperty("kacha.schoolId");
        classId = properties.getProperty("kacha.classId");
        childId = properties.getProperty("kacha.childId");

        warehouse = new Warehouse(this);
    }

    public KCParent getNewParent() {
        KCParent parent = new KCParent(warehouse.getParent(), "111111");
        parent.deleteAllChilds();
        return parent;
    }

    public String getNewSchool() {
        return warehouse.getSchool();
    }

    public KCSuperAdmin getSuperAdmin() {
        if (surpeAdmin == null) {
            String account = properties.getProperty("kacha.superAdmin.account");
            String password = properties.getProperty("kacha.superAdmin.password");
            surpeAdmin = new KCSuperAdmin(account, password);
        }
        return surpeAdmin;
    }

    public KCTeacher getTeacher() {
        if (teacher == null) {
            String account = properties.getProperty("kacha.teacher.account");
            String password = properties.getProperty("kacha.teacher.password");
            teacher = new KCTeacher(account, password);
        }
        return teacher;
    }

    public KCParent getParent() {
        if (parent == null) {
            String account = properties.getProperty("kacha.parent.account");
            String password = properties.getProperty("kacha.parent.password");
            parent = new KCParent(account, password);
        }
        return parent;
    }

    public static String getSchoolId() {
        return init().schoolId;
    }

    public static String getClassId() {

        return init().classId;
    }

    public static String getChildId() {
        return init().childId;
    }

    public static String getImageUrl() {
        return init().properties.getProperty("kacha.page.url");
    }

    public void teardown() {
        warehouse.teardown();
    }

}