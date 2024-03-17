package com.springboot.studentManagement.service;

import com.springboot.studentManagement.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(int id);

    Student updateStudent(int id, Student student);

    void deleteStudentById(int id);
}
