package com.telit.page;

import org.openqa.selenium.By;

public final class MyAccountPage extends BasePage {
  private final By lblPageHeader = By.className("page-heading");

  public MyAccountPage() {
    super();
  }

  public String getPageHeaderName() {
    return getTextOf(lblPageHeader);
  }
}
