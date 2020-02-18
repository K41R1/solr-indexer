package com.majesteye.solrj.cli;

import java.io.File;
import java.io.IOException;

import javax.lang.model.element.Modifier;

import com.majesteye.solrj.cli.schema.Field;
import com.majesteye.solrj.cli.schema.Schema;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;

/**
 * ModelBuilder
 */
public class ModelBuilder {

    private Schema schema;
    private String namespace;
    private Builder model;

    public ModelBuilder(Schema schema) {
        this.schema = schema;
        this.namespace = schema.getNamespace();
    }

    public ModelBuilder initModel() {
        this.model = TypeSpec.classBuilder(schema.getClassName()).addModifiers(Modifier.PUBLIC)
                .addMethod(generateEmptyConstructor());
        return this;
    }

    public void build() throws IOException {
        TypeSpec model = this.model.build();
        JavaFile file =  JavaFile.builder(namespace, model).build();
        File file2 = new File("/home/khairi/Workspace/indexer/src/main/java" + schema.getNamespace().replaceAll(".", "/"));
        file.writeTo(file2);
    }

    public ModelBuilder buildFields() throws ClassNotFoundException {
        for (Field field : this.schema.getFields()) {
            if (field.getType().contains("<")) {
                addField(field, true);
            } else {
                addField(field);
            }
        }
        return this;
    }

    private void addField(Field field,boolean isParametrized) throws ClassNotFoundException {
        String[] chunks = field.getType().split("<|>");
        String rawType = chunks[0];
        String typeArgument = chunks[1];
        this.model.addField(
            FieldSpec.builder(ParameterizedTypeName.get(Class.forName(rawType), Class.forName(typeArgument)), field.getName())
            .addAnnotation(org.apache.solr.client.solrj.beans.Field.class)
            .addModifiers(Modifier.PUBLIC)
            .build()
        );
    }

    private void addField(Field field) throws ClassNotFoundException {
        this.model.addField(
            FieldSpec.builder(Class.forName(field.getType()), field.getName())
            .addAnnotation(org.apache.solr.client.solrj.beans.Field.class)
            .addModifiers(Modifier.PUBLIC)
            .build()
        );
        
        //Class.forName(field.getType()), field.getName(), Modifier.PUBLIC
    }

    private MethodSpec generateEmptyConstructor() {
        return MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .build();
    }
}