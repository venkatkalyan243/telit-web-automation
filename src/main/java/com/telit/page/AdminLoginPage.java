package com.telit.page;

import com.telit.model.UserEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class AdminLoginPage extends BasePage {
  private final By usernameInput = By.id("username");
  private final By passwordInput = By.id("password");
  private final By loginButton = By.id("doLogin");
  private final By errorMessageLabel = By.cssSelector("div.alert.alert-danger");

  public AdminLoginPage(WebDriver driver) {
    super(driver);
  }

  public AdminRoomsPage loginAs(UserEntity user) {
    submitCredentials(user.getUsername(), user.getPassword());
    return new AdminRoomsPage(driver);
  }

  public AdminLoginPage attemptLoginAs(UserEntity user) {
    submitCredentials(user.getUsername(), user.getPassword());
    return this;
  }

  private void submitCredentials(String username, String password) {
    type(usernameInput, username);
    type(passwordInput, password);
    click(loginButton);
  }

  public String getAuthenticationFailureMessage() {
    return getTextOf(errorMessageLabel);
  }
}
