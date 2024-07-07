package com.ml.controller;

import com.ml.pojo.Student;
import com.ml.service.StudentService;
import com.ml.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getStudentList")
public class GetStudentListService extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
//调用业务层查询所有学生信息的方法
        List<Student>studentList;
        try {
            studentList = studentService.getStudentList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("studentList="+studentList);
        req.setAttribute("slist",studentList);
        req.getRequestDispatcher("/studentlist.jsp").forward(req, resp);
    }
}
