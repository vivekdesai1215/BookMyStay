package com.operations;
 
import com.main.Main;
import com.roominventory.Room;
import com.roominventory.RoomType;
 
public class InventoryOps {
    public static void updateRoomCount(RoomType roomtype, int count) {
        Room room = Main.roomData.get(roomtype);
        room.addRooms(roomtype, count);
        int totalRooms = room.getRooms().size();
        int availableRooms = room.getAvailableCount();
        System.out.println("\nRooms successfully added.");
        System.out.println("Total rooms: " + totalRooms);
        System.out.println("Available rooms: " + availableRooms);
    }
 
    public static void updateRoomPrice(RoomType roomtype, double price) {
 
        Room room = Main.roomData.get(roomtype);
 
        room.setPrice(price);
 
        int totalRooms = room.getRooms().size();
        int availableRooms = room.getAvailableCount();
 
        System.out.println("\nRoom price updated successfully.");
 
        System.out.println("Price per night: " + room.getPrice());
        System.out.println("Total rooms: " + totalRooms);
        System.out.println("Available rooms: " + availableRooms);
    }
}