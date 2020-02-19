package com.majesteye.solrj.job;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

/**
 * CliParserTest
 */
public class CliParserTest {

    private final String[] withSortArgs = { "-m", "com.majesteye.example.Film", "-s",
            "example/data/films.json", "-c", "films" };
    private final String[] withLongArgs = { "--model", "com.majesteye.example.Film", "--source",
            "example/data/films.json", "--collection", "films" };

    @Test
    public void shouldMatchWithShortArgs() throws ParseException {
        CommandLine cmd = CliParser.getCommandLineInstance(withSortArgs);
        
        assertNotNull(cmd);
        assertEquals("com.majesteye.example.Film", cmd.getOptionValue("m"));
        assertEquals("example/data/films.json", cmd.getOptionValue("s"));
        assertEquals("films", cmd.getOptionValue("c"));
    }

    @Test
    public void shouldMatchWithLongArgs() throws ParseException {
        CommandLine cmd = CliParser.getCommandLineInstance(withLongArgs);
        
        assertNotNull(cmd);
        assertEquals("com.majesteye.example.Film", cmd.getOptionValue("model"));
        assertEquals("example/data/films.json", cmd.getOptionValue("source"));
        assertEquals("films",cmd.getOptionValue("collection"));
    }
}