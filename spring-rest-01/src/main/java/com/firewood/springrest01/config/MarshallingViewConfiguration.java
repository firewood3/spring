package com.firewood.springrest01.config;

import com.firewood.springrest01.student.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.Collections;

@Configuration
public class MarshallingViewConfiguration {

    @Bean
    public View student() {
        return new MarshallingView(jaxb2marshaller());
    }

    @Bean
    public Marshaller jaxb2marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Student.class);
        marshaller.setMarshallerProperties(Collections.singletonMap(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE));
        return marshaller;
    }
}
