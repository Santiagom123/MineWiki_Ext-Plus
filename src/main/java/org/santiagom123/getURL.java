package org.santiagom123;

import com.google.gson.JsonObject;
import org.santiagom123.utils.Utils;
import org.santiagom123.utils.getID;

public class getURL {
    static String url;
    static JsonObject json;
    static String[] IdIndex;

    public static String obtainURL() {

        json = Utils.getJsonObject();

        IdIndex = getID.spiltID();

        if (json.getAsJsonObject(IdIndex[0]) != null) {
            JsonObject subObject = json.getAsJsonObject(IdIndex[0]);

            if (subObject.getAsJsonObject(IdIndex[1]) != null) {
                JsonObject subObject2 = subObject.getAsJsonObject(IdIndex[1]);

                if (subObject2.getAsJsonObject(IdIndex[2]) != null) {
                    JsonObject subObject3 =  subObject2.getAsJsonObject(IdIndex[2]);

                    url = subObject3.get("url").getAsString();

                } else {
                    url = subObject2.get("url").getAsString();
                }
            } else {
                url = subObject.get("url").getAsString();
            }
        }

        return url;
    }
}
