package com.mywarehouse.restcontroller;

import com.mywarehouse.report.ReportResponse;
import com.mywarehouse.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report/v1")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report")
    public ResponseEntity<ReportResponse> getReportService(@RequestParam(required = false) String studentName) {
        ReportResponse reportResponse = reportService.generateReport(studentName);
        return ResponseEntity.ok(reportResponse);
    }
}
