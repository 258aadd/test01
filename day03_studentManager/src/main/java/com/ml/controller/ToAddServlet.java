package com.ml.controller;

import com.ml.pojo.Grade;
import com.ml.service.GradeService;
import com.ml.service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toAdd")
public class ToAddServlet extends HttpServlet {
    private GradeService gradeService = new GradeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Grade> gradeList = gradeService.getGradeList();
        req.setAttribute("gradeList", gradeList);
        req.getRequestDispatcher("/addStudent.jsp").forward(req, resp);
    }
}
