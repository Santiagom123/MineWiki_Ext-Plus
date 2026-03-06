package org.santiagom123;

import org.santiagom123.libs.K.XRcheck;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UnPackHandler {

    public static void unPack() {
        if (!areFiles()) {

            try (InputStream Worker = UnPackHandler.class.getResourceAsStream("files/worker.exe"); InputStream MineWRintStream = UnPackHandler.class.getResourceAsStream("files/MineWikiRef.json");) {
                if (MineWRintStream == null || Worker == null) {
                    Main.LOGGER.severe("FILES NOT FOUND, REINSTALL MINE WIKI BEFORE CONTACT THEIR AUTHOR (santiagom123)");
                    XRcheck.XRinit();
                    return;
                }
                Files.copy(MineWRintStream, Paths.get(getJarPath(), "MineWikiRef.json"));
                Main.LOGGER.info("Copied MineWikiRef.json");
                Files.copy(Worker, Paths.get(getJarPath(), "worker.exe"));
                Main.LOGGER.info("Copied worker.exe");

                if (!areFiles()) {
                    System.exit(-1);
                }
            } catch (IOException e) {
                Main.LOGGER.severe("FILES NOT FOUND, REINSTALL MINE WIKI BEFORE CONTACT THEIR AUTHOR (santiagom123): "+ e.getMessage());
            }



        }
    }

    public static String getJarPath() {

        String path = "";
        try {

            File jarFile = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI());


             path = jarFile.getParent();
             Main.LOGGER.info("Current path is: " + path);
             XRcheck.XRinit();

        } catch (URISyntaxException ignored) {

        }

       return path;

    }

    public static Boolean areFiles() {


        File UrlRef = new File(getJarPath() + "/MineWikiRef.json");
        File Worker = new File(getJarPath() + "/worker.exe");

        if (!UrlRef.exists() ||  !Worker.exists()) {
            if (UrlRef.exists() && !Worker.exists()) {
                UrlRef.delete();

                Main.LOGGER.warning("worker.exe does not exist");
                Main.LOGGER.warning("Removing MineWikiRef.json file");
            }

            if (Worker.exists() && !UrlRef.exists()) {
                Worker.delete();

                Main.LOGGER.warning("MineWikiRef.json does not exist");
                Main.LOGGER.warning("Removing worker.exe file");
            }
            return false;
        } else {
            return true;
        }

    }
}
