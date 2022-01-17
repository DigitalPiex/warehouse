package com.mywarehouse.report;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ReportResponse {
    private List<StudentReport> studentReport;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.getStudentReport().forEach(studentRep -> {
            List<SubjectReport> subjectReport = studentRep.getSubjectReport();
            subjectReport.forEach(subjectRep -> sb.append(studentRep.getStudent().getSurname()).append(",")
                    .append(subjectRep.getSubject().getName()).append(",")
                    .append(subjectRep.getAverageMarkValue()).append("\n"));
        });
        return sb.toString();
    }
}
