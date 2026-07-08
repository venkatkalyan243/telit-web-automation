package com.telit.util;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.util.Objects;

public final class ReportLogger {
  private static final ThreadLocal<ExtentTest> EXTENT_TEST = new ThreadLocal<>();

  private ReportLogger() {
  }

  static void setExtentTest(ExtentTest extentTest) {
    EXTENT_TEST.set(extentTest);
  }

  private static ExtentTest getExtentTest() {
    ExtentTest currentExtentTest = EXTENT_TEST.get();
    return Objects.requireNonNull(currentExtentTest,
        "ExtentTest instance is null for the current thread. Please call ReportManager.createExtentTest()");
  }

  public static void pass(String message) {
    getExtentTest().pass(message);
  }

  public static void fail(String message) {
    getExtentTest().fail(message);
  }

  public static void info(String message) {
    getExtentTest().info(message);
  }

  public static void skip(String message) {
    getExtentTest().skip(message);
  }

  public static void logFailWithScreenshot(String message) {
    String base64Code = DriverManager.getBase64Screenshot();
    getExtentTest().fail(message,
        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build());
  }

  public static void unload() {
    EXTENT_TEST.remove();
  }
}
