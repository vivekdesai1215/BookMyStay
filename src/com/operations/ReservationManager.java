package com.operations;
import java.util.*;


public class ReservationManager {
	private static Map<String,Reservation> reservations = new HashMap<>();
	private static List<Reservation> reservationHistory = new ArrayList<>();
	
	
	public static void addReservation(Reservation reservation) {
		reservations.put(reservation.getReservationId(), reservation);
		reservationHistory.add(reservation);
	}
	
	public static boolean reservationExists(String reservationId) {
		return reservations.containsKey(reservationId);
	}
	
	public static Reservation getReservation(String reservationId) {
		return reservations.get(reservationId);
	}
	
	public static void showAllReservations() {
		if(reservations.isEmpty()) {
			System.out.println("No Reservations yet.");
		}
		
		System.out.println("\n -------- Booking History-- -----");
		for(Reservation r : reservationHistory) {
			System.out.println("\n");
			String resId = r.getReservationId();
			System.out.println("Reservation Id : "+r.getReservationId());
			System.out.println("Rooms Booked : "+r.getRoomIds());
			System.out.println("Room Cost : "+r.getRoomCost());
			System.out.println("\n Status : "+(r.isCheckedOut()?"CHECKED OUT": "ACTIVE "));
			System.out.println("\n Services : ");
			ServiceManager.showServices(resId);
			double serviceCost = ServiceManager.calculateServiceCost(resId);
			System.out.println("Service Cost : "+serviceCost);
			System.out.println("Total Bill : "+(r.getRoomCost()+serviceCost));
			
			Review review = ReviewManager.getReview(resId);
			if(review!=null) {
				System.out.println("\nRating : "+review.getRating());
				System.out.println("Review : "+review.getMessage());
			}
			System.out.println("----------------------------");
		}
	}
	
	public static void cancelReservation(String reservationId) {
		Reservation reservation = reservations.remove(reservationId);
		if(reservation==null) {
			System.out.println("Reservation Not Found.");
			return;
		}
		System.out.println("Reservation cancelled : "+reservationId);
	}
}
