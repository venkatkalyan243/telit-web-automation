package com.telit.utils;

import com.telit.constants.EnvironmentType;
import com.telit.pojo.FrameworkConfig;
import com.telit.pojo.EnvironmentConfig;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class ConfigLoader {
  private static FrameworkConfig frameworkConfig;

  public static FrameworkConfig getFrameworkConfig() {
    if (frameworkConfig == null) {
      try {
        Yaml yaml = new Yaml(new Constructor(FrameworkConfig.class, new LoaderOptions()));
        InputStream inputStream = ConfigLoader.class
            .getClassLoader()
            .getResourceAsStream("config.yaml");

        frameworkConfig = yaml.load(inputStream);
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
