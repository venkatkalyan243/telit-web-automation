package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ConfigRoot {
  @JsonProperty("reportFileName")
  private String reportFileName;

  @JsonProperty("maxRetry")
  private int maxRetry;

  @JsonProperty("defaults")
  private DefaultSettings defaultSettings;

  @JsonProperty("environments")
  private Map<String, EnvironmentDetails> environmentDetails;

  public String getReportFileName() {
    return reportFileName;
  }

  public void setReportFileName(String reportFileName) {
    this.reportFileName = reportFileName;
  }

  public int getMaxRetry() {
    return maxRetry;
  }

  public void setMaxRetry(int maxRetry) {
    this.maxRetry = maxRetry;
  }

  public DefaultSettings getDefaultSettings() {
    return defaultSettings;
  }

  public void setDefaultSettings(DefaultSettings defaultSettings) {
    this.defaultSettings = defaultSettings;
  }

  public Map<String, EnvironmentDetails> getEnvironmentDetails() {
    return environmentDetails;
  }

  public void setEnvironmentDetails(Map<String, EnvironmentDetails> environmentDetails) {
    this.environmentDetails = environmentDetails;
  }

  @Override
  public String toString() {
    return "ConfigRoot{" +
        "reportFileName='" + reportFileName + '\'' +
        ", maxRetry=" + maxRetry +
        ", defaultSettings=" + defaultSettings +
        ", environmentDetails=" + environmentDetails +
        '}';
  }
}
