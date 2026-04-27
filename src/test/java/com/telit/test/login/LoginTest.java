package com.telit.test;

import com.telit.constant.BrowserType;
import com.telit.dataprovider.UserDataProvider;
import com.telit.listener.RetryAnalyzer;
import com.telit.page.HomePage;

import static org.testng.Assert.*;

import com.telit.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
  public HomePage homePage;

  @BeforeMethod(description = "Load the home page of the website")
  public void setup() {
    homePage = new HomePage(BrowserType.CHROME);
  }

  @Test(
      dataProviderClass = UserDataProvider.class,
      dataProvider = "getValidUsers",
      description = "Verify successful login with valid credentials",
      groups = {"e2e", "sanity"},
      retryAnalyzer = RetryAnalyzer.class
  )
  public void testLoginSuccess(User user) {
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
  public void testLoginFailure(User user) {
    assertEquals(homePage
            .goToLoginPage()
            .doLoginWithInvalidCredentials(user.getEmailAddress(), user.getPassword())
            .getErrorMessage()
        , "Authentication failed.");
  }
}
