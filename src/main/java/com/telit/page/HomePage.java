package com.telit.page;

import org.openqa.selenium.By;

public final class HomePage extends BasePage {
  private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");

  public HomePage() {
    super();
  }

  public LoginPage goToLoginPage() {
    clickOn(SIGN_IN_LINK_LOCATOR);
    return new LoginPage();
  }
}
