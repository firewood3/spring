
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

import javax.servlet.*;
import java.util.EnumSet;

@Configuration
public class WebInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {

        Class<?>[] contextClasses = new Class[] { RootConfig.class };
        Class<?>[] servletClasses = new Class[] { WebConfig.class };
        Filter[] filters = new Filter[] { new CharacterEncodingFilter("UTF-8", true, true) };

        // RootAppContext - WebApplicationContext
        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
        rootAppContext.register(contextClasses);

        ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
        servletContext.addListener(listener);



        // ServletAppContext - WebApplicationContext
        AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
        servletAppContext.register(servletClasses);

        FrameworkServlet dispatcherServlet = new DispatcherServlet(servletAppContext);

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping(new String[] { "/" });
        registration.setAsyncSupported(true);



        // Filter
        for (Filter filter : filters) {
            String filterName = Conventions.getVariableName(filter);
            FilterRegistration.Dynamic filterRegistration = servletContext.addFilter(filterName, filter);

            if (filterRegistration == null) {
                int counter = -1;

                while (counter == -1 || filterRegistration == null) {
                    counter++;
                    filterRegistration = servletContext.addFilter(filterName + "#" + counter, filter);
                    Assert.isTrue(counter < 100, "Failed to register filter '" + filter + "'." + "Could the same Filter instance have been registered already?");
                }
            }
            filterRegistration.setAsyncSupported(true);

            EnumSet<DispatcherType> getDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC);

            filterRegistration.addMappingForServletNames(getDispatcherTypes, false, "dispatcher");
        }
    }
}
