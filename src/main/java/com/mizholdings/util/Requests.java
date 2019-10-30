package com.mizholdings.util;

import com.alibaba.fastjson.JSONObject;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class Requests {

    private final static Log logger = LogFactory.getLog(Requests.class);

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Env.host)
            .build();

    public static <T> T getService(Class<T> tClass) {
        return retrofit.create(tClass);
    }

    public static JSONObject getJson(Call<ResponseBody> bodyCall) {
        logger.debug("URL: " + bodyCall.request().url());
        logger.debug("Method: " + bodyCall.request().method());
        try {
            logger.debug("Request Body: " + bodyToString(bodyCall.request().body()));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }

        try {
            Response<ResponseBody> response = bodyCall.execute();
            logger.debug("Response: " + response.toString());
            JSONObject object = JSONObject.parseObject(response.body().string());
            logger.debug("Json: " + object.toJSONString());
            return object;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    public static String bodyToString(final RequestBody body) throws IOException {
        Buffer buffer = new Buffer();
        if (body != null) {
            body.writeTo(buffer);
            return buffer.readUtf8();
        }

        return "";
    }

    public static RequestBody getJsonRequestBody(JSONObject object) {
        return RequestBody.create(MediaType.parse("application/json"), object.toJSONString());
    }

}
