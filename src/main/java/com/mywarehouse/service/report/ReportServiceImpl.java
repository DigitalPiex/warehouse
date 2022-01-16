package com.mywarehouse.service.report;

import com.mywarehouse.entity.Mark;
import com.mywarehouse.entity.Student;
import com.mywarehouse.report.ReportResponse;
import com.mywarehouse.report.StudentReport;
import com.mywarehouse.report.SubjectReport;
import com.mywarehouse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReportServiceImpl implements ReportService {

    private final StudentRepository studentRepository;

    @Autowired
    public ReportServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ReportResponse generateReport(String studentName) {
        List<Student> studentList = StreamSupport
                .stream(studentRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        if (StringUtils.hasText(studentName)) {
            studentList = studentList.stream()
                    .filter(currentStudent -> currentStudent.getSurname().equals(studentName))
                    .collect(Collectors.toList());
        }

        List<StudentReport> studentReports = studentList.stream()
                .map(student ->
                        new StudentReport(
                                student,
                                student.getSubjects()
                                        .stream()
                                        .map(subject -> new SubjectReport(
                                                        subject,
                                                        subject.getStudents()
                                                                .stream()
                                                                .filter(currentStudent -> currentStudent.getSurname().equals(student.getSurname()))
                                                                .flatMap(currentStudent -> currentStudent.getMarks().stream())
                                                                .filter(mark -> mark.getSubject().equals(subject))
                                                                .mapToDouble(Mark::getValue)
                                                                .average().orElse(0.0)
                                                )
                                        )
                                        .sorted()
                                        .collect(Collectors.toList()))
                )
                .sorted()
                .collect(Collectors.toList());

        ReportResponse reportResponse = new ReportResponse();
        reportResponse.setStudentReport(studentReports);
        return reportResponse;
    }
}
