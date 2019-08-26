package com.acme.edu;

class SuperConsoleSaver {

    private final static String PRIMITIVE_PREFIX = "primitive: ";
    private final static String CHAR_PREFIX = "char: ";
    private final static String STRING_PREFIX = "string: ";
    private final static String REFERENCE_PREFIX = "reference: ";
    private final static String PRIMITIVE_ARRAY_PREFIX = "primitives array: ";
    private final static String PRIMITIVE_MATRIX_PREFIX = "primitives matrix: ";

    void Save(int message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    void Save(byte message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    void Save(char message) {
        System.out.println(CHAR_PREFIX + message);
    }

    void Save(String message) {
        System.out.println(STRING_PREFIX + message);
    }

    void Save(boolean message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

    void Save(Object message) {
        System.out.println(REFERENCE_PREFIX + message);
    }



    private void logMatrix(int... message) {
        System.out.print("{");
        for (int i = 0; i < message.length ; i++) {
            System.out.print(message[i]);
            if (i < message.length - 1) {
                System.out.print(", ");
            }
        }
    }

    void Save (int ... message) {
        System.out.print(PRIMITIVE_ARRAY_PREFIX);
        this.logMatrix(message);
        System.out.println("}");
    }

    void Save(int[][] message) {
        System.out.println(PRIMITIVE_MATRIX_PREFIX + "{");
        for (int i = 0; i < message.length ; i++) {
            this.logMatrix(message[i]);
            System.out.println("}");
        }
        System.out.println("}");
    }

}
