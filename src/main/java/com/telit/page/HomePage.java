package com.telit.page;

import org.openqa.selenium.By;

public final class HomePage extends BasePage {
  private final By lnkSignIn = By.xpath("//a[contains(text(), 'Sign in')]");

  public HomePage() {
    super();
  }

  public LoginPage navigateToLoginPage() {
    click(lnkSignIn);
    return new LoginPage();
  }
}
