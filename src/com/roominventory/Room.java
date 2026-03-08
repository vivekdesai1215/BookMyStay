package com.roominventory;
 
import java.util.*;
 
public class Room {
 
    private List<IndividualRoom> rooms;
    private double price;
 
    public Room(RoomType type, int count, double price) {
        this.price = price;
        this.rooms = new ArrayList<>();
 
        for (int i = 1; i <= count; i++) {
            String id = generateRoomId(type, i);
            rooms.add(new IndividualRoom(id, type));
        }
    }
 
    private String generateRoomId(RoomType type, int num) {
 
        switch (type) {
 
            case SINGLE:
                return "S" + (100 + num);
 
            case DOUBLE:
                return "D" + (200 + num);
 
            case SUITE:
                return "SU" + (300 + num);
 
            default:
                return null;
        }
    }
 
    public List<IndividualRoom> getRooms() {
        return rooms;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public int getAvailableCount() {
        int count = 0;
        for (IndividualRoom r : rooms) {
            if (!r.isBooked())
                count++;
        }
 
        return count;
    }
 
    public IndividualRoom allocateRoom() {
        for (IndividualRoom r : rooms) {
            if (!r.isBooked()) {
                r.setBooked(true);
                return r;
            }
        }
 
        return null;
    }
 
	public void addRooms(RoomType type, int count) {
    int start = rooms.size() + 1;
    for(int i = start; i < start + count; i++){
        String id = generateRoomId(type, i);
        rooms.add(new IndividualRoom(id, type));
    }
}
}
 