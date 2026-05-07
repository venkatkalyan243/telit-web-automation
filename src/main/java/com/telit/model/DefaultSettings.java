package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telit.constant.BrowserType;
import com.telit.constant.EnvironmentType;

public class DefaultSettings {
  @JsonProperty("browser")
  private BrowserType browser;

  @JsonProperty("environment")
  private EnvironmentType environment;

  public BrowserType getBrowser() {
    return browser;
  }

  public void setBrowser(BrowserType browser) {
    this.browser = browser;
  }

  public EnvironmentType getEnvironment() {
    return environment;
  }

  public void setEnvironment(EnvironmentType environment) {
    this.environment = environment;
  }

  @Override
  public String toString() {
    return "DefaultSettings{" +
        "browser=" + browser +
        ", environment=" + environment +
        '}';
  }
}
