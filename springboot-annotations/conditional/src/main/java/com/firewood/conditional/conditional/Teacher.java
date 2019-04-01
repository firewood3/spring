package com.firewood.conditional.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(TeacherConditional.class)
public class Teacher implements Person{
    @Override
    public String getJob() {
        return "My job is teacher";
    }
}
