package com.ml.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("req","request作用域");
        HttpSession session = req.getSession();
        session.setAttribute("sess","session作用域");
        ServletContext application = req.getServletContext();
        application.setAttribute("app","application作用域");

        req.getRequestDispatcher("/scope.jsp").forward(req,resp);

        resp.sendRedirect(req.getContextPath() + "/scope.jsp");
    }
}
