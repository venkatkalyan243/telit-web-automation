package com.telit.util;

import com.telit.constant.BrowserType;
import com.telit.constant.EnvType;
import com.telit.model.ConfigRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;

public class ConfigManager {
  private static final Logger log = LoggerFactory.getLogger(ConfigManager.class);
  private static final String BASE_OUTPUT_DIR = "target/exec-outputs";

  private static ConfigRoot config;
  private static String reportPath = "";
  private static BrowserType cachedBrowser;
  private static EnvType cachedEnv;

  private ConfigManager() {
  }

  public static synchronized ConfigRoot getConfig() {
    if (config == null) {
      config = DataReader.fromJson("config.json", ConfigRoot.class);
    }
    return config;
  }

  public static BrowserType getBrowser() {
    if (cachedBrowser != null) {
      return cachedBrowser;
    }

    String cliBrowser = System.getProperty("browser");

    if (cliBrowser != null && !cliBrowser.isBlank()) {
      try {
        cachedBrowser = BrowserType.valueOf(cliBrowser.toUpperCase());
      } catch (IllegalArgumentException e) {
        throw new RuntimeException("❌ ERROR: Invalid browser '" + cliBrowser + "' provided. Supported: " + Arrays.toString(BrowserType.values()));
      }
    } else {
      cachedBrowser = getConfig().getDefaultSettings().getBrowser();
      log.warn("WARNING: No browser specified via CLI (-Dbrowser). Defaulting to: {}", cachedBrowser);
    }

    return cachedBrowser;
  }

  public static ConfigRoot.EnvDetails getEnvDetails() {
    EnvType currentEnv = validateAndGetEnv();
    ConfigRoot.EnvDetails envDetails = getConfig().getEnvDetails().get(currentEnv.toString());

    if (envDetails == null) {
      throw new RuntimeException("❌ CRITICAL: Configuration for environment [" + currentEnv + "] missing in config.json");
    }
    return envDetails;
  }

  public static EnvType validateAndGetEnv() {
    if (cachedEnv != null) {
      return cachedEnv;
    }

    String cliEnv = System.getProperty("env");

    if (cliEnv != null && !cliEnv.isBlank()) {
      try {
        cachedEnv = EnvType.valueOf(cliEnv.toUpperCase());
      } catch (IllegalArgumentException e) {
        throw new RuntimeException("❌ ERROR: Invalid environment '" + cliEnv + "' provided. Supported: " + Arrays.toString(EnvType.values()));
      }
    } else {
      cachedEnv = getConfig().getDefaultSettings().getEnvironment();
      log.warn("WARNING: No environment specified via CLI (-Denv). Defaulting to: {}", cachedEnv);
    }

    return cachedEnv;
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
