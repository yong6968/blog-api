package com.linzy.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author zhiyong.lin
 * @version 2018/3/29 16:10
 */
public class JsonUtil {
    private static ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static <T> String objectToJson(T data) {
        String json = null;
        if(data != null) {
            try {
                json = JSON_MAPPER.writeValueAsString(data);
            } catch (Exception var3) {
                throw new IllegalArgumentException("objectToJson method error: " + var3);
            }
        }

        return json;
    }

    public static <T> T jsonToObject(String json, Class<T> cls) {
        Object object = null;
        if(!StringUtils.isEmpty(json) && cls != null) {
            try {
                if(json.startsWith("\"{")) {
                    json = json.replace("\"{", "{").replace("}\"", "}").replace("\\\"", "\"");
                }

                object = JSON_MAPPER.readValue(json, cls);
            } catch (Exception var4) {
                throw new IllegalArgumentException("jsonToObject method error: " + var4);
            }
        }

        return (T) object;
    }

    public static List<Map<String, Object>> jsonToList(String json) {
        List list = null;
        if(!StringUtils.isEmpty(json)) {
            try {
                if(json.startsWith("\"[")) {
                    json = json.replace("\"[", "[").replace("]\"", "]").replace("\\\"", "\"");
                }

                list = (List)JSON_MAPPER.readValue(json, List.class);
            } catch (Exception var3) {
                throw new IllegalArgumentException("jsonToList method error: " + var3);
            }
        }
        return list;
    }

    public static Map<String, Object> jsonToMap(String json) {
        Map maps = null;
        if(!StringUtils.isEmpty(json)) {
            try {
                if(json.startsWith("\"{")) {
                    json = json.replace("\"{", "{").replace("}\"", "}").replace("\\\"", "\"");
                }

                maps = (Map)JSON_MAPPER.readValue(json, Map.class);
            } catch (Exception var3) {
                throw new IllegalArgumentException("jsonToMap method error: " + var3);
            }
        }

        return maps;
    }
}
