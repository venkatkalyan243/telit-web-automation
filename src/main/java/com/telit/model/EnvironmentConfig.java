package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvironmentConfig {
  @JsonProperty("url")
  private String url;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "EnvironmentConfig{" +
        "url='" + url + '\'' +
        '}';
  }
}
