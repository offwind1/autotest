package com.mizholdings.kacha.cases;

import com.alibaba.fastjson.JSONObject;
import com.mizholdings.kacha.core.Teacher;
import com.mizholdings.kacha.interfaces.AuthInterface;
import com.mizholdings.util.Env;
import com.mizholdings.util.Requests;
import okhttp3.ResponseBody;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import retrofit2.Call;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class testInitCase {

    @BeforeTest
    public void beforeTest() throws IOException {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("testConfig.properties");
        Env.init(stream);
    }
}
