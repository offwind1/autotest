package com.mizholdings.util;

import com.alibaba.fastjson.JSONObject;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import okhttp3.ResponseBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import retrofit2.Call;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class MODBase<T extends MODBase> {
    protected User executor;
    protected final static Log logger = LogFactory.getLog(MODBase.class);
    protected Object interfaced;

    public MODBase(User executor) {
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


    public JSONObject exec(String funName, PLJavaBean javaBean) {
        return exec(funName, Funcs.javabeanToMap(javaBean));
    }
    public JSONObject exec(String funName, Parameter parameter) {
        return exec(funName, parameter.getMap());
    }

    @Attachment("{funName} return")
    public JSONObject exec(String funName, Map<String, String> map) {
        if (interfaced == null) {
            logger.error("interface is null");
            return null;
        }

        Allure.addAttachment("parameters", map.toString());

        try {
            Method method = interfaced.getClass().getMethod(funName, String.class, Map.class);
            Call<ResponseBody> bodyCall = (Call<ResponseBody>) method.invoke(interfaced, executor.getToken(), map);
            return Requests.getJson(bodyCall);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            logger.error("未匹配到接口函数");
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Attachment("{funName} return")
    public JSONObject exec(String funName) {
        if (interfaced == null) {
            logger.error("interface is null");
            return null;
        }
        try {
            Method method = interfaced.getClass().getMethod(funName, String.class);
            Call<ResponseBody> bodyCall = (Call<ResponseBody>) method.invoke(interfaced, executor.getToken());
            return Requests.getJson(bodyCall);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            logger.error("未匹配到接口函数");
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


}
