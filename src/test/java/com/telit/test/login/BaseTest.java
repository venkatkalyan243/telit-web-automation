package com.telit.test.login;

import com.telit.page.HomePage;
import com.telit.util.ConfigManager;
import com.telit.util.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  protected HomePage homePage;

  @BeforeMethod
  public void setup() {
    DriverManager.initDriver(ConfigManager.getBrowser());
    DriverManager.getDriver().manage().window().maximize();
    DriverManager.getDriver().get(ConfigManager.getEnvironment().getUrl());

    homePage = new HomePage();
  }

  @AfterMethod
  public void tearDown() {
    DriverManager.quitDriver();
  }
}
