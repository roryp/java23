package com.example;

public class PrimitivePatterns {
    public static void main(String[] args) {
        Object obj = 42;
        if (obj instanceof Integer i) {
            System.out.println("Integer value: " + i);
        }
    }
}