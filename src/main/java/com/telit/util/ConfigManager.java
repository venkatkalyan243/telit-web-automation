package com.telit.util;

import com.telit.constant.BrowserType;
import com.telit.constant.EnvironmentType;
import com.telit.model.FrameworkConfig;
import com.telit.model.EnvironmentConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class ConfigManager {
  private static final Logger log = LoggerFactory.getLogger(ConfigManager.class);

  private static FrameworkConfig frameworkConfig;

  private ConfigManager() {
  }

  public static synchronized FrameworkConfig getFrameworkConfig() {
    if (frameworkConfig == null) {
      frameworkConfig = DataReader.fromJson("config/config.json", FrameworkConfig.class);
    }
    return frameworkConfig;
  }

  public static BrowserType getBrowser() {
    String cliBrowser = System.getProperty("browser");

    if (cliBrowser != null && !cliBrowser.isBlank()) {
      return validateAndGetBrowser(cliBrowser);
    }

    BrowserType defaultBrowser = getFrameworkConfig().getDefaults().getBrowser();
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

  public static EnvironmentConfig getEnvironment() {
    String cliEnv = System.getProperty("env");
    EnvironmentType targetType;

    if (cliEnv != null && !cliEnv.isBlank()) {
      targetType = validateAndGetEnv(cliEnv);
    } else {
      targetType = getFrameworkConfig().getDefaults().getEnvironment();
      log.warn("WARNING: No environment specified via CLI (-Denv). Defaulting to: {}", targetType);
    }

    EnvironmentConfig config = getFrameworkConfig().getEnvironments().get(targetType.toString());

    if (config == null) {
      throw new RuntimeException("❌ CRITICAL: Configuration for environment [" + targetType + "] missing in config.json");
    }
    return config;
  }

  private static EnvironmentType validateAndGetEnv(String envName) {
    try {
      return EnvironmentType.valueOf(envName.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new RuntimeException("❌ ERROR: Invalid environment '" + envName + "' provided. Supported: " + Arrays.toString(EnvironmentType.values()));
    }
  }
}
