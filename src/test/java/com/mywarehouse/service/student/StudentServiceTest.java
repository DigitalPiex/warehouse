package com.mywarehouse.service.student;

import com.mywarehouse.entity.Student;
import com.mywarehouse.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    void findBySurname() {
        Student studentMock = new Student(1L, "Egor", new ArrayList<>(), new ArrayList<>());
        when(studentRepository.findBySurname(anyString())).thenReturn(studentMock);
        Student student = studentService.findBySurname("Egor");
        assertThat(student).isNotNull();
        assertThat(student.getSurname()).isEqualTo("Egor");
    }
}