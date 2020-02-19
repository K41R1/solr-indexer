package com.majesteye.solrj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;

/**
 * SolrClientFactory
 */
public abstract class SolrClientFactory {

    private final static String PROPS_FILE = "src/main/resources/solr.properties";
    
    private static Properties properties;
    
    /**
     * ConcurrentUpdateSolrClient - geared towards indexing-centric workloads. Buffers documents internally before sending larger batches to Solr.
     * @return client
     * @throws IOException
     */
    public static ConcurrentUpdateSolrClient getConcurrentClient() throws IOException {
        String urls = loadConfig().getProperty("urls");
        ConcurrentUpdateSolrClient solr = new ConcurrentUpdateSolrClient.Builder(urls).build();
        
        return solr;
    }

    public static Properties loadConfig() throws IOException {
        if (properties == null) {
            FileInputStream inputStream = new FileInputStream(new File(PROPS_FILE));
            Properties props = new Properties();
            props.load(inputStream);
            properties = props;   
        }
        return properties;
    }
}