package com.telit.constant;

public enum EnvironmentType {
  QA;

  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
