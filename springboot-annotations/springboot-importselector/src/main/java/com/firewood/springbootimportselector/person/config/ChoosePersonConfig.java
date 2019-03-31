package com.firewood.springbootimportselector.person.config;

import com.firewood.springbootimportselector.person.annotation.EnablePerson;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnablePerson(jobName = "teacher")
public class ChoosePersonConfig {
}
