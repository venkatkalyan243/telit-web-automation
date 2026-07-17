package com.telit.page;

import org.openqa.selenium.By;

public final class AdminLoginPage extends BasePage {
  private final By usernameInput = By.id("username");
  private final By passwordInput = By.id("password");
  private final By loginButton = By.id("doLogin");
  private final By errorMessageLabel = By.xpath("//div[@class = 'alert alert-danger']");

  public AdminLoginPage() {
    super();
  }

  public AdminRoomsPage loginAs(String username, String password) {
    submitCredentials(username, password);
    return new AdminRoomsPage();
  }

  public AdminLoginPage loginWithInvalidCredentials(String username, String password) {
    submitCredentials(username, password);
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
