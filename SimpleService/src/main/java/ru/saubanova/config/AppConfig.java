package ru.saubanova.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;


@Configuration
@EnableWebMvc
@ComponentScan("ru.saubanova")
@PropertySource("classpath:ru.saubanova.config\\db.properties")
public class AppConfig {

  @Autowired
  private Environment environment;

  @Bean
  public ViewResolver viewResolver(){
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(environment.getProperty("db.driver"));
    dataSource.setUrl(environment.getProperty("db.url"));
    dataSource.setUsername(environment.getProperty("db.username"));
    dataSource.setPassword(environment.getProperty("db.password"));
    return dataSource;
  }

}
