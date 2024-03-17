package com.springboot.studentManagement.service;

import com.springboot.studentManagement.dto.Student;
import com.springboot.studentManagement.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        log.info("StudentService :: Get All Students");
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        log.info("StudentService :: Save new student record");
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        log.info("StudentService :: Get student by student ID");
        return studentRepository.findById(id).isPresent() ? studentRepository.findById(id).get() : new Student();
    }

    @Override
    public Student updateStudent(int id, Student student) {
        log.info("StudentService :: Update student with given student ID");
        Student existingStudent = studentRepository.findById(id).isPresent() ? studentRepository.findById(id).get() : new Student();
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudentById(int id) {
        log.info("StudentService :: Delete student with given student ID");
        studentRepository.deleteById(id);
    }
}
