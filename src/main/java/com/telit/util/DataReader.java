package com.telit.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DataReader {
  private static final ObjectMapper JSON_MAPPER = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

  private static final CsvMapper CSV_MAPPER = (CsvMapper) new CsvMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

  private DataReader() {
  }

  public static <T> T fromJson(String filePath, Class<T> targetClass) {
    try (InputStream inputStream = getStream(filePath)) {
      return JSON_MAPPER.readValue(inputStream, targetClass);
    } catch (IOException e) {
      throw new RuntimeException("CRITICAL: Failed to load JSON data: " + filePath, e);
    }
  }

  public static <T> List<T> fromCsv(String filePath, Class<T> targetClass) {
    try (InputStream inputStream = getStream(filePath)) {
      CsvSchema schema = CsvSchema.emptySchema().withHeader();
      return CSV_MAPPER.readerFor(targetClass).with(schema).<T>readValues(inputStream).readAll();
    } catch (IOException e) {
      throw new RuntimeException("CRITICAL: Failed to load CSV data: " + filePath, e);
    }
  }

  private static InputStream getStream(String filePath) {
    InputStream inputStream = DataReader.class
        .getClassLoader()
        .getResourceAsStream(filePath);

    if (inputStream == null) {
      throw new IllegalArgumentException("File not found: " + filePath);
    }
    return inputStream;
  }
}
