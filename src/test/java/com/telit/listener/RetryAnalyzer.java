package com.telit.listener;

import com.telit.util.ConfigManager;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
  private int count = 1;

  @Override
  public boolean retry(ITestResult result) {
    if (count < ConfigManager.getConfig().getMaxRetry()) {
      count++;
      return true;
    }
    return false;
  }
}
