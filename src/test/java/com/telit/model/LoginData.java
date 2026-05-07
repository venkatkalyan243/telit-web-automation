package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LoginData {
  @JsonProperty("users")
  private List<UserEntity> users;

  public List<UserEntity> getUsers() {
    return users;
  }

  public void setUsers(List<UserEntity> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "LoginData{" +
        "users=" + users +
        '}';
  }
}
