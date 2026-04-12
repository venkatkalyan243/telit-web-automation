package com.telit.pages;

import com.telit.utils.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends WebActions {
  private static final By USER_ACCOUNT_LINK_LOCATOR = By.xpath("//a[@title = 'View my customer account']/span");

  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  public String getUserName() {
    return getVisibleText(USER_ACCOUNT_LINK_LOCATOR);
  }
}
