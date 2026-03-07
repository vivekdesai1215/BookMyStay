package com.booking;

public class BookingLimiter {
    private static long lastBookingTime = 0;
    private static final int waitTime = 10000;

    public static boolean canBook() {
        long now = System.currentTimeMillis();
        return (now - lastBookingTime) >= waitTime;
    }

    public static void recordBooking() {
        lastBookingTime = System.currentTimeMillis();
    }
}
