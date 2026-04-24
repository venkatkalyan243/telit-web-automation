package com.telit.page;

import com.telit.constant.BrowserType;
import com.telit.constant.EnvironmentType;
import com.telit.util.WebActions;
import com.telit.util.ConfigManager;
import org.openqa.selenium.By;

public final class HomePage extends WebActions {
  private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(), 'Sign in')]");

  public HomePage(BrowserType browserType) {
    super(browserType);
    goToWebsite(ConfigManager.getEnvironment(EnvironmentType.QA).getUrl());
    maximizeWindow();
  }

  public LoginPage goToLoginPage() {
    clickOn(SIGN_IN_LINK_LOCATOR);
    return new LoginPage(getDriver());
  }
}
