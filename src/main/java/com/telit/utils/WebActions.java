package com.telit.utils;

import com.telit.constants.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class WebActions {
  private WebDriver driver;

  public WebActions(WebDriver driver) {
    this.driver = driver;
  }

  public WebActions(BrowserType browserType) {
    if (browserType == BrowserType.CHROME) {
      driver = new ChromeDriver();
    } else if (browserType == BrowserType.EDGE) {
      driver = new EdgeDriver();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }

  public void goToWebsite(String url) {
    driver.get(url);
  }

  public void maximizeWindow() {
    driver.manage().window().maximize();
  }

  public void clickOn(By locator) {
    WebElement element = driver.findElement(locator);
    element.click();
  }

  public void enterText(By locator, String textToEnter) {
    WebElement element = driver.findElement(locator);
    element.sendKeys(textToEnter);
  }

  public String getVisibleText(By locator) {
    WebElement element = driver.findElement(locator);
    return element.getText();
  }
}
