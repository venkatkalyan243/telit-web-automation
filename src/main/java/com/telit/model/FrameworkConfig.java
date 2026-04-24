package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class FrameworkConfig {
  @JsonProperty("environments")
  private Map<String, EnvironmentConfig> environments;

  @JsonProperty("maxRetry")
  private int maxRetry;

  public Map<String, EnvironmentConfig> getEnvironments() {
    return environments;
  }

  public void setEnvironments(Map<String, EnvironmentConfig> environments) {
    this.environments = environments;
  }

  public int getMaxRetry() {
    return maxRetry;
  }

  public void setMaxRetry(int maxRetry) {
    this.maxRetry = maxRetry;
  }

  @Override
  public String toString() {
    return "FrameworkConfig{" +
        "environments=" + environments +
        ", maxRetry=" + maxRetry +
        '}';
  }
}
