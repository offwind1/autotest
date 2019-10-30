package com.mizholdings.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Funcs {

    public final static Log logger = LogFactory.getLog(Funcs.class);

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


}
