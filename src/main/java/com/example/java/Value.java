package com.example.java;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Jackson JSON processing library to indicate that any properties not bound in this type should be ignored
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

  private Long id;
  private String quote;

  public Value() {
  }

  public Long getId() {
    return this.id;
  }

  public String getQuote() {
    return this.quote;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setQuote(String quote) {
    this.quote = quote;
  }

  @Override
  public String toString() {
    return "Value{" + "id=" + id + ", quote='" + quote + '\'' + '}';
  }
}