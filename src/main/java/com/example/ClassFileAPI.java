package com.example;

import jdk.classfile.ClassFile;

public class ClassFileAPI {
    public static void main(String[] args) {
        ClassFile cf = ClassFile.read("MyClass.class");
        System.out.println(cf.toString());
    }
}