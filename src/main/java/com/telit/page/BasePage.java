package com.telit.page;

import com.telit.util.ConfigManager;
import com.telit.util.DriverManager;
import com.telit.util.ReportLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {
  protected final Logger log = LoggerFactory.getLogger(getClass());

  private final Duration timeout =
      Duration.ofSeconds(ConfigManager.getConfig().getExplicitWaitSeconds());

  protected WebDriver driver;

  protected BasePage() {
    this.driver = DriverManager.getDriver();
  }

  private WebDriverWait getWait() {
    return new WebDriverWait(this.driver, timeout);
  }

  protected void click(By locator) {
    WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(locator));

    String locatorDetails = locator.toString().replace("By.", "");
    log.info("Clicking on element -> [{}]", locatorDetails);
    ReportLogger.info("Clicking on element -> [" + locatorDetails + "]");

    element.click();
  }

  protected void type(By locator, String valueToInput) {
    WebElement targetField = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    String locatorDetails = locator.toString().replace("By.", "");
    log.info("Clearing input field -> [{}]", locatorDetails);
    targetField.clear();

    String loggedValue = locatorDetails.toLowerCase().contains("password") ? "***" : valueToInput;
    log.info("Typing [{}] into field -> [{}]", loggedValue, locatorDetails);
    ReportLogger.info("Typing [" + loggedValue + "] into field -> [" + locatorDetails + "]");

    targetField.sendKeys(valueToInput);
  }

  protected String getTextOf(By locator) {
    WebElement element = getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    String locatorDetails = locator.toString().replace("By.", "");
    log.info("Extracting text from element -> [{}]", locatorDetails);
    String text = element.getText();

    log.info("Extracted text value: [{}]", text);
    ReportLogger.info("Extracted text [" + text + "] from -> [" + locatorDetails + "]");
    return text;
  }

  protected boolean isDisplayed(By locator) {
    try {
      return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
