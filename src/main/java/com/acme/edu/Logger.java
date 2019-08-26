package com.acme.edu;

public class Logger {
    private static String type = null;

    private static SuperCurrentAccumulator superCurrentAccumulator = new SuperCurrentAccumulator();
    private static SuperConsoleSaver superConsoleSaver = new SuperConsoleSaver();

    private static void flush(Command command) {
        superConsoleSaver.Save(command.execute());
        SuperCurrentAccumulator.makeZero();
    }

    public static void flush() {
        if (SuperCurrentAccumulator.getIntSum() != 0) {
            flush(SuperCurrentAccumulator::getIntSum);
        } else {
            flush(SuperCurrentAccumulator::getByteSum);
        }
    }

    public static void log(int message) {
        if (SuperCurrentAccumulator.getIntSum() > 0 & message + SuperCurrentAccumulator.getIntSum() < 0) {
            flush(SuperCurrentAccumulator::getIntSum);
            superConsoleSaver.Save(Integer.MAX_VALUE);
            type = null;
        }
        else {
            superCurrentAccumulator.add(message);
            type = "Int";
        }
    }

    public static void log(byte message) {
        if (SuperCurrentAccumulator.getByteSum() > 0 & (byte)(message + SuperCurrentAccumulator.getByteSum()) < 0) {
            flush(SuperCurrentAccumulator::getByteSum);
            superConsoleSaver.Save(Byte.MAX_VALUE);
            type = null;
        }
        else {
            superCurrentAccumulator.add(message);
            type = "Byte";
        }
    }

    public static void log(char message) {
        superConsoleSaver.Save(message);
    }

    public static void log(String message) {
        if (!"String".equals(type) && type != null) {
            flush(SuperCurrentAccumulator::getIntSum);
        }
        type = "String";
        superConsoleSaver.Save(message);
    }

    public static void log(boolean message) {
        superConsoleSaver.Save(message);
    }

    public static void log(Object message) {
        superConsoleSaver.Save(message);
    }

    public static void log(int ... message) {
        superConsoleSaver.Save(message);
    }

    public static void log(int[][] message) {
        superConsoleSaver.Save(message);
    }
}

interface Command {
    int execute();
}

