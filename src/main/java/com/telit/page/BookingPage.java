package com.telit.page;

import com.telit.model.BookingEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class BookingPage extends BasePage {
  private final By reserveNowButton = By.xpath("//button[normalize-space()='Reserve Now']");
  private final By firstNameInput = By.cssSelector("input[name='firstname']");
  private final By lastNameInput = By.cssSelector("input[name='lastname']");
  private final By emailInput = By.cssSelector("input[name='email']");
  private final By phoneInput = By.cssSelector("input[name='phone']");
  private final By bookingConfirmationHeader = By.xpath("//h2[normalize-space()='Booking Confirmed']");
  private final By errorMessageLabel = By.cssSelector("div.alert.alert-danger");

  public BookingPage(WebDriver driver) {
    super(driver);
  }

  public BookingPage clickReserveNow() {
    scrollTo(reserveNowButton);
    click(reserveNowButton);
    return this;
  }

  public BookingPage populateGuestInformation(BookingEntity booking) {
    scrollTo(firstNameInput);
    type(firstNameInput, booking.getFirstName());
    type(lastNameInput, booking.getLastName());
    type(emailInput, booking.getEmail());
    type(phoneInput, booking.getPhone());
    return this;
  }

  public boolean isBookingConfirmationVisible() {
    scrollTo(bookingConfirmationHeader);
    return isDisplayed(bookingConfirmationHeader);
  }

  public String getBookingErrorMessages() {
    scrollTo(errorMessageLabel);
    return getTextOf(errorMessageLabel);
  }
}
