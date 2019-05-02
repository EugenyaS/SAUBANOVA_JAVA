package ru.saubanova.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try {
      PrintWriter writer = resp.getWriter();
      writer.print("<h1>Hello!</h1>");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }
}
