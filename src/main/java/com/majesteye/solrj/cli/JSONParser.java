package com.majesteye.solrj.cli;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.majesteye.solrj.cli.schema.Schema;

/**
 * JSONParser
 */
public abstract class JSONParser {

    /**
     * @param schemaPath
     * @return
     * @throws FileNotFoundException
     * @throws JsonIOException
     * @throws JsonSyntaxException
     */
    public static Schema parse(String schemaPath) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
        return new Gson().fromJson(new FileReader(schemaPath), Schema.class);
    }
}