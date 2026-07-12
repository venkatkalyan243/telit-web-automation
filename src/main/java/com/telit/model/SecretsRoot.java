package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class SecretsRoot {
  @JsonProperty("environments")
  private Map<String, EnvCredentials> envCredentials;

  public Map<String, EnvCredentials> getEnvCredentials() {
    return envCredentials;
  }

  public void setEnvCredentials(Map<String, EnvCredentials> envCredentials) {
    this.envCredentials = envCredentials;
  }

  @Override
  public String toString() {
    return "SecretsRoot{" +
        "envCredentials=" + envCredentials +
        '}';
  }

  public static class EnvCredentials {
    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    @Override
    public String toString() {
      return "EnvCredentials{" +
          "email='" + email + '\'' +
          ", password='" + password + '\'' +
          '}';
    }
  }
}
