package com.mizholdings.util;

public abstract class User {

    protected String orgId = "0";
    protected String userId = "0";
    protected String token;
    protected String bookToken = "";

//    protected Object getAgent(String agentName) {
//        try {
//            Field field = getField(this.getClass(), agentName);
//            field.setAccessible(true);
//            Object value = field.get(this);
//            if (value == null) {
//                Constructor constructor = field.getType().getDeclaredConstructor(User.class);
//                value = constructor.newInstance(this);
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

    public String getOrgId() {
        return orgId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookToken() {
        return bookToken;
    }

    public String getToken() {
        return token;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

}
