package com.firewood.myspringbootmodule.helloworld;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public void printHelloWorld() {
        System.out.println("Hello World! form Custom Module!");
    }
}
