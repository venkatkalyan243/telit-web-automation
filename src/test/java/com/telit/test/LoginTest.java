package com.telit.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.telit.constant.AppMessages;
import com.telit.model.UserEntity;
import com.telit.page.AdminRoomsPage;
import com.telit.util.SecretsManager;
import org.testng.annotations.Test;
import com.telit.dataprovider.UserDataProvider;

public class LoginTest extends BaseTest {

  @Test(description = "Verify successful login with valid credentials")
  public void testLoginSuccess() {
    UserEntity validUser = SecretsManager.getValidUser();

    AdminRoomsPage adminRoomsPage = homePage
        .navigateToAdminLoginPage()
        .loginAs(validUser);

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
  public void testLoginFailure(UserEntity invalidUser) {
    String actualErrorMessage = homePage
        .navigateToAdminLoginPage()
        .attemptLoginAs(invalidUser)
        .getAuthenticationFailureMessage();

    assertEquals(actualErrorMessage, AppMessages.INVALID_CREDENTIALS_ERROR);
  }
}
