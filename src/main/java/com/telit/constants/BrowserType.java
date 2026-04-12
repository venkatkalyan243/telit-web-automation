package com.telit.constants;

public enum BrowserType {
  CHROME, EDGE;

  // This makes sure Env.CHROME becomes "chrome" automatically
  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
