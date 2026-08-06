package com.telit.test;

import static org.testng.Assert.assertTrue;

import com.telit.constant.AppMessages;
import com.telit.model.BookingEntity;
import com.telit.page.BookingPage;
import com.telit.util.DataReader;
import org.testng.annotations.Test;

public class BookingTest extends BaseTest {

  @Test(description = "Verify successful room booking with valid data")
  public void testBookRoomSuccess() {
    BookingEntity booking = DataReader
        .fromJson("test-data/functional/create-booking-success.json", BookingEntity.class);

    BookingPage bookingPage = homePage
        .bookFirstAvailableRoom()
        .clickReserveNow()
        .populateGuestInformation(booking)
        .clickReserveNow();

    assertTrue(bookingPage.isBookingConfirmationVisible(),
        "The successful booking confirmation alert was not rendered in the DOM view.");
  }

  @Test(description = "Verify validation error messages are displayed when first name is missing during booking")
  public void testBookRoomWithMissingFirstName() {
    BookingEntity invalidBooking = DataReader
        .fromJson("test-data/functional/create-booking-missing-first-name.json", BookingEntity.class);

    String actualErrors = homePage
        .bookFirstAvailableRoom()
        .clickReserveNow()
        .populateGuestInformation(invalidBooking)
        .clickReserveNow()
        .getBookingErrorMessages();

    assertTrue(actualErrors.contains(AppMessages.FIRSTNAME_BLANK_ERROR),
        "Validation Failure: Blank first name error message is missing.");

    assertTrue(actualErrors.contains(AppMessages.FIRSTNAME_SIZE_ERROR),
        "Validation Failure: First name size constraint error message is missing.");
  }
}
