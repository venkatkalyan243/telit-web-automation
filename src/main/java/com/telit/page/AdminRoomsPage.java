package com.telit.page;

import org.openqa.selenium.By;

public final class AdminRoomsPage extends BasePage {
  private final By messagesNavigationLink = By.xpath("//a[contains(@href, '/admin/message')]");

  public AdminRoomsPage() {
    super();
  }

  public boolean isLoaded() {
    log.info("Validating if Admin Rooms Page loaded successfully using Admin-only 'Messages' anchor.");
    return isDisplayed(messagesNavigationLink);
  }
}
