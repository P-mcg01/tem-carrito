package com.emergentes.carrito;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

@WebServlet(name = "ProcesaServlet", urlPatterns = {"/ProcesaServlet"})
public class ProcesaServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    HttpSession ses = request.getSession();
    ses.invalidate();
    response.sendRedirect("index.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String producto = request.getParameter("producto");
    HttpSession ses = request.getSession();
    
    ArrayList<String> lista = (ArrayList<String>)ses.getAttribute("lista");
    lista.add(producto);
    response.sendRedirect("index.jsp");
  }
}
