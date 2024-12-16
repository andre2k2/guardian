package com.github.andre2k2.guardian;

import org.springframework.stereotype.Service;


@Service
public class ReportService {

    public Report loadVulnerabilities(String reportsPath) {
        return new Report(null);
    }
}
