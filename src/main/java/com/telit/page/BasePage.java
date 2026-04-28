package com.telit.page;

import com.telit.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
  protected WebDriver driver;

  protected BasePage() {
    this.driver = DriverManager.getDriver();
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
