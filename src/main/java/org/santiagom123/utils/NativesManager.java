package org.santiagom123.utils;

import org.santiagom123.libs.K.XRcheck;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.zip.*;

public class NativesManager {
    private static final String ZIP_URL = "https://github.com/Santiagom123/MineWikiDLL/releases/download/v1.1.0WIN/natives.zip";
    private static final File NATIVES_DIR = new File("natives");

    public static void setup() throws Exception {
        if (!NATIVES_DIR.exists() || NATIVES_DIR.list().length < 9) {
            File zipFile = new File("natives.zip");

            // Download
            try (InputStream in = new URL(ZIP_URL).openStream()) {
                Files.copy(in, zipFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            // Unzip
            if (!NATIVES_DIR.exists()) NATIVES_DIR.mkdirs();
            try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
                ZipEntry entry;
                XRcheck.XRinit();
                while ((entry = zis.getNextEntry()) != null) {
                    Files.copy(zis, new File(NATIVES_DIR, entry.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
            zipFile.delete();
        }

        // Load into JVM
        System.setProperty("java.library.path", NATIVES_DIR.getAbsolutePath());
        java.lang.reflect.Field field = ClassLoader.class.getDeclaredField("sys_paths");
        field.setAccessible(true);
        field.set(null, null);
    }
}
