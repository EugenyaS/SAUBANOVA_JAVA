package ru.saubanova.filters;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.saubanova.models.User;
import ru.saubanova.models.UserAuth;
import ru.saubanova.repositories.UserAuthRepository;
import ru.saubanova.services.UserAuthService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/*")
public class UserAuthFilter implements Filter {
  UserAuthService userAuthService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    ApplicationContext context = (ApplicationContext) filterConfig.getServletContext().getAttribute("springContext");
    userAuthService = context.getBean(UserAuthService.class);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    if (forProtectedRequest(request)) {
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if (cookie.getName().equals("CLIENT_ID")) {
            Optional<User> candidateUser = userAuthService.findUserByCookie(cookie);
            if (candidateUser.isPresent()) {
              filterChain.doFilter(request, servletResponse);
              return;
            } else {
              response.sendRedirect("/signIn");
              return;
            }
          }
        }
      }
      response.sendRedirect("/signIn");
      return;
    }else {
      filterChain.doFilter(request, response);
    }
  }


  @Override
  public void destroy () {

  }

  private boolean forProtectedRequest(HttpServletRequest request) {
    String path = request.getServletPath();
    return !(path.equals("/signIn") || path.equals("/signUp"));
  }
}