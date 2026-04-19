package com.telit.utils;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class YamlLoader {

  public static <T> T parse(String filePath, Class<T> targetClass) {
    try (InputStream inputStream = YamlLoader.class
        .getClassLoader()
        .getResourceAsStream(filePath)) {

      if (inputStream == null) {
        throw new RuntimeException("File not found: " + filePath);
      }

      Yaml yaml = new Yaml(new Constructor(targetClass, new LoaderOptions()));
      return yaml.load(inputStream);

    } catch (Exception e) {
      throw new RuntimeException("Failed to parse YAML file [" + filePath + "]: " + e.getMessage());
    }
  }
}
