package com.main;
import java.util.*;

import com.operations.InventoryOps;
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
			
			if(ch.equalsIgnoreCase("single")) {
				int roomCount = roomData.get(RoomType.SINGLE).getCount();
				System.out.print("The current room count is : "+roomCount+"\n How many rooms do you want to add : ");
				int count = sc.nextInt(); sc.nextLine();
				InventoryOps.updateRoomCount(RoomType.SINGLE, choice);
			}else if(ch.equalsIgnoreCase("double")) {
				int roomCount = roomData.get(RoomType.DOUBLE).getCount();
				System.out.print("The current room count is : "+roomCount+"\n How many rooms do you want to add : ");
				int count = sc.nextInt(); sc.nextLine();
				InventoryOps.updateRoomCount(RoomType.DOUBLE, choice);
			}else if(ch.equalsIgnoreCase("suite")) {
				int roomCount = roomData.get(RoomType.SUITE).getCount();
				System.out.print("The current room count is : "+roomCount+"\n How many rooms do you want to add : ");
				int count = sc.nextInt(); sc.nextLine();
				InventoryOps.updateRoomCount(RoomType.SUITE, choice);
			}else {
				System.out.println("Invalid Room Type selection !!");
				return;
			}
		}
		else if(choice==2) {
			System.out.println("\nPlease choose the Room type to update price: Single | Double | Suite");
			String ch = sc.nextLine();
			if(ch.equalsIgnoreCase("single")) {
				double roomPrice  = roomData.get(RoomType.SINGLE).getPrice();
				System.out.print("The current room Price is : "+roomPrice+"\n  Enter the Updated price");
				double price = sc.nextDouble(); sc.nextLine();
				InventoryOps.updateRoomPrice(RoomType.SINGLE, price);
			}else if(ch.equalsIgnoreCase("double")) {
				double roomPrice  = roomData.get(RoomType.DOUBLE).getPrice();
				System.out.print("The current room Price is : "+roomPrice+"\n  Enter the Updated price");
				double price = sc.nextDouble(); sc.nextLine();
				InventoryOps.updateRoomPrice(RoomType.DOUBLE, price);
			}else if(ch.equalsIgnoreCase("suite")) {
				double roomPrice  = roomData.get(RoomType.SUITE).getPrice();
				System.out.print("The current room Price is : "+roomPrice+"\n  Enter the Updated price");
				double price = sc.nextDouble(); sc.nextLine();
				InventoryOps.updateRoomPrice(RoomType.SUITE, price);
			}else {
				System.out.println("Invalid Room Type selection !!");
				return;
			}	
		}
		
		
		
	}
}
