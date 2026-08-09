package com.telit.test.web;

import com.telit.constant.AppMessages;
import com.telit.constant.TestGroups;
import com.telit.model.RoomEntity;
import com.telit.model.UserEntity;
import com.telit.page.AdminRoomsPage;
import com.telit.util.DataReader;
import com.telit.util.SecretsManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoomManagementWebTest extends WebBaseTest {

  @Test(
      groups = {TestGroups.WEB, TestGroups.REGRESSION},
      description = "Verify room creation via the Web UI"
  )
  public void createRoomViaWeb() {
    UserEntity admin = SecretsManager.getValidUser();

    RoomEntity room = DataReader
        .fromJson("test-data/functional/create-room-success.json", RoomEntity.class);

    AdminRoomsPage adminRoomsPage = homePage
        .navigateToAdminLoginPage()
        .loginAs(admin)
        .submitRoomDetails(room);

    Assert.assertTrue(
        adminRoomsPage.isRoomCreated(room),
        String.format("FAIL: Room creation validation failed. " +
            "Room number [%s] was not found in the admin records grid view.", room.getRoomName())
    );
  }

  @Test(
      groups = {TestGroups.WEB, TestGroups.REGRESSION},
      description = "Verify error message when room name is missing during creation via the Web UI"
  )
  public void createRoomWithMissingNameViaWeb() {
    UserEntity admin = SecretsManager.getValidUser();

    RoomEntity invalidRoom = DataReader
        .fromJson("test-data/functional/create-room-missing-name.json", RoomEntity.class);

    String actualErrorMessage = homePage
        .navigateToAdminLoginPage()
        .loginAs(admin)
        .submitRoomDetails(invalidRoom)
        .getRoomCreationErrorMessage();

    Assert.assertEquals(actualErrorMessage, AppMessages.ROOM_NAME_REQUIRED_ERROR);
  }
}
