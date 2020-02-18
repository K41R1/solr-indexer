package com.majesteye.solrj.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;;

/**
 * CliParser
 */
public abstract class CliParser {

    /**
     * @return Options
     */
    private static Options buildOptions() {
        Options options = new Options();

        Option schemaPath = new Option("s", true, "path to schema.yml");
        schemaPath.setRequired(true);

        options.addOption(schemaPath);
        return options;
    }

    /**
     * @param String[] args
     * @return CommandLineParser
     */
    private static CommandLineParser getParser(String[] args) {
        CommandLineParser parser = new DefaultParser();
        return parser;
    }

    /**
     * @param String[] args
     * @return CommandLine
     * @throws ParseException
     */
    public static CommandLine getCommandLineInstance(String[] args) throws ParseException {
        CommandLineParser parser = CliParser.getParser(args);
        Options options = CliParser.buildOptions();
        return parser.parse(options, args);
    }
}