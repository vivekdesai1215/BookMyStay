package com.booking;
import java.util.LinkedList;
import java.util.Queue;
import com.roominventory.RoomType;



public class BookingQueue {
    private static Queue<String> bookingRequests = new LinkedList<>();

    public static void addBooking(RoomType type, int count) {
        String bookingInfo = "Booking " + count + " rooms of type: " + type;
        bookingRequests.offer(bookingInfo);
        System.out.println("Booking added to queue: " + bookingInfo);
    }

    public static String processBooking() {
        return bookingRequests.poll();
    }

    public static boolean hasBookings() {
        return !bookingRequests.isEmpty();
    }
}
