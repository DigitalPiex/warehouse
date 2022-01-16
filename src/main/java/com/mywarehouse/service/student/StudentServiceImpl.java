package com.mywarehouse.service.student;

import com.mywarehouse.entity.Student;
import com.mywarehouse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findStudentById(Long id) {
        return null;
    }

    @Override
    public Student findStudentBySurname(String surname) {
        return null;
    }

    @Override
    public List<Student> findAllStudents() {
        return null;
    }

    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public void updateStudent(Long id, Student student) {

    }

    @Override
    public void deleteStudent(Long id) {

    }
}
