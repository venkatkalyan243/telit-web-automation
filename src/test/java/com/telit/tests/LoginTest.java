package com.telit.tests;

import com.telit.constants.BrowserType;
import com.telit.pages.HomePage;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
  public HomePage homePage;

  @BeforeMethod(description = "Load the home page of the website")
  public void setup() {
    homePage = new HomePage(BrowserType.CHROME);
  }

  @Test(description = "Validates if user is able to login", groups = {"e2e", "sanity"})
  public void loginTest() {
    assertEquals(homePage
            .goToLoginPage()
            .doLoginWith("darebi6641@agoalz.com", "Password123")
            .getUserName()
        , "Hitesh Kumar");
  }
}
