package com.majesteye.solrj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * SolrClientFactory
 */
public abstract class SolrClientFactory {

    private final static String PROPS_FILE = "src/main/resources/solr.properties";
    private static Properties properties;
    
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