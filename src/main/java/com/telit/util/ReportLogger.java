package com.telit.util;

import com.aventstack.extentreports.ExtentTest;

public final class ReportLogger {
  private static final ThreadLocal<ExtentTest> EXTENT_TEST = new ThreadLocal<>();

  private ReportLogger() {
  }

  static void setExtentTest(ExtentTest test) {
    EXTENT_TEST.set(test);
  }

  public static void pass(String message) {
    EXTENT_TEST.get().pass(message);
  }

  public static void fail(String message) {
    EXTENT_TEST.get().fail(message);
  }

  public static void info(String message) {
    EXTENT_TEST.get().info(message);
  }

  public static void skip(String message) {
    EXTENT_TEST.get().skip(message);
  }

  public static void unload() {
    EXTENT_TEST.remove();
  }
}
