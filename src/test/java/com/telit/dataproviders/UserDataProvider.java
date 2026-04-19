package com.telit.dataproviders;

import com.telit.pojo.LoginTestData;
import com.telit.pojo.User;
import com.telit.utils.CsvLoader;
import com.telit.utils.YamlLoader;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

public class UserDataProvider {

  @DataProvider(name = "getValidUsers")
  public Iterator<Object[]> getValidUsers() {
    LoginTestData testDataWrapper = YamlLoader.parse("test-data/scenarios/valid-credentials.yaml", LoginTestData.class);

    return testDataWrapper.getUsers().stream()
        .map(user -> new Object[]{user})
        .iterator();
  }

  @DataProvider(name = "getInvalidUsers")
  public Iterator<Object[]> getInvalidUsers() {
    List<User> userList = CsvLoader.parse("test-data/bulk/invalid-credentials.csv", User.class);

    return userList.stream()
        .map(user -> new Object[]{user})
        .iterator();
  }
}
