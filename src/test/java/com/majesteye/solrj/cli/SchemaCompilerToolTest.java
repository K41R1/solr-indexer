package com.majesteye.solrj.cli;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import org.apache.commons.cli.ParseException;
import org.junit.Test;

/**
 * SchemaCompilerToolTest
 */
public class SchemaCompilerToolTest {

    @Test
    public void shouldCreateJavaClassInAppropriatePackage()
            throws ParseException, JsonSyntaxException, JsonIOException, ClassNotFoundException, IOException {
        String[] args = {"-s", "/home/khairi/Workspace/indexer/data/user-schema.json"};
        SchemaCompilerTool.main(args);
        File classFile = new File("/home/khairi/Workspace/indexer/src/main/java/com/majesteye/solrj/example/Film.java");
        assertTrue("Model Class should be created", classFile.exists());
    }
    
}