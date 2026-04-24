package com.telit.constant;

public enum BrowserType {
  CHROME, EDGE;

  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
