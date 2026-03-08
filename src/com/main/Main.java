package com.main;
 
import java.util.*;
 
import com.operations.InventoryOps;
import com.operations.Operator;
import com.operations.ReservationManager;
import com.operations.Service;
import com.operations.ServiceManager;
import com.roominventory.*;
 
public class Main {
 
    public static HashMap<RoomType, Room> roomData = new HashMap<>();
 
    static {
        roomData.put(RoomType.SINGLE, new Room(RoomType.SINGLE, 10, 1000));
        roomData.put(RoomType.DOUBLE, new Room(RoomType.DOUBLE, 5, 2500));
        roomData.put(RoomType.SUITE, new Room(RoomType.SUITE, 3, 5000));
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        System.out.println("-----------------------------------------");
        System.out.println("---------WELCOME to BOOK_MY_STAY---------");
        System.out.println("-----------------------------------------");
        System.out.println();
 
        System.out.println("Inventory Management :");
        System.out.println("1 Update Room Count");
        System.out.println("2 Update Room Price");
        System.out.println("3 Skip Inventory Management");
        System.out.print(": ");
 
        int choice = sc.nextInt();
        sc.nextLine();
 
        if (choice == 1) {
 
            System.out.println("\nChoose Room Type : SINGLE | DOUBLE | SUITE");
            String ch = sc.nextLine();
 
            try {
 
                RoomType type = RoomType.valueOf(ch.toUpperCase());
                System.out.println("Current total rooms: " + roomData.get(type).getRooms().size());
                System.out.print("How many rooms do you want to add: ");
                int count = sc.nextInt();
                sc.nextLine();
                InventoryOps.updateRoomCount(type, count);
 
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Room Type selection !!");
            }
 
        }
 
        else if (choice == 2) {
 
            System.out.println("\nChoose Room Type to update price: SINGLE | DOUBLE | SUITE");
            String ch = sc.nextLine();
 
            try {
                RoomType type = RoomType.valueOf(ch.toUpperCase());
                System.out.println("Current price: " + roomData.get(type).getPrice());
                System.out.print("Enter updated price: ");
                double price = sc.nextDouble();
                sc.nextLine();
                InventoryOps.updateRoomPrice(type, price);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Room Type selection !!");
 
            }
 
        }
 
        boolean end = false;
 
        do {
 
            System.out.println("-----------------------------------------");
            System.out.println("\nRoom Booking:");
            System.out.println("1 Check Rooms availability");
            System.out.println("2 Check room prices");
            System.out.println("3 Book Room");
            System.out.println("4 Checkout");
            System.out.println("5 Add Services");
            System.out.println("6 Exit");
            System.out.println("7 Bakc to Inventory Management");
            System.out.print(": ");
 
            int ch02 = sc.nextInt();
            sc.nextLine();
 
            switch (ch02) {
                case 1:
                    Operator.showAvailableRooms();
                    break;
 
                case 2:
                    Operator.checkRoomPrices();
                    break;
 
                case 3:
                    System.out.print("\nSelect room type (SINGLE, DOUBLE, SUITE): ");
                    RoomType roomtype = RoomType.valueOf(sc.nextLine().toUpperCase());
                    System.out.print("Number of rooms you want : ");
                    int count = sc.nextInt(); sc.nextLine();
                    String success = Operator.bookRooms(roomtype,count);
 
                    if (success==null)
                        System.out.println("Requested room not available.");
 
                    break;
 
                case 4:
                    System.out.print("\nEnter Room ID for checkout: ");
                    String roomId = sc.nextLine();
 
                    boolean checkout = Operator.freeARoom(roomId);
 
                    if (!checkout)
                        System.out.println("Invalid Room ID or room not booked.");
 
                    break;
                
                case 5:{
                	System.out.print("Enter Reservation Id: ");
                	String resId = sc.nextLine();
                	if(!ReservationManager.reservationExists(resId)) {
                		System.out.println("Invalid Reservation Id !");
                		break;
                	}
                	
                	System.out.println("\n Select Services \n 1. Breakfast \n 2. Airport Pickup \n 3. Spa ");
                	int sChoice = sc.nextInt();
                	Service service = null;
                	switch(sChoice) {
                	case 1:{
                		service = new Service("Breakfast",300);
                		break;
                	}
                	case 2:
                		service = new Service("Airport Pickup",800);
                		break;
                	
                	case 3:
                		service = new Service("Spa",1500);
                	}
                	
                	ServiceManager.addService(resId, service);
                	break;
                }
                case 7 :{
                	Main.main(args);
                }
 
                default:
                    end = true;
            }
 
        } while (!end);
 
        sc.close();
    }
}