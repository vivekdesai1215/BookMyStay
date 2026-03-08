package com.operations;
 
import com.main.Main;
import com.roominventory.*;
import com.booking.BookingQueue;
 
import java.util.*;
 
public class Operator {
    public static void showAvailableRooms() {
        Map<RoomType, Room> map = Main.roomData;
        for (Map.Entry<RoomType, Room> entry : map.entrySet()) {
            System.out.println(
                    entry.getKey() +
                    " | Available: " +
                    entry.getValue().getAvailableCount());
        }
    }
 
    public static void checkRoomPrices() {
        Map<RoomType, Room> map = Main.roomData;
        for (Map.Entry<RoomType, Room> entry : map.entrySet()) {
            System.out.println(
                    entry.getKey() +
                    " | Price: " +
                    entry.getValue().getPrice());
        }
    }
 
    public static String bookRooms(RoomType type,int count) {
    	BookingRequest request = new BookingRequest(type,count);
    	BookingQueue.addBooking(request);
    	BookingRequest booking = BookingQueue.processBooking();
    	
    	if(booking==null) {
    		return null;
    	}
    	
    	Room room = Main.roomData.get(booking.getRoomType());
    	if(room.getAvailableCount()<booking.getRoomCount()) {
    		return null;
    	}
    	
    	List<String> allocatedRooms = new ArrayList<>();
    	for(int i=0;i<booking.getRoomCount();i++) {
    		IndividualRoom allocated = room.allocateRoom();
    		allocatedRooms.add(allocated.getRoomId());
    	}
    	
    	String reservationId = "RES"+System.currentTimeMillis();
    	Reservation reservation = new Reservation(reservationId,allocatedRooms);
    	
    	ReservationManager.addReservation(reservation);
    	System.out.println("\n Booking Confirmed !");
    	System.out.println("Reservation Id : "+reservationId);
    	
    	for(String r:allocatedRooms) {
    		System.out.println("Room Allocated : "+r);
    	}
 
        return reservationId;
    }
 
    public static boolean freeARoom(String roomId) {
        for (Room room : Main.roomData.values()) {
            for (IndividualRoom r : room.getRooms()) {
                if (r.getRoomId().equalsIgnoreCase(roomId)) {
                    if (!r.isBooked())
                        return false;
                    r.setBooked(false);
                    System.out.println("Checkout successful from room " + roomId);
                    return true;
                }
            }
        }
        return false;
    }
}
 