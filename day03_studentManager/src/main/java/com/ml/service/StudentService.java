package com.ml.service;

import com.ml.pojo.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudentList() throws Exception;

    List<Student> getStudentList2() throws Exception;

    boolean addStudent(Student student);

    boolean checkName(String name);
}
