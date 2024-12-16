package com.github.andre2k2.guardian;

import org.apache.commons.cli.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuardianRunner {

    private final PomService pomService;
    private final ProjectService projectService;
    private final ReportService reportService;

    @Autowired
    public GuardianRunner(PomService pomService, ProjectService projectService, ReportService reportService) {
        this.pomService = pomService;
        this.projectService = projectService;
        this.reportService = reportService;
    }

    public void run(String[] args) {
        CommandLineParser parser = new CommandLineParser();
        try {
            parser.parse(args);

            String scanPath = parser.getScanPath();
            String reportsPath = parser.getReportsPath();
            boolean fixPom = parser.isFixPom();

            Project project = projectService.loadProject(scanPath);
            Report report = reportService.loadVulnerabilities(reportsPath);
            if (fixPom) {
                pomService.fixPom(report, project);
            }
        } catch (ParseException e) {
            System.err.println("Error parsing command line arguments: " + e.getMessage());
        }
    }
}