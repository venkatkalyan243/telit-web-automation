package com.telit.pojo;

import com.opencsv.bean.CsvBindByName;

public class User {
  @CsvBindByName(column = "emailAddress")
  private String emailAddress;

  @CsvBindByName(column = "password")
  private String password;

  @CsvBindByName(column = "name")
  private String name;

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "User{" +
        "emailAddress='" + emailAddress + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
