package com.telit.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class MyAccountPage extends BasePage {
  @FindBy(xpath = "//a[@title = 'View my customer account']/span")
  private WebElement userAccountLink;

  public MyAccountPage() {
    super();
  }

  public String getUserName() {
    return getVisibleText(userAccountLink);
  }
}
