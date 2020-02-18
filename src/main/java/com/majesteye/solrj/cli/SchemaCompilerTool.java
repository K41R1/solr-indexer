package com.majesteye.solrj.cli;

import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.majesteye.solrj.cli.schema.Schema;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

/**
 * SchemaCompilerTool
 */
public class SchemaCompilerTool {

    public static void main(String[] args)
            throws ParseException, JsonSyntaxException, JsonIOException, ClassNotFoundException, IOException {
        CommandLine cmd = CliParser.getCommandLineInstance(args);    
        Schema schema = JSONParser.parse(cmd.getOptionValue("s"));
        ModelBuilder builder = new ModelBuilder(schema);
        builder.initModel().buildFields().build();
    }

}