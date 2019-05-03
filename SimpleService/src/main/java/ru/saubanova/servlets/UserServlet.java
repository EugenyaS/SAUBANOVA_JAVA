package ru.saubanova.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.saubanova.models.User;
import ru.saubanova.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class UserServlet extends HttpServlet {
  UserService userService;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<User> users = userService.getAllUsers();
    req.setAttribute("users",users);
    req.getRequestDispatcher("WEB-INF/jsp/users_pages.jsp").forward(req,resp);
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("springContext");
    userService = context.getBean(UserService.class);
  }
}
