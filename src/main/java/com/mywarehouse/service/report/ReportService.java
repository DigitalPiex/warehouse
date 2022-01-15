package com.mywarehouse.service.report;

import com.mywarehouse.report.ReportResponse;

public interface ReportService {
    ReportResponse generateReport();

    ReportResponse generateReport(String name);
}
