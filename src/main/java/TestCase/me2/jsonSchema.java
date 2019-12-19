package TestCase.me2;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.mizholdings.util.Parameter;
import com.mizholdings.util.requests.Request;
import org.testng.annotations.Test;

public class jsonSchema {
    @Test
    public void sss(){
        System.out.println(FileUtil.isFile("schema/web/answer/addAnswerCard.json"));
    }


    @Test
    public void jsonSchema_test() {

        Parameter parameter = Parameter.creat()
                .add("lessonId", "f6ff5016e66e477cb6e734f456ba4069")
                .add("classroomId", "dc62709b35b34ca3b4f7c7eaef93826e")
                .add("answerCardId", "68")
                .add("cardName", "自动创建的答题卡");

        String schema_string = Request.readFile("jsonFile.json");
        String schema_json = Request.formatString(schema_string, parameter.getObjectMap());
//        System.out.println(schema_json);
        Request.JsonSchema(Request.readJsonString(schema_json), Request.readJsonFile("define.json"));
    }

    @Test
    public void jsonFormat() {
        String json_string = Request.readFile("jsonFile.json");
        JSONObject object = JSONObject.parseObject(json_string);
        System.out.println(filterJosn(object).toJSONString());
    }

    public JSONObject filterJosn(JSONObject object) {
//        Set<String> sss = object.keySet();
        JSONObject temp = new JSONObject();
        for (String key : object.keySet()) {
            if ("$id".equals(key) || "title".equals(key) || "default".equals(key) || "examples".equals(key)) {
            } else {
                Object o = object.get(key);
                if (o instanceof JSONObject) {
                    temp.put(key, filterJosn((JSONObject) o));
                } else {
                    temp.put(key, o);
                }
            }
        }
        return temp;
    }

    public String formatString(String str, Parameter parameter) {
        for (String key : parameter.getMap().keySet()) {
            str = str.replace("{{" + key + "}}", parameter.getString(key));
        }
        return str;
    }


}
