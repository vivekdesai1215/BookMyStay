package com.operations;
import com.booking.BookingLimiter;
import com.booking.BookingQueue;
import com.main.Main;
import com.roominventory.Room;
import com.roominventory.RoomType;

import java.util.*;


public class Operator {


	public static void showAvailableRooms() {
		HashMap<RoomType,Room> map = Main.roomData;
		System.out.println("Available Rooms : ");
		for(Map.Entry<RoomType, Room> entry : map.entrySet()) {
			System.out.println("Room Type : "+entry.getKey()+" | Available rooms count : "+entry.getValue().getCount());
		}
	}

	public static boolean bookRooms(RoomType roomtype, int count) {
	    Room room = Main.roomData.get(roomtype);
	    if (room.getCount() < count) return false;

	    // Add to queue
	    BookingQueue.addBooking(roomtype, count);

	    // Process immediately (or later if you want async)
	    String bookingInfo = BookingQueue.processBooking();
	    System.out.println("Processing " + bookingInfo);

	    room.setCount(room.getCount() - count);

	    // Track booked rooms
	    Room booked = Main.bookedRooms.get(roomtype);
	    if (booked == null) {
	        booked = new Room(0, room.getPrice());
	        Main.bookedRooms.put(roomtype, booked);
	    }
	    booked.setCount(booked.getCount() + count);

	    return true;
	}



	public static boolean freeARoom(RoomType roomtype) {
	    Room booked = Main.bookedRooms.get(roomtype);
	    if (booked == null || booked.getCount() == 0) {
	        return false; 
	    }

	    booked.setCount(booked.getCount() - 1);
	    Main.roomData.get(roomtype).setCount(Main.roomData.get(roomtype).getCount() + 1);

	    System.out.println("Successfully checked out from " + roomtype + " room.");
	    return true;
	}

	
	public static void checkRoomPrices() {
		HashMap<RoomType,Room> map = Main.roomData;
		System.out.println("Available Rooms : ");
		for(Map.Entry<RoomType, Room> entry : map.entrySet()) {
			System.out.println("Room Type : "+entry.getKey()+" | Room Price : "+entry.getValue().getPrice());
		}
	}
}


