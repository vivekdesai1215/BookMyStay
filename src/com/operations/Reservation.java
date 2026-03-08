package com.operations;
import java.util.*;

public class Reservation {
	private String reservationId;
	private List<String> roomIds;
	private double roomCost;
	private boolean checkout;
	
	public Reservation(String reservationId,List<String> roomIds,double roomCost) {
		this.reservationId = reservationId;
		this.roomIds = roomIds;
		this.roomCost=roomCost;
		this.checkout = false;
	}

	public double getRoomCost() {
		return roomCost;
	}

	public String getReservationId() {
		return reservationId;
	}

	public List<String> getRoomIds() {
		return roomIds;
	}
	
	public boolean isCheckedOut() {
		return checkout;
	}
	public void setCheckOut(boolean checkedOut) {
		this.checkout = checkedOut;
	}
	
}
