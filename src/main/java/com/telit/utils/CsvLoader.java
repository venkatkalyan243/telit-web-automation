package com.telit.utils;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvLoader {

  public static <T> List<T> parse(String filePath, Class<T> targetClass) {
    try (InputStream inputStream = CsvLoader.class.getClassLoader().getResourceAsStream(filePath);
         InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

      return new CsvToBeanBuilder<T>(inputStreamReader)
          .withType(targetClass)
          .withIgnoreLeadingWhiteSpace(true)
          .build()
          .parse();
    } catch (Exception e) {
      throw new RuntimeException("Failed to parse YAML file [" + filePath + "]: " + e.getMessage());
    }
  }
}
