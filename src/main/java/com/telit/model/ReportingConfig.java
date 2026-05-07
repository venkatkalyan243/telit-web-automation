package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReportingConfig {
  @JsonProperty("basePath")
  private String basePath;

  @JsonProperty("fileName")
  private String fileName;

  @JsonProperty("overrideReport")
  private boolean overrideReport;

  public String getBasePath() {
    return basePath;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public boolean isOverrideReport() {
    return overrideReport;
  }

  public void setOverrideReport(boolean overrideReport) {
    this.overrideReport = overrideReport;
  }

  @Override
  public String toString() {
    return "ReportingConfig{" +
        "basePath='" + basePath + '\'' +
        ", fileName='" + fileName + '\'' +
        ", overrideReport=" + overrideReport +
        '}';
  }
}
