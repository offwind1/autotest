package com.mizholdings.me2.user.serve;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;
import com.mizholdings.me2.Global;
import com.mizholdings.util.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ServeBase {
    protected User user;
    private static final String DEFINE_AGENT_PACKAGE = Global.getProperties("define.agent.package");
    private final String package_path;
    private final Cache<String, Object> map = CacheUtil.newLFUCache(8);

    public ServeBase(User user) {
        this.user = user;
        String[] strings = getClass().getName().split("\\.");
        package_path = DEFINE_AGENT_PACKAGE + "." + strings[strings.length - 1].toLowerCase();
    }

    protected Object getAgent(String agentName) {
        if (map.containsKey(agentName)) {
            return map.get(agentName);
        }

        try {
            Class cl = Class.forName(package_path + "." + firstWordToUpperCase(agentName));
            Constructor constructor = cl.getDeclaredConstructor(User.class);
            Object value = constructor.newInstance(user);
            map.put(agentName, value);
            return value;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        throw new RuntimeException(package_path + "." + agentName + "未找到");
    }


    private static String firstWordToUpperCase(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

//
//    protected Object getAgent(String agentName) {
//        try {
//            Field field = getField(this.getClass(), agentName);
//            field.setAccessible(true);
//            Object value = field.get(this);
//            if (value == null) {
////                Constructor constructor = field.getType().getDeclaredConstructor(User.class);
//                Constructor constructor = field.getType().getDeclaredConstructor(User.class);
//                value = constructor.newInstance(user);
//                field.set(this, value);
//            }
//            return value;
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    private Field getField(Class cls, String fieldName) throws NoSuchFieldException {
//        try {
//            return cls.getDeclaredField(fieldName);
//        } catch (NoSuchFieldException e) {
//            if (cls.getSuperclass() != null) {
//                return getField(cls.getSuperclass(), fieldName);
//            }
//            throw e;
//        }
//    }

    public enum GRADEID {
        ONE("1", "一年级"),
        TWO("2", "二年级"),
        THREE("3", "三年级"),
        FOUR("4", "四年级"),
        FIVE("5", "五年级"),
        SIX("6", "六年级"),
        SEVEN("7", "七年级"),
        EIGHT("8", "八年级"),
        NINE("9", "九年级");

        public String value;
        public String gradeName;

        private GRADEID(String value, String gradeName) {
            this.value = value;
            this.gradeName = gradeName;
        }
    }

    public enum LESSON_TYPE_ID {
        ALL("0", "全部"),
        MAT("2", "数学"),
        ENG("3", "英语"),
        SCI("10", "科学"),
        CHI("1", "语文"),
        HIS("4", "历史"),
        GEO("5", "地理"),
        POL("6", "政治"),
        BIO("7", "生物"),
        PHY("8", "物理"),
        CHE("9", "化学"),
        COM("11", "信息技术"),
        GEN("12", "通用技术"),
        ;
        public String value;
        public String name;

        private LESSON_TYPE_ID(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }


}
