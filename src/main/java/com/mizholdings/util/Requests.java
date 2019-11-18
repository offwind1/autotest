package com.mizholdings.util;

import com.alibaba.fastjson.JSONObject;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Requests {
    public static Properties properties = null;
    private final static Log logger = LogFactory.getLog(Requests.class);
    private static Retrofit retrofit;
//    = new Retrofit.Builder()
//            .baseUrl(Env.host)
//            .build();

    public static <T> T getService(Class<T> tClass) {
        if (properties == null) {
            InputStream stream = Requests.class.getClassLoader().getResourceAsStream("testConfig.properties");
            properties = new Properties();
            try {
                properties.load(stream);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }

        String packageName = tClass.getPackage().getName();

        logger.debug(packageName);
        String host = properties.getProperty(packageName);

        logger.debug("HOST: " + host);
        retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .build();
        return retrofit.create(tClass);
    }

    @Attachment("url")
    public static String showUrl(Call<ResponseBody> bodyCall) {
        return bodyCall.request().url().toString();
    }

    public static JSONObject getJson(Call<ResponseBody> bodyCall) {
        logger.debug("URL: " + showUrl(bodyCall));
        logger.debug("Method: " + bodyCall.request().method());
        try {
//            logger.debug("Headers: " + bodyCall.request().headers());
            logger.debug("Headers: " + bodyCall.request().headers().toMultimap());
            logger.debug("Request Body: " + bodyToString(bodyCall.request().body()));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e);
        }

        try {
            Response<ResponseBody> response = bodyCall.execute();
            logger.debug("Response: " + response.toString());
            if (response.errorBody() != null) {
                logger.debug("Response errorBody: " + response.errorBody().string());
                Allure.addAttachment("errorBody", response.errorBody().string());
            }
            JSONObject object = JSONObject.parseObject(response.body().string());
            logger.debug("Json: " + object.toJSONString() + "\n");
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
