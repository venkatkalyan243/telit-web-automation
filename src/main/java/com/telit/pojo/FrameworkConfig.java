package com.telit.pojo;

import java.util.Map;

public class FrameworkConfig {
  private Map<String, EnvironmentConfig> environments;

  public Map<String, EnvironmentConfig> getEnvironments() {
    return environments;
  }

  public void setEnvironments(Map<String, EnvironmentConfig> environments) {
    this.environments = environments;
  }

  @Override
  public String toString() {
    return "FrameworkConfig{" +
        "environments=" + environments +
        '}';
  }
}
