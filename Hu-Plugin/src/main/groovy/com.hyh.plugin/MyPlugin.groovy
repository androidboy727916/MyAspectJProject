package com.hyh.plugin

import org.gradle.api.Plugin

public class MyPlugin implements Plugin {

    @Override
    void apply(Object o) {
        System.out.println("========================");
        System.out.println("hello gradle plugin!");
        System.out.println("========================");
    }
}