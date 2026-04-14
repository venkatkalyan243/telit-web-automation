package com.telit.pojo;

public class EnvironmentConfig {
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
