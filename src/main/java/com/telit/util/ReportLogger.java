package com.telit.util;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ReportLogger {
  private static final ThreadLocal<ExtentTest> EXTENT_TEST = new ThreadLocal<>();

  private ReportLogger() {
  }

  static void setExtentTest(ExtentTest extentTest) {
    EXTENT_TEST.set(extentTest);
  }

  private static ExtentTest getExtentTest() {
    return EXTENT_TEST.get();
  }

  public static void pass(String message) {
    ExtentTest extentTest = getExtentTest();
    if (extentTest != null) {
      extentTest.pass(message);
    }
  }

  public static void fail(String message) {
    ExtentTest extentTest = getExtentTest();
    if (extentTest != null) {
      extentTest.fail(message);
    }
  }

  public static void info(String message) {
    ExtentTest extentTest = getExtentTest();
    if (extentTest != null) {
      extentTest.info(message);
    }
  }

  public static void skip(String message) {
    ExtentTest extentTest = getExtentTest();
    if (extentTest != null) {
      extentTest.skip(message);
    }
  }

  public static void logFailWithScreenshot(String message) {
    ExtentTest extentTest = getExtentTest();
    if (extentTest != null) {
      String base64Code = DriverManager.getBase64Screenshot();
      extentTest.fail(message,
          MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build());
    }
  }

  public static void unload() {
    EXTENT_TEST.remove();
  }
}
