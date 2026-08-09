package com.telit.test.web;

import com.telit.page.HomePage;
import com.telit.test.BaseTest;
import com.telit.util.ConfigManager;
import com.telit.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class WebBaseTest extends BaseTest {
  protected HomePage homePage;

  @BeforeMethod
  public void initWebSession() {
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
  public void terminateWebSession() {
    DriverManager.quitDriver();
  }
}
