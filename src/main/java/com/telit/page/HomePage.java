package com.telit.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BasePage {
  private final By adminLink = By.xpath("//a[contains(text(), 'Admin')]");

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public AdminLoginPage navigateToAdminLoginPage() {
    click(adminLink);
    return new AdminLoginPage(driver);
  }
}
