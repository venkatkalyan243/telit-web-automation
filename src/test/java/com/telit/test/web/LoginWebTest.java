package com.telit.test.web;

import com.telit.constant.AppMessages;
import com.telit.constant.TestGroups;
import com.telit.model.UserEntity;
import com.telit.page.AdminRoomsPage;
import com.telit.util.SecretsManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.telit.dataprovider.UserDataProvider;

public class LoginWebTest extends WebBaseTest {

  @Test(
      groups = {TestGroups.WEB, TestGroups.REGRESSION},
      description = "Verify login via the Web UI"
  )
  public void loginViaWeb() {
    UserEntity validUser = SecretsManager.getValidUser();

    AdminRoomsPage adminRoomsPage = homePage
        .navigateToAdminLoginPage()
        .loginAs(validUser);

    Assert.assertTrue(
        adminRoomsPage.isLoaded(),
        "FAIL: The Admin Rooms Page failed to load after submitting valid credentials."
    );
  }

  @Test(
      groups = {TestGroups.WEB, TestGroups.REGRESSION},
      dataProviderClass = UserDataProvider.class,
      dataProvider = "getInvalidUsers",
      description = "Verify error message when logging in with invalid credentials via the Web UI"
  )
  public void loginWithInvalidCredentialsViaWeb(UserEntity invalidUser) {
    String actualErrorMessage = homePage
        .navigateToAdminLoginPage()
        .attemptLoginAs(invalidUser)
        .getAuthenticationFailureMessage();

    Assert.assertEquals(actualErrorMessage, AppMessages.INVALID_CREDENTIALS_ERROR);
  }
}
