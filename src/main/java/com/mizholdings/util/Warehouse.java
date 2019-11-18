package com.mizholdings.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.mizholdings.kacha.GlobalKC;
import com.mizholdings.kacha.mod.MODSchool;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Warehouse {
    GlobalKC global;
    MODSchool modSchool;
    private static final String JSON_FILE_NAME = "data.json";
    private static final String KEY_PARENTS = "parents";
    private static final String KEY_SCHOOLS = "schools";
    private static final String SCHOOL_NAME = "自动生成的学校";
    private static final int MAX_COUNT = 1;

    Queue<String> parents = new LinkedList<>();
    Queue<String> schools = new LinkedList<>();
    public List<String> dust_schools = new ArrayList<>();


    public Warehouse(GlobalKC global) {
        this.global = global;
        modSchool = new MODSchool(global.getSuperAdmin());

        JSONObject object = readJson();
        initParents(object);
        initSchools(object);
    }

    private void initSchools(JSONObject object) {
        List<String> list = object.getJSONArray(KEY_SCHOOLS).toJavaList(String.class);
        for (String s : list) {
            schools.add(s);
        }

        if (schools.size() < MAX_COUNT) {
            replenishSchool();
        }
    }

    private void replenishSchool() {
        while (schools.size() < MAX_COUNT) {
            schools.add(creatSchool());
        }
    }

    public String getSchool() {
        if (schools.size() < MAX_COUNT) {
            replenishSchool();
        }
        String schoolId = schools.remove();
        dust_schools.add(schoolId);
        return schoolId;
    }

    private String creatSchool() {
        JSONObject object = modSchool.schoolManageCreateNorm(SCHOOL_NAME);
        SampleAssert.assertResult("0", object);
        return object.getJSONObject("data").getString("schoolId");
    }

    private void deleteSchool(String schoolId) {
        JSONObject object = modSchool.schoolManageDelete(schoolId);
        SampleAssert.assertResult("0", object);
    }

    private void clearSchool() {
        for (String schoolId : dust_schools) {
            deleteSchool(schoolId);
        }
    }

    private void initParents(JSONObject object) {
        List<String> list = object.getJSONArray(KEY_PARENTS).toJavaList(String.class);
        for (String s : list) {
            parents.add(s);
        }
    }

    public String getParent() {
        String account = parents.remove();
        parents.add(account);
        return account;
    }

    private void saveJson() {
        JSONObject object = new JSONObject();
        object.put(KEY_PARENTS, parents);
        object.put(KEY_SCHOOLS, schools);
        try {
            saveJson(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveJson(JSONObject object) throws IOException {
        String filepath = "src/main/resources/" + JSON_FILE_NAME;// this.getClass().getClassLoader().getResource(JSON_FILE_NAME).getPath();//获取文件路径
        OutputStream os = new FileOutputStream(filepath);
        IOUtils.write(object.toJSONString(), os, "utf8");
    }

    private JSONObject readJson() {
        InputStream in = Warehouse.class.getClassLoader().getResourceAsStream(JSON_FILE_NAME);
        String text = "{}";
        try {
            text = IOUtils.toString(in, "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONObject.parseObject(text);
    }


    public void teardown() {
        clearSchool();
        saveJson();
    }
}
