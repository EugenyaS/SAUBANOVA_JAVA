package ru.saubanova.filters;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.saubanova.models.UserAuth;
import ru.saubanova.repositories.UserAuthRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/*")
public class UserAuthFilter implements Filter {
  UserAuthRepository userAuthRepository;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    ApplicationContext context = new ClassPathXmlApplicationContext("ru.saubanova.config\\context.xml");
    userAuthRepository = context.getBean(UserAuthRepository.class);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("CLIENT_ID")) {
          Optional<UserAuth> userAuth = userAuthRepository.getOneByCookie(cookie.getValue());
          if (userAuth.isPresent()) {
            System.out.println(userAuth.get().getUser().getLogin());
            filterChain.doFilter(request, servletResponse);
          } else {
            System.out.println("Пользователь не найден");
            filterChain.doFilter(request, servletResponse);
          }
        }
      }
    } else {
      System.out.println("no cookie");
      filterChain.doFilter(request, servletResponse);
    }
  }


  @Override
  public void destroy() {

  }
}
