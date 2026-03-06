package com.operations;
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

	public static boolean bookRooms(RoomType roomtype,int count) {

		if(Main.roomData.get(roomtype).getCount() ==0) return false;
		else {
			System.out.println("Booking "+count+" rooms of type : "+roomtype+" ........");
			Main.roomData.get(roomtype).setCount(Main.roomData.get(roomtype).getCount()-count);
			return true;
		}
	}

	public static boolean freeARoom(RoomType roomtype) {
		
		Main.roomData.get(roomtype).setCount(Main.roomData.get(roomtype).getCount()+1);
		System.out.println("Successfully checked out from "+roomtype+" room.");
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


