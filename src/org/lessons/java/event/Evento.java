package org.lessons.java.event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String title;
	private LocalDate date;
	private int totalSeatsNumber;
	private int reservedSeats;
	
	public Evento(String title, LocalDate date, int totalSeatsNumber) throws Exception {
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
	
	public void setDate(LocalDate date) throws Exception {
//		Check if date is before today
		LocalDate localDate = LocalDate.now();
		if(date.isBefore(localDate)) {
			throw new Exception("Errore: La data dell'evento non può essere antecedente alla data di oggi");
		}
			
		this.date = date;
	}
	
	public int getTotalSeatsNumber() {
		return totalSeatsNumber;
	}
	
	private void setTotalSeatsNumber(int totalSeatsNumber) throws Exception{
//		Check if total seats is 0 or less
		if(totalSeatsNumber <= 0) {
			throw new Exception("Errore: I posti devono essere superiori a zero");
		}
		this.totalSeatsNumber = totalSeatsNumber;
	}
	
	public int getReservedSeats() {
		return reservedSeats;
	}
	
	public void reserve() throws Exception {
		
		checkDate("Non puoi prenotare un posto per questo evento perchè si è già concluso");
		
//		Check if there are remaining seats
		if((totalSeatsNumber - reservedSeats) < 1) {
			throw new Exception("Errore: I posti per questo evento sono stati tutti prenotati");
		}
		
		reservedSeats++;
	}
	
	public void cancelReserve() throws Exception {
		
		checkDate("Non puoi cancellare un posto per questo evento perchè si è già concluso");
		
//		Check if reserved seats are 0 or less
		if(reservedSeats < 1) {
			throw new Exception("Errore: Non risultano prenotazioni per questo evento");
		}
		
		reservedSeats--;
	}
	
	private void checkDate(String message) throws Exception{
//		Check if Event date is before local date
		LocalDate localDate = LocalDate.now();
		if(date.isBefore(localDate)) {
			throw new Exception("Errore: " + message);
		}
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = date.format(dateTimeFormatter);
		
		return formattedDate + " - " + title;
	}
	
	
}
