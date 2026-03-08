package com.operations;
import java.util.*;


public class ReservationManager {
	private static Map<String,Reservation> reservations = new HashMap<>();
	
	public static void addReservation(Reservation reservation) {
		reservations.put(reservation.getReservationId(), reservation);
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
		for(String id : reservations.keySet()) {
			System.out.println("Reservation Id : "+id);
		}
	}
}
