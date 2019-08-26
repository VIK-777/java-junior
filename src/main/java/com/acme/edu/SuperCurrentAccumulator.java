package com.acme.edu;

class SuperCurrentAccumulator {
    private static int intSum = 0;
    private static int byteSum = 0;

    void add (int number) {
        intSum += number;
    }

    void add (byte number) {
        byteSum += number;
    }

    static void makeZero () {
        intSum = 0;
        byteSum = 0;
    }

    static int getIntSum() {
        return intSum;
    }

    static int getByteSum() {
        return byteSum;
    }

}
