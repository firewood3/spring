package com.firewood.springbootimportselector.person.config.selector;

import com.firewood.springbootimportselector.person.annotation.EnablePerson;
import com.firewood.springbootimportselector.person.config.PersonToStudentConfig;
import com.firewood.springbootimportselector.person.config.PersonToTeacherConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class PersonImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnablePerson.class.getName(), false));
        assert attributes != null;
        String jobName = attributes.getString("jobName");

        if(jobName.equals("teacher")) {
            return new String[]{PersonToTeacherConfig.class.getName()};
        } else {
            return new String[]{PersonToStudentConfig.class.getName()};
        }
    }
}
