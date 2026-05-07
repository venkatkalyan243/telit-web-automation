package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class ConfigRoot {
  @JsonProperty("defaults")
  private DefaultSettings defaultSettings;

  @JsonProperty("environments")
  private Map<String, EnvironmentDetails> environmentDetails;

  @JsonProperty("reports")
  private ReportingConfig reportingConfig;

  @JsonProperty("maxRetry")
  private int maxRetry;

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

  public ReportingConfig getReportingConfig() {
    return reportingConfig;
  }

  public void setReportingConfig(ReportingConfig reportingConfig) {
    this.reportingConfig = reportingConfig;
  }

  public int getMaxRetry() {
    return maxRetry;
  }

  public void setMaxRetry(int maxRetry) {
    this.maxRetry = maxRetry;
  }

  @Override
  public String toString() {
    return "ConfigRoot{" +
        "defaultSettings=" + defaultSettings +
        ", environmentDetails=" + environmentDetails +
        ", reportingConfig=" + reportingConfig +
        ", maxRetry=" + maxRetry +
        '}';
  }
}
