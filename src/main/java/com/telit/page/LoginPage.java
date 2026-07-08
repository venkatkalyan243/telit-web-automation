package com.telit.page;

import org.openqa.selenium.By;

public final class LoginPage extends BasePage {
  private final By txtEmail = By.id("email");
  private final By txtPassword = By.id("passwd");
  private final By btnSignIn = By.id("SubmitLogin");
  private final By lblErrorMsg = By.xpath("//div[@class = 'alert alert-danger']/ol/li");

  public LoginPage() {
    super();
  }

  public MyAccountPage loginAs(String email, String password) {
    submitCredentials(email, password);
    return new MyAccountPage();
  }

  public LoginPage loginWithInvalidCredentials(String email, String password) {
    submitCredentials(email, password);
    return this;
  }

  private void submitCredentials(String email, String password) {
    type(txtEmail, email);
    type(txtPassword, password);
    click(btnSignIn);
  }

  public String getAuthenticationFailureMessage() {
    return getTextOf(lblErrorMsg);
  }
}
