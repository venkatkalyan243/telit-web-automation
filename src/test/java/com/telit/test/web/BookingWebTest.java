package com.telit.test.web;

import com.telit.constant.AppMessages;
import com.telit.constant.TestGroups;
import com.telit.model.BookingEntity;
import com.telit.page.BookingPage;
import com.telit.util.DataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingWebTest extends WebBaseTest {

  @Test(
      groups = {TestGroups.WEB, TestGroups.REGRESSION},
      description = "Verify room booking via the Web UI"
  )
  public void bookRoomViaWeb() {
    BookingEntity booking = DataReader
        .fromJson("test-data/functional/create-booking-success.json", BookingEntity.class);

    BookingPage bookingPage = homePage
        .bookFirstAvailableRoom()
        .clickReserveNow()
        .populateGuestInformation(booking)
        .clickReserveNow();

    Assert.assertTrue(bookingPage.isBookingConfirmationVisible(),
        "The successful booking confirmation alert was not rendered in the DOM view.");
  }

  @Test(
      groups = {TestGroups.WEB, TestGroups.REGRESSION},
      description = "Verify validation error messages are displayed " +
          "when first name is missing during booking via the Web UI"
  )
  public void bookRoomWithMissingFirstNameViaWeb() {
    BookingEntity invalidBooking = DataReader
        .fromJson("test-data/functional/create-booking-missing-first-name.json", BookingEntity.class);

    String actualErrors = homePage
        .bookFirstAvailableRoom()
        .clickReserveNow()
        .populateGuestInformation(invalidBooking)
        .clickReserveNow()
        .getBookingErrorMessages();

    Assert.assertTrue(actualErrors.contains(AppMessages.FIRSTNAME_BLANK_ERROR),
        "Validation Failure: Blank first name error message is missing.");

    Assert.assertTrue(actualErrors.contains(AppMessages.FIRSTNAME_SIZE_ERROR),
        "Validation Failure: First name size constraint error message is missing.");
  }
}
