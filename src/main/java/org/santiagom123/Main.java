package org.santiagom123;

import org.santiagom123.libs.K.XRcheck;
import org.santiagom123.utils.NativesManager;
import org.santiagom123.utils.Utils;

import java.io.InputStream;
import java.util.logging.Logger;

public class Main {

    public static Boolean DEBUG = false;
    public static Logger LOGGER;

    public static void main(String[] args) {



        LOGGER = Logger.getLogger(Main.class.getName());

        XRcheck.XRinit();

        UnPackHandler.unPack();

        try {
            LOGGER.info("Starting Main: with args: " + args[0] + " " + args[1]);
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }

        try {
            NativesManager.setup();
        } catch (Exception ex) {
            LOGGER.severe(ex.getMessage());
            System.exit(-1);
        }


        LOGGER.info("ARG[0] Changed to: " + args[0]);

        try {

            if (args[1].equals("-d")) {
                DEBUG = true;
                LOGGER.warning("Debugging");
            } else {
                DEBUG = false;
            }

        } catch (ArrayIndexOutOfBoundsException ex) {
            LOGGER.info("No Debugging");
        }


        Utils.setId(args[0]);

        getJson.readjson();
        if (DEBUG) {
            System.out.println(getURL.obtainURL());
        }
        Window window = new Window();
        if (DEBUG) {LOGGER.info("Window initialized");}
        window.mainWindow();

    }
}
