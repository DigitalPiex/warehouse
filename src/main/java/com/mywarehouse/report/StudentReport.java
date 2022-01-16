package com.mywarehouse.report;

import com.mywarehouse.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentReport implements Comparable<StudentReport> {
    private Student student;
    private List<SubjectReport> subjectReport;

    @Override
    public int compareTo(StudentReport studentReport) {
        return Integer.compare(this.student.getSurname().length(), studentReport.getStudent().getSurname().length());
    }
}
