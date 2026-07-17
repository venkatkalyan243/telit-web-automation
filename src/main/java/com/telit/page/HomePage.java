package com.telit.page;

import org.openqa.selenium.By;

public final class HomePage extends BasePage {
  private final By adminLink = By.xpath("//a[contains(text(), 'Admin')]");

  public HomePage() {
    super();
  }

  public AdminLoginPage navigateToAdminLoginPage() {
    click(adminLink);
    return new AdminLoginPage();
  }
}
