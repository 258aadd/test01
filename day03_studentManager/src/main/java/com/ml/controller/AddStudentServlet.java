package com.ml.controller;

import com.ml.pojo.Student;
import com.ml.pojo.User;
import com.ml.service.StudentService;
import com.ml.service.UserService;
import com.ml.service.impl.StudentServiceImpl;
import com.ml.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String sname = req.getParameter("sname");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String gid = req.getParameter("gid");

        Student student = new Student();
        student.setSname(sname);
        student.setGender(gender);

        if (age != null && !"".equals(age)) {
            student.setAge(Integer.parseInt(age));
        }
        if (gid != null && !"".equals(gid)) {
            student.setGid(Integer.parseInt(gid));
        }

        boolean flag = studentService.addStudent(student);

        if (flag) {
            resp.sendRedirect(req.getContextPath() + "/getStudentList");
        }

    }

}
