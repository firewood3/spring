
package com.firewood.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Conventions;
import org.springframework.util.Assert;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.util.EnumSet;

@Configuration
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        System.out.println("webInit-rootConfigClass");
        return new Class[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        System.out.println("webInit-servletConfigClasses");
        return new Class[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        System.out.println("webInit-servletMappings");
        return new String[]{"/"};
    }
}
