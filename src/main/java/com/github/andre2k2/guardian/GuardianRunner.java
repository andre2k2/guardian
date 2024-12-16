package com.github.andre2k2.guardian;

import org.apache.commons.cli.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuardianRunner {

    private final PomService pomService;

    @Autowired
    public GuardianRunner(PomService pomService) {
        this.pomService = pomService;
    }

    public void run(String[] args) {
        CommandLineParser parser = new CommandLineParser();
        try {
            parser.parse(args);

            String scanPath = parser.getScanPath();
            String reportsPath = parser.getReportsPath();
            boolean fixPom = parser.isFixPom();

            System.out.println("Scanning project directory: " + scanPath);

            if (fixPom) {
                pomService.fixPom(scanPath);
            }
        } catch (ParseException e) {
            System.err.println("Error parsing command line arguments: " + e.getMessage());
        }
    }
}