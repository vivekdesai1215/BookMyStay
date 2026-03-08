package com.operations;

public class Review {
	private int rating;
	private String message;
	public Review(int rating, String message) {
		super();
		this.rating = rating;
		this.message = message;
	}
	public int getRating() {
		return rating;
	}
	public String getMessage() {
		return message;
	}
}
