package com.telit.page;

import com.telit.model.RoomEntity;
import com.telit.util.ReportLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class AdminRoomsPage extends BasePage {
  private final By messagesNavigationLink = By.cssSelector("a[href*='/admin/message']");
  private final By roomNameInput = By.id("roomName");
  private final By typeDropdown = By.id("type");
  private final By accessibleDropdown = By.id("accessible");
  private final By roomPriceInput = By.id("roomPrice");
  private final By createRoomButton = By.id("createRoom");
  private final By errorMessageLabel = By.cssSelector("div.alert.alert-danger p");

  private By getFeatureCheckboxLocator(String featureName) {
    return By.xpath(String.format(
        "//label[text()='%s']/preceding-sibling::input[@type='checkbox']", featureName));
  }

  private By getRoomGridRowLocator(String roomNumber) {
    return By.xpath(String.format("//div[@data-testid='roomlisting']//*[text()='%s']", roomNumber));
  }

  public AdminRoomsPage(WebDriver driver) {
    super(driver);
  }

  public boolean isLoaded() {
    log.info("Validating if Admin Rooms Page loaded successfully using Admin-only 'Messages' anchor.");
    ReportLogger.info("Validating if Admin Rooms Page loaded successfully using Admin-only 'Messages' anchor.");
    return isDisplayed(messagesNavigationLink);
  }

  public AdminRoomsPage submitRoomDetails(RoomEntity room) {
    type(roomNameInput, room.getRoomName());
    selectByVisibleText(typeDropdown, room.getType());
    selectByVisibleText(accessibleDropdown, String.valueOf(room.isAccessible()));
    type(roomPriceInput, String.valueOf(room.getRoomPrice()));
    selectFeatures(room);
    click(createRoomButton);
    return this;
  }

  public boolean isRoomCreated(RoomEntity room) {
    String expectedRoomName = room.getRoomName();
    log.info("Verifying grid records for newly created room number: [{}]", expectedRoomName);
    ReportLogger.info("Verifying grid records for newly created room number: [" + expectedRoomName + "]");

    By dynamicRow = getRoomGridRowLocator(expectedRoomName);
    return isDisplayed(dynamicRow);
  }

  public String getRoomCreationErrorMessage() {
    return getTextOf(errorMessageLabel);
  }

  private void selectFeatures(RoomEntity room) {
    for (String feature : room.getFeatures()) {
      By dynamicCheckbox = getFeatureCheckboxLocator(feature);
      log.info("Selecting room feature checkbox: [{}]", feature);
      click(dynamicCheckbox);
    }
  }
}
