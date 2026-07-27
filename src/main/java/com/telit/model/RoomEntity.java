package com.telit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RoomEntity {
  @JsonProperty("roomName")
  private String roomName;

  @JsonProperty("type")
  private String type;

  @JsonProperty("accessible")
  private boolean accessible;

  @JsonProperty("image")
  private String image;

  @JsonProperty("description")
  private String description;

  @JsonProperty("roomPrice")
  private int roomPrice;

  @JsonProperty("features")
  private List<String> features;

  public RoomEntity() {
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public boolean isAccessible() {
    return accessible;
  }

  public void setAccessible(boolean accessible) {
    this.accessible = accessible;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getRoomPrice() {
    return roomPrice;
  }

  public void setRoomPrice(int roomPrice) {
    this.roomPrice = roomPrice;
  }

  public List<String> getFeatures() {
    return features;
  }

  public void setFeatures(List<String> features) {
    this.features = features;
  }

  @Override
  public String toString() {
    return "RoomEntity{" +
        "roomName='" + roomName + '\'' +
        ", type='" + type + '\'' +
        ", accessible=" + accessible +
        ", image='" + image + '\'' +
        ", description='" + description + '\'' +
        ", roomPrice=" + roomPrice +
        ", features=" + features +
        '}';
  }
}
