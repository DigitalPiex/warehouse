package com.mywarehouse.service.student;

import com.mywarehouse.entity.Student;

import java.util.List;

public interface StudentService {
    Student findStudentById(Long id);

    Student findStudentBySurname(String surname);

    List<Student> findAllStudents();

    Student saveStudent(Student student);

    void updateStudent(Long id, Student student);

    void deleteStudent(Long id);
}