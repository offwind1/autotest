package com.mizholdings.util;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.requests.Request;
import com.mizholdings.util.requests.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Map;

public class MODBase<T extends MODBase> {
    protected User executor;
    protected final static Log logger = LogFactory.getLog(MODBase.class);
    protected Object interfaced;

    private String serve;
    protected String agentName;

    public MODBase() {
        String[] list = getClass().getPackage().getName().split("\\.");
        serve = list[list.length - 1];
        list = getClass().getName().replace("Agent", "").split("\\.");
        agentName = list[list.length - 1];
    }

    public MODBase(User executor) {
        this();
        this.executor = executor;
    }

    /**
     * 设置执行人
     *
     * @param user 执行人
     * @return 返回对象本身
     */
    public T setExecutor(User user) {
        executor = user;
        return (T) this;
    }

    public T setInterfaced(Class interfaced) {
        this.interfaced = Requests.getService(interfaced);
        return (T) this;
    }

//
//    public JSONObject exec(String funName, PLJavaBean javaBean) {
//        return exec(funName, Funcs.javabeanToMap(javaBean));
//    }
//
//    public JSONObject exec(String funName, Parameter parameter, int i) {
//        if (executor instanceof Me2UserBase) {
//            parameter.add("orgId", ((Me2UserBase) executor).getOrgId());
//        }
//        return exec(funName, parameter.getMap());
//    }


    public JSONObject exec(String funcName) {
        return exec(funcName, Parameter.creat());
    }

    public JSONObject exec(String funcName, Parameter parameter) {
        if (executor instanceof User) {
            parameter.add("orgId", ((User) executor).getOrgId());
            parameter.add("token", ((User) executor).getToken());
        }
        return exec(funcName, parameter.getObjectMap());
    }

    public JSONObject exec(String funcName, Map<String, Object> map) {
        Response response = Request.go(serve, agentName, funcName, map);
        if (response.state) {
            logger.info(response.json().toJSONString());
            return response.json();
        }
        logger.error(response.text);
        throw new RuntimeException(response.text);
    }

//
//    public JSONObject exec(String funName, Map<String, String> map) {
//        if (interfaced == null) {
//            logger.error("interface is null");
//            return null;
//        }
//        Allure.addAttachment("parameters", map.toString());
//
//        try {
//            Method method = interfaced.getClass().getMethod(funName, String.class, Map.class);
//            Call<ResponseBody> bodyCall = (Call<ResponseBody>) method.invoke(interfaced, executor.getToken(), map);
//            return Requests.getJson(bodyCall);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//            logger.error("未匹配到接口函数");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public JSONObject exec_no_token(String funName, Parameter parameter) {
//        return exec_no_token(funName, parameter);//.getMap());
//    }
//
//    public JSONObject exec_no_token(String funName, Map<String, String> map) {
//        if (interfaced == null) {
//            logger.error("interface is null");
//            return null;
//        }
//        Allure.addAttachment("parameters", map.toString());
//
//        try {
//            Method method = interfaced.getClass().getMethod(funName, Map.class);
//            Call<ResponseBody> bodyCall = (Call<ResponseBody>) method.invoke(interfaced, map);
//            return Requests.getJson(bodyCall);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//            logger.error("未匹配到接口函数");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//
//    @Attachment("{funName} return")
//    public JSONObject exec(String funName) {
//        if (interfaced == null) {
//            logger.error("interface is null");
//            return null;
//        }
//        try {
//            Method method = interfaced.getClass().getMethod(funName, String.class);
//            Call<ResponseBody> bodyCall = (Call<ResponseBody>) method.invoke(interfaced, executor.getToken());
//            return Requests.getJson(bodyCall);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//            logger.error("未匹配到接口函数");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
