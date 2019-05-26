package ru.saubanova.app;

import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.Formatter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringBootDemoApplication {

  @Autowired
  private Environment environment;

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  @Bean
  @Primary
  public Formatter<LocalDateTime> localDateTimeFormatter() {
    return new Formatter<LocalDateTime>() {
      @Override
      public LocalDateTime parse(String text, Locale locale) {
        return LocalDateTime.parse(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
      }

      @Override
      public String print(LocalDateTime object, Locale locale) {
        return object.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
      }
    };
  }

  @Bean
  public RedmineManager redmineManager(){
    RedmineManager result = RedmineManagerFactory.createWithApiKey(environment.getProperty("redmine.uri"),environment.getProperty("redmine.apiAccessKey"));
    return result;
  }

  @Bean
  public IssueManager issueManager(){
    return redmineManager().getIssueManager();
  }
  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoApplication.class, args);
  }

}
