package com.majesteye.solrj;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Properties;

import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.junit.Ignore;
import org.junit.Test;

/**
 * SolrClientFactory
 */
public class SolrClientFactoryTest {

    @Test
    public void shouldCreateConcurrentClient() throws IOException {
        ConcurrentUpdateSolrClient solr = SolrClientFactory.getConcurrentClient();

        assertNotNull("Client Instance should not be NULL", solr);
    }

    @Test
    @Ignore
    public void shouldLoadProperties() throws IOException {
        Properties props = SolrClientFactory.loadConfig();

        assertNotNull("Props Should not be NULL", props);
        assertEquals("Should Load solr url", "http://localhost:8983/solr", props.getProperty("urls"));
    }
}