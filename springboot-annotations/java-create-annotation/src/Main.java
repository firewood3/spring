import annotation.MyAnnotation;
import service.MyService;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Method[] methods = Class.forName(MyService.class.getName()).getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
                System.out.println(myAnnotation.strValue());
                System.out.println(myAnnotation.intValue());
            }
        }

    }
}
