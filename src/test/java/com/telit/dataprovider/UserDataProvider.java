package com.telit.dataprovider;

import com.telit.model.LoginData;
import com.telit.model.UserEntity;
import com.telit.util.DataReader;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

public class UserDataProvider {

  @DataProvider(name = "getValidUsers")
  public Iterator<Object[]> getValidUsers() {
    LoginData loginDataWrapper = DataReader.fromJson("test-data/scenario/valid-credentials.json", LoginData.class);

    return loginDataWrapper.getUsers().stream()
        .map(user -> new Object[]{user})
        .iterator();
  }

  @DataProvider(name = "getInvalidUsers")
  public Iterator<Object[]> getInvalidUsers() {
    List<UserEntity> userList = DataReader.fromCsv("test-data/bulk/invalid-credentials.csv", UserEntity.class);

    return userList.stream()
        .map(user -> new Object[]{user})
        .iterator();
  }
}
