package com.booking;
 
import java.util.LinkedList;
import java.util.Queue;

import com.operations.BookingRequest;
import com.roominventory.RoomType;
 


public class BookingQueue{
	private static Queue<BookingRequest> bookingRequests = new LinkedList<>();
	public static void addBooking(BookingRequest request) {
		bookingRequests.offer(request);
		System.out.println("Booking request added to queue");
	}
	
	public static BookingRequest processBooking() {
		return bookingRequests.poll();
	}
	public static boolean hasBookings() {
		return !bookingRequests.isEmpty();
	}
}
 