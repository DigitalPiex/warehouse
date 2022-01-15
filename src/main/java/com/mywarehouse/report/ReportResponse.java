package com.mywarehouse.report;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ReportResponse {
    private List<StudentReport> studentReport;
}
