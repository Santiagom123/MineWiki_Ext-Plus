package org.santiagom123;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.santiagom123.utils.Utils;

public class getJson {

    static File config = new File(UnPackHandler.getJarPath() + "/MineWikiRef.json");

    public static void readjson() {

        if (!config.exists()) {
            System.err.println("MineWiki: Urls json file does not exist");
        }

        try (FileReader reader = new FileReader(config)) {

            JsonObject root =  new JsonParser().parse(reader).getAsJsonObject();

            Utils.setJsonObject(root);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
