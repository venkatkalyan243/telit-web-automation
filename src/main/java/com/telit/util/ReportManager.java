package com.telit.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ReportManager {
  private static ExtentReports extentReports;

  private ReportManager() {
  }

  public static synchronized void initReports() {
    if (extentReports == null) {
      String reportPath = ConfigManager.getReportPath();

      ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
      spark.config().setReportName("Telit Web Automation Results");
      spark.config().setDocumentTitle("Test Report");

      extentReports = new ExtentReports();
      extentReports.attachReporter(spark);
    }
  }

  public static synchronized void flushReports() {
    if (extentReports != null) {
      extentReports.flush();
      extentReports = null;
    }
  }

  public static void createExtentTest(String testName) {
    if (extentReports == null) {
      initReports();
    }
    ReportLogger.setExtentTest(extentReports.createTest(testName));
  }
}
