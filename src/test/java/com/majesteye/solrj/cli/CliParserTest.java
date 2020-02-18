package com.majesteye.solrj.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

/**
 * CliParserTest
 */
public class CliParserTest {

    @Test
    public void getCommandLineInstanceShouldWork() throws ParseException {
        String[] args = {"-s", "data/films.yml"};
        CommandLine cmd = CliParser.getCommandLineInstance(args);
        
        assertNotNull("cmd Should Be Not Null", cmd);
        assertTrue("cmd Should Be instance of CommandLine Class", cmd instanceof CommandLine);
    }

    @Test
    public void shouldRetrieveArgs() throws ParseException {
        String[] args = {"-s", "data/films.yml"};
        CommandLine cmd = CliParser.getCommandLineInstance(args);
        String path = cmd.getOptionValue("s");

        assertEquals("data/films.yml", path);
    }
}