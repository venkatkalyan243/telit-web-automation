package com.telit.util;

import com.telit.constant.BrowserType;
import com.telit.constant.EnvironmentType;
import com.telit.model.ConfigRoot;
import com.telit.model.EnvironmentDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;

public class ConfigManager {
  private static final Logger log = LoggerFactory.getLogger(ConfigManager.class);
  private static final String BASE_OUTPUT_DIR = "target/exec-outputs";

  private static ConfigRoot config;
  private static String reportPath = "";

  private ConfigManager() {
  }

  public static synchronized ConfigRoot getConfig() {
    if (config == null) {
      config = DataReader.fromJson("config.json", ConfigRoot.class);
    }
    return config;
  }

  public static BrowserType getBrowser() {
    String cliBrowser = System.getProperty("browser");

    if (cliBrowser != null && !cliBrowser.isBlank()) {
      return validateAndGetBrowser(cliBrowser);
    }

    BrowserType defaultBrowser = getConfig().getDefaultSettings().getBrowser();
    log.warn("WARNING: No browser specified via CLI (-Dbrowser). Defaulting to: {}", defaultBrowser);
    return defaultBrowser;
  }

  private static BrowserType validateAndGetBrowser(String browserName) {
    try {
      return BrowserType.valueOf(browserName.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new RuntimeException("❌ ERROR: Invalid browser '" + browserName + "' provided. Supported: " + Arrays.toString(BrowserType.values()));
    }
  }

  public static EnvironmentDetails getEnvironmentDetails() {
    String cliEnv = System.getProperty("env");
    EnvironmentType targetType;

    if (cliEnv != null && !cliEnv.isBlank()) {
      targetType = validateAndGetEnv(cliEnv);
    } else {
      targetType = getConfig().getDefaultSettings().getEnvironment();
      log.warn("WARNING: No environment specified via CLI (-Denv). Defaulting to: {}", targetType);
    }

    EnvironmentDetails environmentDetails = getConfig().getEnvironmentDetails().get(targetType.toString());

    if (environmentDetails == null) {
      throw new RuntimeException("❌ CRITICAL: Configuration for environment [" + targetType + "] missing in config.json");
    }
    return environmentDetails;
  }

  private static EnvironmentType validateAndGetEnv(String envName) {
    try {
      return EnvironmentType.valueOf(envName.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new RuntimeException("❌ ERROR: Invalid environment '" + envName + "' provided. Supported: " + Arrays.toString(EnvironmentType.values()));
    }
  }

  public static boolean isHeadless() {
    boolean isRunningOnCI = System.getenv("CI") != null;

    String headlessSysProp = System.getProperty("headless");

    if (isRunningOnCI) {
      return true;
    } else if (headlessSysProp != null) {
      return Boolean.parseBoolean(headlessSysProp);
    } else {
      return getConfig().getDefaultSettings().isHeadless();
    }
  }

  public static String getReportPath() {
    if (reportPath.isEmpty()) {
      String fallbackFolder = BASE_OUTPUT_DIR + "/exec";
      String execFolder = System.getProperty("execOutputDir", fallbackFolder);
      String fileName = getConfig().getReportFileName();

      if (fallbackFolder.equals(execFolder)) {
        new File(execFolder).mkdirs();
      }

      reportPath = System.getProperty("user.dir") + "/" + execFolder + "/" + fileName;
    }
    return reportPath;
  }
}
