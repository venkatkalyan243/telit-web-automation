package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telit.constant.BrowserType;
import com.telit.constant.EnvType;

import java.util.Map;

public class ConfigRoot {
  @JsonProperty("reportFileName")
  private String reportFileName;

  @JsonProperty("maxRetry")
  private int maxRetry;

  @JsonProperty("defaults")
  private DefaultSettings defaultSettings;

  @JsonProperty("environments")
  private Map<String, EnvDetails> envDetails;

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

  public Map<String, EnvDetails> getEnvDetails() {
    return envDetails;
  }

  public void setEnvDetails(Map<String, EnvDetails> envDetails) {
    this.envDetails = envDetails;
  }

  @Override
  public String toString() {
    return "ConfigRoot{" +
        "reportFileName='" + reportFileName + '\'' +
        ", maxRetry=" + maxRetry +
        ", defaultSettings=" + defaultSettings +
        ", envDetails=" + envDetails +
        '}';
  }

  public static class DefaultSettings {
    @JsonProperty("browser")
    private BrowserType browser;

    @JsonProperty("environment")
    private EnvType environment;

    @JsonProperty("headless")
    private boolean headless;

    public BrowserType getBrowser() {
      return browser;
    }

    public void setBrowser(BrowserType browser) {
      this.browser = browser;
    }

    public EnvType getEnvironment() {
      return environment;
    }

    public void setEnvironment(EnvType environment) {
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

  public static class EnvDetails {
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
      return "EnvDetails{" +
          "url='" + url + '\'' +
          '}';
    }
  }
}
