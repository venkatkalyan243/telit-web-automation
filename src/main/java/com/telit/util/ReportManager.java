package com.telit.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public final class ReportManager {
  private static ExtentReports extent;

  private ReportManager() {
  }

  public static void initReports() {
    if (extent == null) {
      String reportPath = ConfigManager.getReportPath();

      File file = new File(reportPath);
      File parentDir = file.getParentFile();

      if (parentDir != null && !parentDir.exists()) {
        parentDir.mkdirs();
      }

      ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
      spark.config().setReportName("Telit Web Automation Results");
      spark.config().setDocumentTitle("Test Report");

      extent = new ExtentReports();
      extent.attachReporter(spark);
    }
  }

  public static void flushReports() {
    if (extent != null) {
      extent.flush();
    }
  }

  public static void createTest(String testName) {
    ReportLogger.setExtentTest(extent.createTest(testName));
  }
}
