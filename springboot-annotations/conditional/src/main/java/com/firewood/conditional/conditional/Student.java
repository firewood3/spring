package com.firewood.conditional.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(StudentConditional.class)
public class Student implements Person{
    @Override
    public String getJob() {
        return "My job is student";
    }
}
