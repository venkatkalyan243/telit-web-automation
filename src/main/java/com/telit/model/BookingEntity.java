package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingEntity {
  @JsonProperty("roomid")
  private int roomId;

  @JsonProperty("firstname")
  private String firstName;

  @JsonProperty("lastname")
  private String lastName;

  @JsonProperty("depositpaid")
  private boolean depositPaid;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("bookingdates")
  private BookingDates bookingDates;

  public BookingEntity() {
  }

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean isDepositPaid() {
    return depositPaid;
  }

  public void setDepositPaid(boolean depositPaid) {
    this.depositPaid = depositPaid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public BookingDates getBookingDates() {
    return bookingDates;
  }

  public void setBookingDates(BookingDates bookingDates) {
    this.bookingDates = bookingDates;
  }

  @Override
  public String toString() {
    return "BookingEntity{" +
        "roomId='" + roomId + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", depositPaid=" + depositPaid +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", bookingDates=" + bookingDates +
        '}';
  }

  public static class BookingDates {
    @JsonProperty("checkin")
    private String checkInDate;

    @JsonProperty("checkout")
    private String checkOutDate;

    public BookingDates() {
    }

    public String getCheckInDate() {
      return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
      this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
      return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
      this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString() {
      return "BookingDates{" +
          "checkInDate='" + checkInDate + '\'' +
          ", checkOutDate='" + checkOutDate + '\'' +
          '}';
    }
  }
}
