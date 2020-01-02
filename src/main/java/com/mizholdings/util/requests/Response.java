package com.mizholdings.util.requests;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Response {

    public final String text;
    private final JSONObject json;
    public final boolean state;

    public Response(String text) {
        this.text = text;
        json = parse();
        state = ObjectUtil.isNotNull(json);
    }

    private JSONObject parse() {
        try {
            return JSONObject.parseObject(text);
        } catch (JSONException e) {
            return null;
        }
    }

    public JSONObject json() {
        return json;
    }

    public String getText() {
        if (ObjectUtil.isNotNull(json)) {
            return jsonFormat(text);
        }
        return text;
    }

    public String jsonFormat(String jsonString) {
        JSONObject object = JSONObject.parseObject(jsonString);
        jsonString = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        return jsonString;
    }

}
