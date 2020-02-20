package com.majesteye.solrj.job;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.majesteye.solrj.SolrClientFactory;
import com.majesteye.solrj.example.Film;

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
        final CommandLine cmd = CliParser.getCommandLineInstance(args);
        final String collection = cmd.getOptionValue("c");
        final String source = cmd.getOptionValue("s");
        final ConcurrentUpdateSolrClient solr = SolrClientFactory.getConcurrentClient();
        Film[] films = gson.fromJson(new FileReader(source), Film[].class);

        for (Film film : films) {
            solr.addBean(collection, film, 20000);
        }

        solr.commit(collection);
    }
}