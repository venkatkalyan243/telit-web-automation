package com.telit.test;

import com.telit.util.ReportManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {

  @BeforeSuite(alwaysRun = true)
  public void beforeSuite() {
    ReportManager.initReports();
  }

  @AfterSuite(alwaysRun = true)
  public void afterSuite() {
    ReportManager.flushReports();
  }
}
