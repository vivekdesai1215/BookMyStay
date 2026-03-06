package com.operations;
import com.main.Main;
import com.roominventory.Room;
import com.roominventory.RoomType;

import java.util.*;


public class Operator {
	
	
	public void showAvailableRooms() {
		HashMap<RoomType,Room> map = Main.roomData;
		System.out.println("Available Rooms : ");
		for(Map.Entry<RoomType, Room> entry : map.entrySet()) {
			System.out.println("Room Type : "+entry.getKey()+" | Available rooms count : "+entry.getValue().getCount()+" | Room Price : "+entry.getValue().getPrice());
		}
	}
	
	public boolean bookRooms(RoomType roomtype,int count) {
		
		if(Main.roomData.get(roomtype).getCount() ==0) return false;
		else {
			System.out.println("Booking "+count+" rooms of type : "+roomtype+" ........");
			Main.roomData.get(roomtype).setCount(Main.roomData.get(roomtype).getCount()-count);
			return true;
		}
	}
	
public boolean freeARoom(RoomType roomtype) {
			Main.roomData.get(roomtype).setCount(Main.roomData.get(roomtype).getCount()+1);
			return true;
		}
	}
	
