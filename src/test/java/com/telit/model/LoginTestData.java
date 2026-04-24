package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LoginTestData {
  @JsonProperty("users")
  private List<User> users;

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "LoginTestData{" +
        "users=" + users +
        '}';
  }
}
