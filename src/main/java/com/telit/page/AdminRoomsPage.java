package com.telit.page;

import com.telit.util.ReportLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class AdminRoomsPage extends BasePage {
  private final By messagesNavigationLink = By.xpath("//a[contains(@href, '/admin/message')]");
  private final By roomNameInput = By.id("roomName");
  private final By typeDropdown = By.id("type");
  private final By accessibleDropdown = By.id("accessible");
  private final By roomPriceDropdown = By.id("roomPrice");
  private final By wifiCheckbox = By.id("wifiCheckbox");
  private final By tvCheckbox = By.id("tvCheckbox");
  private final By refreshmentsCheckbox = By.id("refreshCheckbox");
  private final By safeCheckbox = By.id("safeCheckbox");
  private final By viewsCheckbox = By.id("viewsCheckbox");
  private final By createRoomButton = By.id("createRoom");

  public AdminRoomsPage(WebDriver driver) {
    super(driver);
  }

  public boolean isLoaded() {
    log.info("Validating if Admin Rooms Page loaded successfully using Admin-only 'Messages' anchor.");
    ReportLogger.info("Validating if Admin Rooms Page loaded successfully using Admin-only 'Messages' anchor.");

    return isDisplayed(messagesNavigationLink);
  }
}
