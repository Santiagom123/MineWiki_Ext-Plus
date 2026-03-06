package org.santiagom123.libs.K;

import org.santiagom123.Main;

import java.io.InputStream;

public class XRcheck {

    public static void XRinit() {

        String r1 = "/org/santiagom123/libs/K/linksIMG/smpNTEPM/LOADA45SGPAEARTFGHESHRYTHWAFOYY.png";
        String r2 = "/org/santiagom123/libs/K/linksIMG/smpNTEPM/RIWILRYMEYU.png";

        try (
                InputStream in = XR.class.getResourceAsStream(r1);
                InputStream in1 = Main.class.getResourceAsStream(r2)
        ) {

            if (in == null) {
                throw new IllegalStateException("Resource missing: " + r1);
            }

            if (in1 == null) {
                throw new IllegalStateException("Resource missing: " + r2);
            }

            if (!XR.k(in).equals("6ec4130c1d3a11c12cf80e9e96c4c8999dd8a5fb435bd83d1ee4358b8c12ae19")) {
                System.exit(-25456);
            }

            if (!XR.k(in1).equals("03e93f8f1a793c54335e0a3738d600ac96f480f0faf88616f9ab67409ad2fae2")) {
                System.exit(-25457);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Main.LOGGER.severe("LNKS FAILED: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }
}