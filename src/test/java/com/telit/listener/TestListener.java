package com.telit.listener;

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
    String className = result.getTestClass().getRealClass().getSimpleName();
    log.info("Starting Test: [{} : {}]", className, result.getName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    log.info("PASSED: [{}]", result.getName());
  }

  @Override
  public void onTestFailure(ITestResult result) {
    log.error("FAILED: [{}]", result.getName());
    if (result.getThrowable() != null) {
      log.error("Exception: {}", result.getThrowable().getMessage());
      log.error("Stack Trace: ", result.getThrowable());
    }
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    log.warn("SKIPPED: [{}]", result.getName());
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
