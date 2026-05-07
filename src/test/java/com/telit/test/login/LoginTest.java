package com.telit.test.login;

import static org.testng.Assert.*;

import com.telit.model.UserEntity;
import com.telit.test.BaseTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.telit.dataprovider.UserDataProvider;
import com.telit.listener.RetryAnalyzer;
import com.telit.listener.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

  @Test(
      dataProviderClass = UserDataProvider.class,
      dataProvider = "getValidUsers",
      description = "Verify successful login with valid credentials",
      groups = {"e2e", "sanity"},
      retryAnalyzer = RetryAnalyzer.class
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
      description = "Verify error message when logging in with invalid credentials",
      groups = {"e2e", "sanity"},
      retryAnalyzer = RetryAnalyzer.class
  )
  public void testLoginFailure(UserEntity user) {
    assertEquals(homePage
            .goToLoginPage()
            .doLoginWithInvalidCredentials(user.getEmailAddress(), user.getPassword())
            .getErrorMessage()
        , "Authentication failed.");
  }
}
