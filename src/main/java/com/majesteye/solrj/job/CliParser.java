package com.majesteye.solrj.job;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * CliParser
 */
public class CliParser {

    /**
     * @return Options
     */
    private static Options buildOptions() {
        Options options = new Options();
        
        Option source = new Option("s", "source", true, "path to source file");
        source.setRequired(true);

        Option model = new Option("m", "model", true, "Model Class (FQCN) to use");
        model.setRequired(true);

        Option collection = new Option("c", "collection", true, "documents index collection");
        collection.setRequired(true);

        options.addOption(source);
        options.addOption(model);
        options.addOption(collection);
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