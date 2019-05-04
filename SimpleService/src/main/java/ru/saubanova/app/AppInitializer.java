package ru.saubanova.app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.saubanova.config.AppConfig;
import ru.saubanova.filter.UserAuthFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(AppConfig.class);

    // для фильтров -- м.б. springContext надо класть
    servletContext.setAttribute("springContext", context);

    context.setServletContext(servletContext);

    DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

    ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
    servlet.setLoadOnStartup(1);
    servlet.addMapping("/");
    servletContext.addFilter("userAuthFilter", UserAuthFilter.class).addMappingForUrlPatterns(null, false, "/*");
  }
}
