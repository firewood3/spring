package com.firewood.conditional.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TeacherConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // True이면 빈으로 등록
        return "teacher".equals(context.getEnvironment().getProperty("person"));
    }
}
