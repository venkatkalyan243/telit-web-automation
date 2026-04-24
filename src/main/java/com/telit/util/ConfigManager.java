package com.telit.util;

import com.telit.constant.EnvironmentType;
import com.telit.model.FrameworkConfig;
import com.telit.model.EnvironmentConfig;

public class ConfigManager {
  private static FrameworkConfig frameworkConfig;

  private ConfigManager() {
  }

  public static synchronized FrameworkConfig getFrameworkConfig() {
    if (frameworkConfig == null) {
      frameworkConfig = DataReader.fromJson("config/config.json", FrameworkConfig.class);
    }
    return frameworkConfig;
  }

  public static EnvironmentConfig getEnvironment(EnvironmentType envType) {
    EnvironmentConfig env = getFrameworkConfig().getEnvironments().get(envType.toString());

    if (env == null) {
      throw new RuntimeException("CRITICAL: Configuration for environment [" + envType + "] missing in config.json");
    }
    return env;
  }
}
