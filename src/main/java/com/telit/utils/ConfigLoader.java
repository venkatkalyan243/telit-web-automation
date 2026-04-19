package com.telit.utils;

import com.telit.constants.EnvironmentType;
import com.telit.pojo.FrameworkConfig;
import com.telit.pojo.EnvironmentConfig;

public class ConfigLoader {
  private static FrameworkConfig frameworkConfig;

  public static FrameworkConfig getFrameworkConfig() {
    if (frameworkConfig == null) {
      try {
        frameworkConfig = YamlLoader.parse("config/config.yaml", FrameworkConfig.class);
      } catch (Exception e) {
        throw new RuntimeException("Failed to load config.yaml: " + e.getMessage());
      }
    }
    return frameworkConfig;
  }

  public static EnvironmentConfig getEnvironment(EnvironmentType environmentType) {
    EnvironmentConfig environmentConfig = getFrameworkConfig().getEnvironments().get(environmentType.toString());

    if (environmentConfig == null) {
      throw new RuntimeException("Environment settings for " + environmentType + " not found in config.yaml!");
    }

    return environmentConfig;
  }
}
