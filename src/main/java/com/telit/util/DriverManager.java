package com.telit.util;

import com.telit.constant.BrowserType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {
  private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

  private DriverManager() {
  }

  public static WebDriver getDriver() {
    return DRIVER.get();
  }

  public static void initDriver() {
    if (ConfigManager.getBrowser() == BrowserType.EDGE) {
      EdgeOptions options = new EdgeOptions();
      applyChromiumOptions(options);
      DRIVER.set(new EdgeDriver(options));
    } else {
      ChromeOptions options = new ChromeOptions();
      applyChromiumOptions(options);
      DRIVER.set(new ChromeDriver(options));
    }

    if (!ConfigManager.isHeadless()) {
      getDriver().manage().window().maximize();
    }
  }

  private static void applyChromiumOptions(ChromiumOptions<?> options) {
    if (ConfigManager.isHeadless()) {
      options.addArguments("--headless=new");
      options.addArguments("--window-size=1920,1080");
      options.addArguments("--disable-gpu");
    }
  }

  public static String getBase64Screenshot() {
    return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
  }

  public static void quitDriver() {
    if (DRIVER.get() != null) {
      DRIVER.get().quit();
      DRIVER.remove();
    }
  }
}
