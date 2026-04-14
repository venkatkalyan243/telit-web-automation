package com.telit.dataproviders;

import com.telit.pojo.LoginTestData;
import com.telit.pojo.User;
import com.telit.utils.YamlReader;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDataProvider {

  @DataProvider(name = "getValidUsers")
  public Iterator<Object[]> getValidUsers() {
    LoginTestData testDataWrapper = YamlReader.parse("test-data/scenarios/valid-credentials.yaml", LoginTestData.class);

    List<Object[]> testData = new ArrayList<>();
    for (User user : testDataWrapper.getUsers()) {
      testData.add(new Object[]{user});
    }

    return testData.iterator();
  }
}
