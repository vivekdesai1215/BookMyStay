package com.roominventory;
 
public class IndividualRoom {
 
    private String roomId;
    private RoomType type;
    private boolean isBooked;
 
    public IndividualRoom(String roomId, RoomType type) {
        this.roomId = roomId;
        this.type = type;
        this.isBooked = false;
    }
 
    public String getRoomId() {
        return roomId;
    }
 
    public RoomType getType() {
        return type;
    }
 
    public boolean isBooked() {
        return isBooked;
    }
 
    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
 