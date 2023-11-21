package org.lessons.java.event;

import java.time.LocalDate;

public class Evento {

	private String title;
	private LocalDate date;
	private int totalSeatsNumber;
	private int reservedSeats;
	
	public Evento(String title, LocalDate date, int totalSeatsNumber) {
		setTitle(title);
		setDate(date);
		setTotalSeatsNumber(totalSeatsNumber);
		reservedSeats = 0;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getTotalSeatsNumber() {
		return totalSeatsNumber;
	}
	private void setTotalSeatsNumber(int totalSeatsNumber) {
		this.totalSeatsNumber = totalSeatsNumber;
	}
	public int getReservedSeats() {
		return reservedSeats;
	}
	
}
