package com.mizholdings.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Env {
    public static String host;
    public static Properties properties;
    public static String version;

    public static class Kacha {
        public final static String BLUE_PIG = "kcct";
        public final static String TEACHER = "kcsj";

    }


    public static void init(InputStream env) throws IOException {
        properties = new Properties();
        properties.load(env);
        String project = properties.getProperty("test.project");
        host = properties.getProperty("test." + project + ".host");
        version = properties.getProperty("test." + project + ".version");
    }
}
