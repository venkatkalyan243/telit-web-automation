package com.telit.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.telit.model.UserEntity;
import com.telit.page.AdminRoomsPage;
import com.telit.util.SecretsManager;
import org.testng.annotations.Test;
import com.telit.dataprovider.UserDataProvider;

public class LoginTest extends BaseTest {

  @Test(description = "Verify successful login with valid credentials")
  public void testLoginSuccess() {
    var credentials = SecretsManager.getCredentials();

    AdminRoomsPage adminRoomsPage = homePage
        .navigateToAdminLoginPage()
        .loginAs(credentials.getUsername(), credentials.getPassword());

    assertTrue(
        adminRoomsPage.isLoaded(),
        "FAIL: The Admin Rooms Page failed to load after submitting valid credentials."
    );
  }

  @Test(
      dataProviderClass = UserDataProvider.class,
      dataProvider = "getInvalidUsers",
      description = "Verify error message when logging in with invalid credentials"
  )
  public void testLoginFailure(UserEntity user) {
    String actualErrorMessage = homePage
        .navigateToAdminLoginPage()
        .loginWithInvalidCredentials(user.getUsername(), user.getPassword())
        .getAuthenticationFailureMessage();

    assertEquals(actualErrorMessage, "Invalid credentials");
  }
}
