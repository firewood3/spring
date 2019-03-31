package com.firewood.springbootimportselector.person.annotation;

import com.firewood.springbootimportselector.person.config.selector.PersonImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(PersonImportSelector.class)
public @interface EnablePerson {
    String jobName() default "student";
}
