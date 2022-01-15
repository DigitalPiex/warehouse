package com.mywarehouse.report;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StudentReport {
    private List<SubjectReport> subjectReport;
}
