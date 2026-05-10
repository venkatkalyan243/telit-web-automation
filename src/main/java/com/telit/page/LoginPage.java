package com.telit.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class LoginPage extends BasePage {
  @FindBy(id = "email")
  private WebElement emailAddressTextBox;

  @FindBy(id = "passwd")
  private WebElement passwordTextBox;

  @FindBy(id = "SubmitLogin")
  private WebElement signInButton;

  @FindBy(xpath = "//div[@class = 'alert alert-danger']/ol/li")
  private WebElement errorMessageText;

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
    enterText(emailAddressTextBox, email);
    enterText(passwordTextBox, password);
    clickOn(signInButton);
  }

  public String getErrorMessage() {
    return getVisibleText(errorMessageText);
  }
}
