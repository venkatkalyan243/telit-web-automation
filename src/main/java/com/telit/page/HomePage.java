package com.telit.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BasePage {
  private final By adminLink = By.xpath("//a[normalize-space()='Admin']");
  private final By firstBookNowButton = By.xpath("(//a[normalize-space()='Book now'])[1]");

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public AdminLoginPage navigateToAdminLoginPage() {
    click(adminLink);
    return new AdminLoginPage(driver);
  }

  public BookingPage bookFirstAvailableRoom() {
    scrollTo(firstBookNowButton);
    click(firstBookNowButton);
    return new BookingPage(driver);
  }
}
