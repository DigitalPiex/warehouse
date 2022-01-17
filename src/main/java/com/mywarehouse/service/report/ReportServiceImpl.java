package com.mywarehouse.service.report;

import com.mywarehouse.entity.Mark;
import com.mywarehouse.entity.Student;
import com.mywarehouse.entity.Subject;
import com.mywarehouse.report.ReportResponse;
import com.mywarehouse.report.StudentReport;
import com.mywarehouse.report.SubjectReport;
import com.mywarehouse.service.mark.MarkService;
import com.mywarehouse.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final StudentService studentService;
    private final MarkService markService;

    @Autowired
    public ReportServiceImpl(StudentService studentService, MarkService markService) {
        this.studentService = studentService;
        this.markService = markService;
    }

    @Override
    public ReportResponse generateReport(String studentName) {

        List<Student> students = studentService.findAll();
        if (StringUtils.hasText(studentName)) {
            students = students.stream()
                    .filter(student -> student.getSurname().equals(studentName))
                    .collect(Collectors.toList());
        }

        Map<Student, List<Subject>> studentsSubjects = students.stream()
                .collect(Collectors.toMap(student -> student, Student::getSubjects));

        ReportResponse reportResponse = new ReportResponse();
        reportResponse.setStudentReport(new ArrayList<>());

        List<Mark> marks = markService.findAll();

        studentsSubjects.forEach((student, subjects) -> {
            StudentReport studentReport = new StudentReport();
            studentReport.setStudent(student);
            studentReport.setSubjectReport(new ArrayList<>());
            subjects.forEach(subject -> {
                SubjectReport subjectReport = new SubjectReport();
                double avgMarkValue = marks.stream()
                        .filter(mark -> mark.getStudent().equals(student))
                        .filter(mark -> mark.getSubject().equals(subject))
                        .mapToDouble(Mark::getValue)
                        .average().orElse(0.0);
                subjectReport.setSubject(subject);
                subjectReport.setAverageMarkValue(avgMarkValue);
                studentReport.getSubjectReport().add(subjectReport);
            });
            Collections.sort(studentReport.getSubjectReport());
            reportResponse.getStudentReport().add(studentReport);
        });
        Collections.sort(reportResponse.getStudentReport());
        return reportResponse;
    }
}