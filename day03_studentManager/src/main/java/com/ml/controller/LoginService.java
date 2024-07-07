package com.ml.controller;

import com.ml.pojo.User;
import com.ml.service.UserService;
import com.ml.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginService extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = userService.login(username, password);
        System.out.println("u = " + u);

        if (u != null) {
            req.getSession().setAttribute("user", u);
            resp.sendRedirect(req.getContextPath() + "/getStudentList");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp?flag=false");
            //req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

}
