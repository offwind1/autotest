package com.mizholdings.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import io.qameta.allure.Attachment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Funcs {

    public final static Log logger = LogFactory.getLog(Funcs.class);

    @Attachment("play load")
    public static Map<String, String> javabeanToMap(Object object) {
        Map<String, String> map = new HashMap<>();

        Class subClass = object.getClass();
        Field[] fields = subClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value != null) {
                    map.put(field.getName(), (String) value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }

        logger.info("JavaBean to Map: " + map.toString());
        return map;
    }

    public static JSONObject getOneFromJSONArray(JSONArray array) {
        if (array.size() == 0) {
            logger.error("json数组为空");
            throw new JSONException("json数组为空");
        }
        Random r = new Random();
        return array.getJSONObject(r.nextInt(array.size()));
    }

}
