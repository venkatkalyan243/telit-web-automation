package com.telit.page;

import org.openqa.selenium.By;

public final class LoginPage extends BasePage {
  private final By emailAddressTextBox = By.id("email");
  private final By passwordTextBox = By.id("passwd");
  private final By signInButton = By.id("SubmitLogin");
  private final By errorMessageText = By.xpath("//div[@class = 'alert alert-danger']/ol/li");

  public LoginPage() {
    super();
  }

  public MyAccountPage doLoginWith(String email, String password) {
    submitCredentials(email, password);
    return new MyAccountPage();
  }

  public LoginPage doLoginWithInvalidCredentials(String email, String password) {
    submitCredentials(email, password);
    return this;
  }

  private void submitCredentials(String email, String password) {
    type(emailAddressTextBox, email);
    type(passwordTextBox, password);
    click(signInButton);
  }

  public String getErrorMessage() {
    return getTextOf(errorMessageText);
  }
}
