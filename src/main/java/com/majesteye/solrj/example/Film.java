package com.majesteye.solrj.example;

import java.lang.String;
import java.util.List;
import org.apache.solr.client.solrj.beans.Field;

public class Film {
  @Field
  public List<String> genre;

  @Field
  public String id;

  @Field
  public List<String> directed_by;

  @Field
  public String initial_release_date;

  @Field
  public String name;

  public Film() {
  }

  @Override
  public String toString() {
    return "name";
  }
}
