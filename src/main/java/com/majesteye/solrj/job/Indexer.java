package com.majesteye.solrj.job;

import java.io.IOException;

import com.majesteye.solrj.SolrClientFactory;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;

/**
 * Indexer
 */
public class Indexer {

    public static void main(String[] args) throws ParseException, IOException {
        CommandLine cmd = CliParser.getCommandLineInstance(args); 
        ConcurrentUpdateSolrClient solr = SolrClientFactory.getConcurrentClient();
        
    }
}