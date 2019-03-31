package service;

import annotation.MyAnnotation;

public class MyService {
    @MyAnnotation(strValue = "hi", intValue = 607)
    public void settingValue() {
    }
    @MyAnnotation
    public void defaultValue() {
    }
}
