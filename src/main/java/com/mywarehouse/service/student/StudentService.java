package com.mywarehouse.service.student;

import com.mywarehouse.entity.Student;

import java.util.List;

public interface StudentService {
    Student findById(Long id);

    Student findBySurname(String surname);

    List<Student> findAll();

    Student save(Student student);

    void delete(Long id);
}