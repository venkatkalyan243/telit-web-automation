package com.telit.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class HomePage extends BasePage {
  @FindBy(xpath = "//a[contains(text(), 'Sign in')]")
  private WebElement signInLink;

  public HomePage() {
    super();
  }

  public LoginPage goToLoginPage() {
    clickOn(signInLink);
    return new LoginPage();
  }
}
