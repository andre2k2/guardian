package com.github.andre2k2.guardian;

import org.apache.commons.cli.*;

public class CommandLineParser {

    private final Options options;
    private CommandLine cmd;

    public CommandLineParser() {
        options = new Options();

        Option scanOption = new Option("scan", true, "path to project directory");
        scanOption.setRequired(true);
        options.addOption(scanOption);

        Option reportsOption = new Option("reports", true, "path to vulnerability report directory");
        reportsOption.setRequired(true);
        options.addOption(reportsOption);

        Option fixPomOption = new Option("fixPom", false, "fix POM file");
        options.addOption(fixPomOption);
    }

    public void parse(String[] args) throws ParseException {
        org.apache.commons.cli.CommandLineParser parser = new DefaultParser();
        cmd = parser.parse(options, args);
    }

    public String getScanPath() {
        return cmd.getOptionValue("scan");
    }

    public String getReportsPath() {
        return cmd.getOptionValue("reports");
    }

    public boolean isFixPom() {
        return cmd.hasOption("fix-pom");
    }
}