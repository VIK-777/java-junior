package com.acme.edu;

public class SuperConsoleSaver implements SuperSaver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
