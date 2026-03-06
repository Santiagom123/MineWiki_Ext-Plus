package org.santiagom123.utils;

public class getID {

    static String id;

    public static String[] spiltID() {
        id = Utils.getId();

        return id.split(":");
    }
}
