package org.santiagom123.utils;

import com.google.gson.JsonObject;

public class Utils {

    private static String id = "";
    private static JsonObject json = new JsonObject();

    static public String getId() {
        return id;
    }

    static public void setId(String idI) {
        Utils.id = idI;
    }

    static public void setJsonObject(JsonObject jsonObject) {
        json = jsonObject;
    }

    static public JsonObject getJsonObject() {
        return json;
    }
}
