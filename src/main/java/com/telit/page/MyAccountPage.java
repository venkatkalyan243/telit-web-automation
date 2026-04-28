package com.telit.page;

import org.openqa.selenium.By;

public final class MyAccountPage extends BasePage {
  private static final By USER_ACCOUNT_LINK_LOCATOR = By.xpath("//a[@title = 'View my customer account']/span");

  public MyAccountPage() {
    super();
  }

  public String getUserName() {
    return getVisibleText(USER_ACCOUNT_LINK_LOCATOR);
  }
}
