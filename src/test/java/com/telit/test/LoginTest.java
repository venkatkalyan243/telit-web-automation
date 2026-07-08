package com.telit.test;

import static org.testng.Assert.assertEquals;

import com.telit.model.UserEntity;
import org.testng.annotations.Test;
import com.telit.dataprovider.UserDataProvider;

public class LoginTest extends BaseTest {

  @Test(
      dataProviderClass = UserDataProvider.class,
      dataProvider = "getValidUsers",
      description = "Verify successful login with valid credentials"
  )
  public void testLoginSuccess(UserEntity user) {
    String actualUserName = homePage
        .navigateToLoginPage()
        .loginAs(user.getEmailAddress(), user.getPassword())
        .getLoggedInAccountName();

    assertEquals(actualUserName, user.getName());
  }

  @Test(
      dataProviderClass = UserDataProvider.class,
      dataProvider = "getInvalidUsers",
      description = "Verify error message when logging in with invalid credentials"
  )
  public void testLoginFailure(UserEntity user) {
    String actualErrorMessage = homePage
        .navigateToLoginPage()
        .loginWithInvalidCredentials(user.getEmailAddress(), user.getPassword())
        .getAuthenticationFailureMessage();

    assertEquals(actualErrorMessage, "Authentication failed.");
  }
}
