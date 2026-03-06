package com.operations;
import com.main.Main;
import com.roominventory.RoomType;


public class InventoryOps {
	
	public static void updateRoomCount(RoomType roomtype,int count) {
		Main.roomData.get(roomtype).setCount(Main.roomData.get(roomtype).getCount()+count);
		System.out.println("Updated room count : "+Main.roomData.get(roomtype).getCount());
	}
	
	public static void updateRoomPrice(RoomType roomtype, double price) {
		Main.roomData.get(roomtype).setPrice(price);
		System.out.println("Updated room Price : "+Main.roomData.get(roomtype).getPrice());
	}
}
