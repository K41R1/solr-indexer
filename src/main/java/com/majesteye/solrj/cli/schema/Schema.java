package com.majesteye.solrj.cli.schema;

import java.io.Serializable;
import java.util.List;

/**
 * Schema
 */
public class Schema implements Serializable {

    private static final long serialVersionUID = 2236148588720743287L;

    public String namespace;

    public List<Field> fields;

    private String className;

    public Schema() {
    }

    /**
     * @param namespace
     * @param fields
     */
    public Schema(String namespace, String className, List<Field> fields) {
        this.namespace = namespace;
        this.className = className;
        this.fields = fields;
    }

    /**
     * @return the namespace
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    /**
     * @param namespace the namespace to set
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

}