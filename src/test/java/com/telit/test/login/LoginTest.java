package com.telit.test.login;

import static org.testng.Assert.*;

import com.telit.model.UserEntity;
import com.telit.test.BaseTest;
import org.testng.annotations.Test;
import com.telit.dataprovider.UserDataProvider;

public class LoginTest extends BaseTest {

  @Test(
      dataProviderClass = UserDataProvider.class,
      dataProvider = "getValidUsers",
      description = "Verify successful login with valid credentials"
  )
  public void testLoginSuccess(UserEntity user) {
    assertEquals(homePage
            .goToLoginPage()
            .doLoginWith(user.getEmailAddress(), user.getPassword())
            .getUserName()
        , user.getName());
  }

  @Test(
      dataProviderClass = UserDataProvider.class,
      dataProvider = "getInvalidUsers",
      description = "Verify error message when logging in with invalid credentials"
  )
  public void testLoginFailure(UserEntity user) {
    assertEquals(homePage
            .goToLoginPage()
            .doLoginWithInvalidCredentials(user.getEmailAddress(), user.getPassword())
            .getErrorMessage()
        , "Authentication failed.");
  }
}
