
package org.learnxp;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// @ComponentScan("org.learnxp")
public class WebAppConfiguration implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.setServletContext(servletContext);
        rootContext.register(org.learnxp.WebMvcConfiguration.class);

		System.out.println("In the onStartup");
        Dynamic servlet = servletContext.addServlet("org.learnxp.MyServlet", 
				new DispatcherServlet(rootContext));

        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
		
    }
}
