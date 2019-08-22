package com.acme.edu;

public class Logger {

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String REFERENCE_PREFIX = "reference: ";

    private static Integer sum = 0;
    private static String type = null;

    public static boolean isInteger(Object message) {
        System.out.println(message.getClass().getName());
        return true;
    }

    public static void flush() {
        System.out.println(PRIMITIVE_PREFIX + sum);
        sum = 0;
    }
    
    //Bad code style
    public static void log(int message) {
        // isInteger(message);
        //if ("Int".equals(type)) {
        //    sum += message;
        //}
        if (sum > 0 & message + sum < 0) {
            flush();
            System.out.println(PRIMITIVE_PREFIX + message);
            type = null;
        }
        else {
            sum += message;
            type = "Int";
        }
        //System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        System.out.println(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        if (!"String".equals(type) && type != null) {
            flush();
        }
        type = "String";
        System.out.println(STRING_PREFIX + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(Object message) {
        System.out.println(REFERENCE_PREFIX + message);
    }
}
