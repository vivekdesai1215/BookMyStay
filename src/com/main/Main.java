package com.main;
import java.util.*;

import com.operations.InventoryOps;
import com.operations.Operator;
import com.roominventory.*;


public class Main {
	
	public static HashMap<RoomType,Room> roomData = new HashMap<>();
	static {
		roomData.put(RoomType.SINGLE, new Room(10,1000.0));
		roomData.put(RoomType.DOUBLE, new Room(5,2500.0));
		roomData.put(RoomType.SUITE, new Room(3,5000.0));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-----------------------------------------");
		System.out.println("---------WELCOME to BOOK_MY_STAY---------");
		System.out.println("-----------------------------------------");
		System.out.println("\n");
		
		System.out.println("Inventory Management : \n 1. Update Room Count \n 2. Update Room Price \n 3. Skip Inventory Management \n  : ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		if(choice==1) {
			System.out.println("\nPlease choose the Room type : Single | Double | Suite");
			String ch = sc.nextLine();
			try {
			    RoomType type = RoomType.valueOf(ch.toUpperCase()); // convert input to enum
			    int roomCount = roomData.get(type).getCount();
			    System.out.print("The current room count is : " + roomCount + 
			                     "\n How many rooms do you want to add : ");
			    int count = sc.nextInt(); sc.nextLine();
			    InventoryOps.updateRoomCount(type, count);
			} catch (IllegalArgumentException e) {
			    System.out.println("Invalid Room Type selection !!");
			}

		}
		else if(choice==2) {
			System.out.println("\nPlease choose the Room type to update price: Single | Double | Suite");
			String ch = sc.nextLine();
			String input = ch.toUpperCase();
			try {
			    RoomType type = RoomType.valueOf(input); // Convert user input to enum
			    double roomPrice = roomData.get(type).getPrice();
			    System.out.print("The current room Price is : " + roomPrice + "\n  Enter the Updated price: ");
			    double price = sc.nextDouble(); sc.nextLine();
			    InventoryOps.updateRoomPrice(type, price);
			} catch (IllegalArgumentException e) {
			    System.out.println("Invalid Room Type selection !!");
			}
	
		}
		
		
		System.out.println("-----------------------------------------");
		System.out.println("\n Room Booking :");
		System.out.println("\n 1. Check Rooms availability \n 2. Check room prices \n 3. Book Rooms(CheckIn) \n 4. Checkout \n : ");
		int ch02 = sc.nextInt();sc.nextLine();
		
		switch(ch02){
		case 1:{
			Operator.showAvailableRooms();
			break;
		}
		case 2:{
			Operator.checkRoomPrices();
			break;
		}
		
		}
	}
}














