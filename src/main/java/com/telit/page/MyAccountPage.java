package com.telit.page;

import org.openqa.selenium.By;

public final class MyAccountPage extends BasePage {
  private final By userAccountLink = By.xpath("//a[@title = 'View my customer account']/span");

  public MyAccountPage() {
    super();
  }

  public String getUserName() {
    return getTextOf(userAccountLink);
  }
}
