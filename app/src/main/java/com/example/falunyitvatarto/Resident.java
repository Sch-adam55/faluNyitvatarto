package com.example.falunyitvatarto;

public class Resident {
    private String name;
    private String address;
    private int age;

    public Resident(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }
}

