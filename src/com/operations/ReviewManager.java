package com.operations;
import java.util.*;


public class ReviewManager {
	private static Map<String, Review> reviews = new HashMap<>();
	public static void addReview(String reservationId,Review review) {
		reviews.put(reservationId, review);
		System.out.println("Thank you for your review !");
	}
	
	public static void showReview(String reservationId) {
		Review r = reviews.get(reservationId);
		if(r==null) {
			System.out.println("No review found.");
			return;
			
		}
		System.out.println("Rating : "+r.getRating());
		System.out.println("Message : "+r.getMessage());
	}
	
	public static Review getReview(String reservationId) {
		return reviews.get(reservationId);
	}
}
