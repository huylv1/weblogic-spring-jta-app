package com.baoviet.mhol.web.config;

import javax.servlet.*;

import com.google.common.collect.Sets;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.EnumSet;

/**
 * Created by levietcongitsol on 7/10/2017.
 */
public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        sc.setSessionTrackingModes(Sets.immutableEnumSet(SessionTrackingMode.COOKIE));
        SessionCookieConfig cookieConfig = sc.getSessionCookieConfig();
        cookieConfig.setHttpOnly(true);

        // Spring Root Context
        /*XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
        rootContext.setConfigLocation("classpath:applicationContext.xml");*/

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        sc.addListener(new ContextLoaderListener(rootContext));

        // Spring Servlet Context
        AnnotationConfigWebApplicationContext servletContext = new AnnotationConfigWebApplicationContext();
        servletContext.register(ServletConfig.class);
        ServletRegistration.Dynamic dispatcher = sc.addServlet("pmpServlet", new DispatcherServlet(servletContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        FilterRegistration.Dynamic characterEncoding = sc.addFilter("Encoding Filter", characterEncodingFilter);
        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");

        /*FilterRegistration.Dynamic security = sc.addFilter("springSecurityFilterChain", new DelegatingFilterProxy());
        security.addMappingForUrlPatterns(dispatcherTypes, true, "/*");*/
    }

}
