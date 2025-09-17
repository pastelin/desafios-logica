package com.codewars.six;

import java.util.LinkedHashMap;

public class FIXMEHello {

    LinkedHashMap<String, Object> attributes = new LinkedHashMap<>();
    String gender;

    public FIXMEHello() {
    }

    public FIXMEHello setAge(int age) {
        attributes.put("age", age);
        return this;
    }

    public FIXMEHello setSex(char sex) {
        attributes.put("sex", sex == 'M' ? "male" : "female");
        return this;
    }

    public FIXMEHello setName(String name) {
        attributes.put("name", name);
        return this;
    }

    public String hello() {
        StringBuilder sb = new StringBuilder("Hello.");

        attributes.keySet().forEach(key -> {
            if (key.equals("name")) {
                sb.append(" My name is ").append(attributes.get(key)).append(".");
            } else {
                sb.append(" I am ").append(attributes.get(key)).append(".");
            }
        });
        return sb.toString();
    }

    public static void main(String[] args) {
        FIXMEHello hello = new FIXMEHello();
        hello.setName("John").setAge(30).setSex('M');
        System.out.println(hello.hello());
    }
}