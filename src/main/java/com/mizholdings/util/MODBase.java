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

    public JSONObject exec(String funcName) {
        return exec(funcName, Parameter.creat());
    }

    public JSONObject exec(String funcName, Parameter parameter) {
        if (executor instanceof User) {
            if (!parameter.containsKey("orgId")) {
                parameter.add("orgId", ((User) executor).getOrgId());
            }
            parameter.add("token", ((User) executor).getToken());
        }
        return exec(funcName, parameter.getObjectMap());
    }

    public JSONObject exec(String funcName, Map<String, Object> map) {
        Response response = Request.go(serve, agentName, funcName, map);
        if (response.state) {
            return response.json();
        }
        throw new RuntimeException(response.text);
    }

}
