package com.majesteye.solrj.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.majesteye.solrj.cli.schema.Schema;

import org.junit.Test;

/**
 * JSONParserTest
 */
public class JSONParserTest {

    @Test
    public void shouldParseAsClass() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        Schema schema = JSONParser.parse("/home/khairi/Workspace/indexer/data/user-schema.json");
        
        assertNotNull(schema);
    }

    @Test
    public void fieldsShouldNotBeEmpty() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        Schema schema = JSONParser.parse("/home/khairi/Workspace/indexer/data/user-schema.json");
        
        assertEquals(3, schema.getFields().size());
        assertEquals("hobbies", schema.getFields().get(2).getName());
        assertEquals("java.util.List<String>", schema.getFields().get(2).getType());
    }
    
}