package com.mizholdings.util.requests;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mizholdings.me2.Global;
import com.mizholdings.util.Requests;
import com.mizholdings.util.XmlTool.ElementMine;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONTokener;

import java.io.*;
import java.util.Map;

public class Request {
    protected final static Log logger = LogFactory.getLog(Request.class);

    private static final String SCHEMA = "schema";

    public static Response go(String serve, String agent, String funcName, Map<String, Object> map) {
        logger.info("\n");
        logger.info(agent + ":" + funcName);

        ElementMine elementMine = Global.getServe(serve);
        String host = elementMine.getAttribute("host");
        ElementMine interfaces = elementMine.getElementsByTagNameAndValue("interfaces", agent);
        String interfaces_name = interfaces.getAttribute("name");
        String interfaces_value = interfaces.getAttribute("value");

        ElementMine in = interfaces.getElementsByTagNameAndValue("interface", funcName);
        String interfaceName = in.getAttribute("name");
        String interface_url = in.getAttribute("url");
        String interface_value = in.getAttribute("value");

        String method = in.getAttribute("method");
        String url = host + interface_url;

        logger.info("interfaces_value:" + interfaces_value + " # interface_url:" + interface_url);
        Response response = doRequest(url, method, map, interfaces_name, interfaceName);

        showResponse(response);

//        String schema_path = "schema\\" + serve + "\\" + interfaces_value + "\\" + interface_value + ".json";
//        if (response.state && FileUtil.isFile(schema_path)) {
//            try {
//                JsonSchema(schema_path, response, map);
//            } catch (com.mizholdings.util.requests.SchemaCheckException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return response;
    }

    private static void showResponse(Response response) {
        String text = response.getText();
        logger.info("response:" + text);
        Allure.addAttachment("response", text);
    }

    private static void JsonSchema(String schema_path, Response response, Map<String, Object> map) {
        String schema_string = readFile(schema_path);
        String schema_json = formatString(schema_string, map);
        JsonSchema(readJsonString(schema_json), readJsonString(response.text));
    }

    public static String readFile(String path) {
        return FileUtil.readString(path, "UTF-8");
    }

    public static String formatString(String str, Map<String, Object> map) {
        for (String key : map.keySet()) {
            str = str.replace("{{" + key + "}}", String.valueOf(map.get(key)));
        }
        return str;
    }

    public static void JsonSchema(String schema_path, String json) {
        org.json.JSONObject Schema = readJsonFile(schema_path);
        org.json.JSONObject data = new org.json.JSONObject(json);
        JsonSchema(Schema, data);
    }

    public static void JsonSchema(org.json.JSONObject schema_json, org.json.JSONObject json) {
        org.everit.json.schema.Schema schema = SchemaLoader.load(schema_json);
        try {
            schema.validate(json);
        } catch (ValidationException e) {
            throw new SchemaCheckException(e.getMessage());
        }
    }

    public static org.json.JSONObject readJsonFile(String filePath) {
        InputStream inputStream = Requests.class.getClassLoader().getResourceAsStream(filePath);
        org.json.JSONObject schema = new org.json.JSONObject(new JSONTokener(inputStream));
        return schema;
    }

    public static org.json.JSONObject readJsonString(String json_string) {
        return new org.json.JSONObject(json_string);
    }

    @Step("{model} : {name}")
    private static Response doRequest(String url, String method, Map<String, Object> map, String model, String name) {
        logger.info(model + name);
        logger.info("URL:" + url);
        logger.info("Method:" + method);
        logger.info(map.toString());

        String response = "";

        if ("POST".equals(method)) {
            response = HttpUtil.post(url, map);
        } else if ("GET".equals(method)) {
            response = HttpUtil.get(url, map);
        }

        return new Response(response);
    }
}


class SchemaCheckException extends RuntimeException {
    public SchemaCheckException(String message) {
        super(message);
    }
}

