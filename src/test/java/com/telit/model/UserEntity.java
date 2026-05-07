package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserEntity {
  @JsonProperty("emailAddress")
  private String emailAddress;

  @JsonProperty("password")
  private String password;

  @JsonProperty("name")
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
    return "UserEntity{" +
        "emailAddress='" + emailAddress + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
