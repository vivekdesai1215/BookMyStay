package com.operations;
import java.util.*;

public class Reservation {
	private String reservationId;
	private List<String> roomIds;
	
	public Reservation(String reservationId,List<String> roomIds) {
		this.reservationId = reservationId;
		this.roomIds = roomIds;
	}

	public String getReservationId() {
		return reservationId;
	}

	public List<String> getRoomIds() {
		return roomIds;
	}
	
	
}
