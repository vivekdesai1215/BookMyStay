package com.operations;
import com.roominventory.RoomType;

public class BookingRequest {
	private RoomType roomType;
	private int roomCount;
	
	public BookingRequest(RoomType roomType, int roomCount) {
		this.roomType = roomType;
		this.roomCount = roomCount;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public int getRoomCount() {
		return roomCount;
	}
	
}
