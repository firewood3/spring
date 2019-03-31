package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 어노티에션이 적용될 요소타입
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 적용 범위
public @interface MyAnnotation {
    // 어노테이션은 interface에 @를 붙여서 선언하고 어노테이션이 적용될 대상과 동작 방식을 지정할 수 있다.
    String strValue() default "no String";
    int intValue() default 0;
}
