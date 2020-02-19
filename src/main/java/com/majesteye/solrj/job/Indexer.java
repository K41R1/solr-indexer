package com.majesteye.solrj.job;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.majesteye.solrj.SolrClientFactory;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;

/**
 * Indexer
 */
public class Indexer {

    private static final Gson gson = new Gson();

    public static void main(final String[] args) throws ParseException, IOException, JsonSyntaxException,
            JsonIOException, ClassNotFoundException, SolrServerException {
        String[] params = { "-m", "com.majesteye.solrj.example.Film", "-s",
                "example/data/films.json", "-c", "films" };
        final CommandLine cmd = CliParser.getCommandLineInstance(params);
        final String collection = cmd.getOptionValue("c");
        final ConcurrentUpdateSolrClient solr = SolrClientFactory.getConcurrentClient();
    }
}