package com.telit.dataprovider;

import com.telit.model.UserEntity;
import com.telit.util.DataReader;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;

public class UserDataProvider {

  @DataProvider(name = "getInvalidUsers")
  public Iterator<Object[]> getInvalidUsers() {
    List<UserEntity> userList = DataReader.fromCsv("test-data/data-driven/invalid-credentials.csv", UserEntity.class);

    return userList.stream()
        .map(user -> new Object[]{user})
        .iterator();
  }
}
