package com.telit.util;

import com.telit.constant.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
  private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

  private DriverManager() {
  }

  public static WebDriver getDriver() {
    return DRIVER.get();
  }

  public static void initDriver(BrowserType browserType) {
    if (browserType == BrowserType.EDGE) {
      DRIVER.set(new EdgeDriver());
    } else {
      DRIVER.set(new ChromeDriver());
    }
  }

  public static void quitDriver() {
    if (DRIVER.get() != null) {
      DRIVER.get().quit();
      DRIVER.remove();
    }
  }
}
