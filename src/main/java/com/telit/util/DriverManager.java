package com.telit.util;

import com.telit.constant.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
  private static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

  private DriverManager() {
  }

  public static WebDriver getDriver() {
    return THREAD_LOCAL_DRIVER.get();
  }

  public static void initDriver(BrowserType browserType) {
    if (browserType == BrowserType.EDGE) {
      THREAD_LOCAL_DRIVER.set(new EdgeDriver());
    } else {
      THREAD_LOCAL_DRIVER.set(new ChromeDriver());
    }
  }

  public static void quitDriver() {
    if (THREAD_LOCAL_DRIVER.get() != null) {
      THREAD_LOCAL_DRIVER.get().quit();
      THREAD_LOCAL_DRIVER.remove();
    }
  }
}
