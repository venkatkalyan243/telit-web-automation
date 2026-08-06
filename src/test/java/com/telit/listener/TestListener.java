package com.telit.listener;

import com.telit.util.ReportLogger;
import com.telit.util.ReportManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
  private static final Logger log = LoggerFactory.getLogger(TestListener.class);

  @Override
  public void onStart(ITestContext context) {
    log.info(">>> Execution Started for Module: [{}]", context.getName());
  }

  @Override
  public void onTestStart(ITestResult result) {
    String methodName = result.getName();
    String testDescription = result.getMethod().getDescription();

    log.info("Starting Test: [{}]", methodName);
    ReportManager.createExtentTest(methodName);
    ReportLogger.info(String.format("<b>Execution Started:</b> %s()", methodName));

    if (testDescription != null && !testDescription.trim().isEmpty()) {
      ReportLogger.info(String.format("<b>Scenario Description:</b> <i>%s</i>", testDescription));
    }
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    log.info("PASSED: [{}]", result.getName());
    ReportLogger.pass("Test Case PASSED: " + result.getName());
    ReportLogger.unload();
  }

  @Override
  public void onTestFailure(ITestResult result) {
    log.error("FAILED: [{}]", result.getName());
    ReportLogger.fail("Test Case FAILED: " + result.getName());

    if (result.getThrowable() != null) {
      log.error("Exception: {}", result.getThrowable().getMessage());
      log.error("Stack Trace: ", result.getThrowable());
      ReportLogger.fail("Exception: " + result.getThrowable().getMessage());
    }

    try {
      ReportLogger.logFailWithScreenshot("Failure Screenshot");
    } catch (Exception e) {
      ReportLogger.info("Failed to capture screenshot: " + e.getMessage());
    }

    ReportLogger.unload();
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    log.warn("SKIPPED: [{}]", result.getName());
    ReportLogger.skip("Test Case SKIPPED: " + result.getName());
    ReportLogger.unload();
  }

  @Override
  public void onFinish(ITestContext context) {
    log.info("<<< Execution Completed for Module: [{}]", context.getName());
    log.info("Passed: {} | Failed: {} | Skipped: {}",
        context.getPassedTests().size(),
        context.getFailedTests().size(),
        context.getSkippedTests().size());
  }
}
