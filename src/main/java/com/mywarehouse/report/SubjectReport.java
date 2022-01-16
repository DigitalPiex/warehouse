package com.mywarehouse.report;

import com.mywarehouse.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectReport implements Comparable<SubjectReport> {
    private Subject subject;
    private double averageMarkValue;

    @Override
    public int compareTo(SubjectReport subjectReport) {
        return Integer.compare(this.subject.getName().length(), subjectReport.subject.getName().length());
    }
}
