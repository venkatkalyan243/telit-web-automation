package com.telit.page;

import com.telit.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
  protected WebDriver driver;

  protected BasePage() {
    this.driver = DriverManager.getDriver();
    PageFactory.initElements(this.driver, this);
  }

  public void clickOn(WebElement element) {
    element.click();
  }

  public void enterText(WebElement element, String textToEnter) {
    element.sendKeys(textToEnter);
  }

  public String getVisibleText(WebElement element) {
    return element.getText();
  }
}
