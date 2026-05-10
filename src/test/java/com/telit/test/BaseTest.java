package com.telit.test;

import com.telit.page.HomePage;
import com.telit.util.ConfigManager;
import com.telit.util.DriverManager;
import com.telit.util.ReportManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
  protected HomePage homePage;

  @BeforeSuite(alwaysRun = true)
  public void beforeSuite() {
    ReportManager.initReports();
  }

  @BeforeMethod
  public void setup() {
    DriverManager.initDriver();
    launchApplication();
    homePage = new HomePage();
  }

  private void launchApplication() {
    String url = ConfigManager.getEnvironmentDetails().getUrl();
    DriverManager.getDriver().get(url);
  }

  @AfterMethod
  public void tearDown() {
    DriverManager.quitDriver();
  }

  @AfterSuite(alwaysRun = true)
  public void afterSuite() {
    ReportManager.flushReports();
  }
}
