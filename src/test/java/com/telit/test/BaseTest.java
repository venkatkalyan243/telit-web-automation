package com.telit.test;

import com.telit.page.HomePage;
import com.telit.util.ConfigManager;
import com.telit.util.DriverManager;
import com.telit.util.ReportManager;
import org.openqa.selenium.WebDriver;
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
    WebDriver driver = DriverManager.getDriver();

    launchApplication(driver);
    homePage = new HomePage(driver);
  }

  private void launchApplication(WebDriver driver) {
    String url = ConfigManager.getEnvDetails().getUrl();
    driver.get(url);
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
