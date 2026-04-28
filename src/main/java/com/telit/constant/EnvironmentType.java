package com.telit.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum EnvironmentType {
  QA;

  @JsonCreator
  public static BrowserType decode(String value) {
    return Stream.of(BrowserType.values())
        .filter(target -> target.name().equalsIgnoreCase(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid browser: " + value));
  }

  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
