package com.telit.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum EnvType {
  QA;

  @JsonCreator
  public static EnvType decode(String value) {
    return Stream.of(EnvType.values())
        .filter(target -> target.name().equalsIgnoreCase(value))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid browser: " + value));
  }

  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
