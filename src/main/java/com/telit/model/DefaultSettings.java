package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telit.constant.BrowserType;
import com.telit.constant.EnvironmentType;

public class DefaultSettings {
  @JsonProperty("browser")
  private BrowserType browser;

  @JsonProperty("environment")
  private EnvironmentType environment;

  @JsonProperty("headless")
  private boolean headless;

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

  public boolean isHeadless() {
    return headless;
  }

  public void setHeadless(boolean headless) {
    this.headless = headless;
  }

  @Override
  public String toString() {
    return "DefaultSettings{" +
        "browser=" + browser +
        ", environment=" + environment +
        ", headless=" + headless +
        '}';
  }
}
