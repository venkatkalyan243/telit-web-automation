package com.telit.pages;

import com.telit.constants.BrowserType;
import com.telit.constants.EnvironmentType;
import com.telit.utils.WebActions;
import com.telit.utils.ConfigLoader;

import org.openqa.selenium.By;

public final class HomePage extends WebActions {
  private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");

  public HomePage(BrowserType browserType) {
    super(browserType);
    goToWebsite(ConfigLoader.getEnvironment(EnvironmentType.QA).getUrl());
    maximizeWindow();
  }

  public LoginPage goToLoginPage() {
    clickOn(SIGN_IN_LINK_LOCATOR);

    return new LoginPage(getDriver());
  }
}
