package com.telit.page;

import org.openqa.selenium.By;

public final class HomePage extends BasePage {
  private final By signInLink = By.xpath("//a[contains(text(), 'Sign in')]");

  public HomePage() {
    super();
  }

  public LoginPage goToLoginPage() {
    click(signInLink);
    return new LoginPage();
  }
}
