package com.telit.pages;

import com.telit.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public final class LoginPage extends WebActions {
  private static final By EMAIL_ADDRESS_TEXT_BOX_LOCATOR = By.id("email");
  private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
  private static final By SIGN_IN_BUTTON_LOCATOR = By.id("SubmitLogin");
  private static final By ERR_MSG_TXT_LOCATOR = By.xpath("//div[@class = 'alert alert-danger']/ol/li");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public MyAccountPage doLoginWith(String email, String password) {
    submitCredentials(email, password);
    return new MyAccountPage(getDriver());
  }

  public LoginPage doLoginWithInvalidCredentials(String email, String password) {
    submitCredentials(email, password);
    return this; // Return the current LoginPage to check for errors
  }

  private void submitCredentials(String email, String password) {
    enterText(EMAIL_ADDRESS_TEXT_BOX_LOCATOR, email);
    enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
    clickOn(SIGN_IN_BUTTON_LOCATOR);
  }

  public String getErrorMessage() {
    return getVisibleText(ERR_MSG_TXT_LOCATOR);
  }
}
