package com.telit.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.telit.constant.AppMessages;
import com.telit.model.RoomEntity;
import com.telit.model.UserEntity;
import com.telit.page.AdminRoomsPage;
import com.telit.util.DataReader;
import com.telit.util.SecretsManager;
import org.testng.annotations.Test;

public class RoomManagementTest extends BaseTest {

  @Test(description = "Verify successful room creation with valid data")
  public void testCreateRoomSuccess() {
    UserEntity admin = SecretsManager.getValidUser();

    RoomEntity room = DataReader
        .fromJson("test-data/functional/create-room-success.json", RoomEntity.class);

    AdminRoomsPage adminRoomsPage = homePage
        .navigateToAdminLoginPage()
        .loginAs(admin)
        .submitRoomDetails(room);

    assertTrue(
        adminRoomsPage.isRoomCreated(room),
        String.format("FAIL: Room creation validation failed. " +
            "Room number [%s] was not found in the admin records grid view.", room.getRoomName())
    );
  }

  @Test(description = "Verify error message when room name is missing during creation")
  public void testCreateRoomWithMissingName() {
    UserEntity admin = SecretsManager.getValidUser();

    RoomEntity invalidRoom = DataReader
        .fromJson("test-data/functional/create-room-missing-name.json", RoomEntity.class);

    String actualErrorMessage = homePage
        .navigateToAdminLoginPage()
        .loginAs(admin)
        .submitRoomDetails(invalidRoom)
        .getRoomCreationErrorMessage();

    assertEquals(actualErrorMessage, AppMessages.ROOM_NAME_REQUIRED_ERROR);
  }
}
