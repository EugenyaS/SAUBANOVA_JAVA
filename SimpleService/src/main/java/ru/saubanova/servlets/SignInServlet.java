package ru.saubanova.servlets;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.saubanova.dto.AuthUserDto;
import ru.saubanova.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {
  private UserService userService;

  @Override
  public void init(ServletConfig config)  {
    ApplicationContext context = new ClassPathXmlApplicationContext("ru.saubanova.config\\context.xml");
    userService = context.getBean(UserService.class);
  }

  @Override
  @SneakyThrows
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    PrintWriter writer = resp.getWriter();
    writer.print("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<title>Sign In</title>\n" +
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
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
    AuthUserDto userDto = AuthUserDto.builder()
            .login(req.getParameter("login"))
            .password(req.getParameter("password"))
            .build();
    Optional<String> cookieValue =userService.signInAndCreateCookie(userDto);
    if (cookieValue.isPresent()) {
      Cookie cookie = new Cookie("CLIENT_ID", cookieValue.get());
      resp.addCookie(cookie);
      resp.sendRedirect("/hello");
    }
    else {
      resp.sendRedirect("/signIn");
    }
  }
}
