package com.acme.edu;

public class Logger {

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String REFERENCE_PREFIX = "reference: ";
    private final static String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private final static String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";

    private static int intSum = 0;
    private static byte byteSum = 0;
    private static String type = null;

    private SuperCurrentAccumulator superCurrentAccumulator;
    private static SuperConsoleSaver superConsoleSaver = new SuperConsoleSaver();

    public static void flush(String curr_type) {
        if (curr_type.equals("Int")) {
            // System.out.println(PRIMITIVE_PREFIX + intSum);
            superConsoleSaver.Save(intSum);
            intSum = 0;
        } else {
            System.out.println(PRIMITIVE_PREFIX + byteSum);
            byteSum = 0;
        }
    }

    public static void log(int message) {
        if (intSum > 0 & message + intSum < 0) {
            flush(type);
            // intSum = Math.abs(message + intSum);
            // System.out.println(PRIMITIVE_PREFIX + Integer.MAX_VALUE);
            superConsoleSaver.Save(Integer.MAX_VALUE);
            type = null;
        }
        else {
            intSum += message;
            type = "Int";
        }
        //System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(byte message) {
        if (byteSum > 0 & (byte)(message + byteSum) < 0) {
            flush(type);
            byteSum = (byte)(message + byteSum + Byte.MAX_VALUE);
            System.out.println(PRIMITIVE_PREFIX + Byte.MAX_VALUE);
            type = null;
        }
        else {
            byteSum += message;
            type = "Byte";
        }
        //System.out.println(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
        System.out.println(CHAR_PREFIX + message);
    }

    public static void log(String message) {
        if (!"String".equals(type) && type != null) {
            flush(type);
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

    public static void log(int ... message) {
        System.out.print(PRIMITIVE_ARRAY_PREFIX + "{");
        for (int i = 0; i < message.length ; i++) {
            System.out.print(message[i]);
            if (i < message.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void log(int[][] message) {
        System.out.println(PRIMITIVE_MATRIX_PREFIX + "{");
        for (int i = 0; i < message.length ; i++) {
            System.out.print("{");
            for (int j = 0; j < message[i].length ; j++ ) {
                System.out.print(message[i][j]);
                if (j < message[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
        System.out.println("}");
    }
}
