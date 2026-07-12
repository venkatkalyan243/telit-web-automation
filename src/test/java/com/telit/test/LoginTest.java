package com.telit.test;

import static org.testng.Assert.assertEquals;

import com.telit.model.UserEntity;
import com.telit.page.MyAccountPage;
import com.telit.util.SecretsManager;
import org.testng.annotations.Test;
import com.telit.dataprovider.UserDataProvider;

public class LoginTest extends BaseTest {

  @Test(description = "Verify successful login with valid credentials")
  public void testLoginSuccess() {
    var credentials = SecretsManager.getCredentials();

    MyAccountPage myAccountPage = homePage
        .navigateToLoginPage()
        .loginAs(credentials.getEmail(), credentials.getPassword());

    assertEquals(myAccountPage.getPageHeaderName(), "MY ACCOUNT");
  }

  @Test(
      dataProviderClass = UserDataProvider.class,
      dataProvider = "getInvalidUsers",
      description = "Verify error message when logging in with invalid credentials"
  )
  public void testLoginFailure(UserEntity user) {
    String actualErrorMessage = homePage
        .navigateToLoginPage()
        .loginWithInvalidCredentials(user.getEmail(), user.getPassword())
        .getAuthenticationFailureMessage();

    assertEquals(actualErrorMessage, "Authentication failed.");
  }
}
