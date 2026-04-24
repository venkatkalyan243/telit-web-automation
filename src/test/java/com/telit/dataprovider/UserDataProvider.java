package com.telit.dataprovider;

import com.telit.model.LoginTestData;
import com.telit.model.User;
import com.telit.util.DataReader;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

public class UserDataProvider {

  @DataProvider(name = "getValidUsers")
  public Iterator<Object[]> getValidUsers() {
    LoginTestData testDataWrapper = DataReader.fromJson("test-data/scenario/valid-credentials.json", LoginTestData.class);

    return testDataWrapper.getUsers().stream()
        .map(user -> new Object[]{user})
        .iterator();
  }

  @DataProvider(name = "getInvalidUsers")
  public Iterator<Object[]> getInvalidUsers() {
    List<User> userList = DataReader.fromCsv("test-data/bulk/invalid-credentials.csv", User.class);

    return userList.stream()
        .map(user -> new Object[]{user})
        .iterator();
  }
}
