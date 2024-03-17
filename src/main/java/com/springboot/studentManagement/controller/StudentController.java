package com.springboot.studentManagement.controller;

import com.springboot.studentManagement.dto.Student;
import com.springboot.studentManagement.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {
        log.info("StudentController :: Get all students");
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        log.info("StudentController :: Add new student");
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";

    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        log.info("StudentController :: Save new student record");
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        log.info("StudentController :: Edit student details by student ID");
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
        log.info("StudentController :: Update student with given student ID");
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        log.info("StudentController :: Delete student with given student ID");
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
