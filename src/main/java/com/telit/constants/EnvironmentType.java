package com.telit.constants;

public enum EnvironmentType {
  DEV, QA, UAT;

  // This makes sure Env.QA becomes "qa" automatically
  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
