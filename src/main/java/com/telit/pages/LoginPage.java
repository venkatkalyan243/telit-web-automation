package com.telit.pages;

import com.telit.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public final class LoginPage extends WebActions {
  private static final By EMAIL_ADDRESS_TEXT_BOX_LOCATOR = By.id("email");
  private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
  private static final By SIGN_IN_BUTTON_LOCATOR = By.id("SubmitLogin");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public MyAccountPage doLoginWith(String emailAddress, String password) {
    enterText(EMAIL_ADDRESS_TEXT_BOX_LOCATOR, emailAddress);
    enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
    clickOn(SIGN_IN_BUTTON_LOCATOR);

    MyAccountPage myAccountPage = new MyAccountPage(getDriver());
    return myAccountPage;
  }
}
