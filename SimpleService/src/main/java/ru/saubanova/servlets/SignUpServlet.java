package ru.saubanova.servlets;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.saubanova.dto.AuthUserDto;
import ru.saubanova.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class SignUpServlet extends HttpServlet {
  private UserService userService;

  @Override
  public void init(ServletConfig config)  {
    ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("springContext");
    userService = context.getBean(UserService.class);
  }

  @Override
  @SneakyThrows
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    PrintWriter writer = resp.getWriter();
    writer.print("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<title>Sign Up</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div>\n" +
            "\t<form method='post'>\n" +
            "\t\t<input type=\"text\" name=\"login\" placeholder=\"Login\">\n" +
            "\t\t<input type=\"password\" name=\"password\" placeholder=\"Password\">\n" +
            "\t\t<input type=\"submit\"  value=\"signUp\">\n" +
            "\t</form>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>");
  }

  @Override
  @SneakyThrows
  protected void doPost(HttpServletRequest req, HttpServletResponse resp){
    AuthUserDto userDto = AuthUserDto.builder()
            .login(req.getParameter("login"))
            .password(req.getParameter("password"))
            .build();
    userService.signUp(userDto);
    resp.sendRedirect("/signIn");
  }
}
