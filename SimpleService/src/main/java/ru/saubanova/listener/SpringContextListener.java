package ru.saubanova.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringContextListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    ApplicationContext context = new ClassPathXmlApplicationContext("ru.saubanova.config\\context.xml");
    ServletContext servletContext = servletContextEvent.getServletContext();
    servletContext.setAttribute("springContext", context);
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}
