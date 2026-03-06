package org.santiagom123.libs.K;

import java.io.InputStream;
import java.security.MessageDigest;

public final class XR {

    private static final char[] H = "0123456789abcdef".toCharArray();

    private XR() {}

    public static String k(InputStream in) throws Exception {

        MessageDigest g = MessageDigest.getInstance("SHA-256");

        byte[] buf = new byte[4096];
        int r;

        while ((r = in.read(buf)) != -1) {
            g.update(buf, 0, r);
        }

        byte[] d = g.digest();

        char[] out = new char[d.length * 2];
        int i = 0;

        for (byte b : d) {
            int v = b & 0xFF;
            out[i++] = H[v >>> 4];
            out[i++] = H[v & 0x0F];
        }

        return new String(out);
    }
}