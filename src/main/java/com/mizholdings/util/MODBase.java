package com.mizholdings.util;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.user.KCUserBase;
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

    @Attachment("{funName} return")
    public JSONObject exec(String funName, PLJavaBean javaBean) {
        if (interfaced == null) {
            logger.error("interface is null");
            return null;
        }

        try {
            Method method = interfaced.getClass().getMethod(funName, String.class, Map.class);
            Call<ResponseBody> bodyCall = (Call<ResponseBody>) method.invoke(interfaced, executor.getToken(), Funcs.javabeanToMap(javaBean));
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

    @Step("{funName}")
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
