package com.mywarehouse.service.report;

import com.mywarehouse.entity.Mark;
import com.mywarehouse.entity.Student;
import com.mywarehouse.entity.Subject;
import com.mywarehouse.service.mark.MarkService;
import com.mywarehouse.service.student.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {

    ReportService reportService;

    @Mock
    StudentService studentService;

    @Mock
    MarkService markService;

    @BeforeEach
    void setUp() {
        reportService = new ReportServiceImpl(studentService, markService);
    }

    @Test
    void generateReport() {
        Subject subjectMock = new Subject(1L, "VishMat", new ArrayList<>(), new ArrayList<>());
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subjectMock);
        Student studentMock1 = new Student(1L, "Egor", new ArrayList<>(), subjectList);
        Student studentMock2 = new Student(2L, "Mariya", new ArrayList<>(), subjectList);
        List<Student> studentList = new ArrayList<>();
        studentList.add(studentMock1);
        studentList.add(studentMock2);
        Mark markMock1 = new Mark(1L, 5, studentMock1, subjectMock);
        Mark markMock2 = new Mark(2L, 4, studentMock2, subjectMock);
        List<Mark> markList = new ArrayList<>();
        markList.add(markMock1);
        markList.add(markMock2);
        when(studentService.findAll()).thenReturn(studentList);
        when(markService.findAll()).thenReturn(markList);
        String reportCSV = reportService.generateReport("").toString();
        assertThat(reportCSV).isNotNull().isNotEmpty();
        assertThat(reportCSV).isEqualTo("Egor,VishMat,5.0\n" + "Mariya,VishMat,4.0\n");
    }
}