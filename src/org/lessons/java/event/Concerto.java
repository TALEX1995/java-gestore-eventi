package org.lessons.java.event;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalTime hour;
	private BigDecimal price;
	
	public Concerto(String title, LocalDate date, int totalSeatsNumber, LocalTime hour, BigDecimal price) throws Exception {
		super(title, date, totalSeatsNumber);
		setHour(hour);
		setPrice(price);
	}

	public LocalTime getHour() {
		return hour;
	}

	public void setHour(LocalTime hour) {
		this.hour = hour;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getFullDate() {
		LocalDate date = super.getDate();
		LocalTime time = hour;
		LocalDateTime dateTime = time.atDate(date);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		
		String formattedDateTime = dateTime.format(formatter);
		 
		return  "Data e ora del concerto: " + formattedDateTime;
	}
	
	public String getFormattedPrice() {
		return "Costo del biglietto: " + NumberFormat.getCurrencyInstance().format(price);
	}
	
	@Override
	public String toString() {
		return getFullDate() 
		+ " - " + super.getTitle()
		+ " - " + getFormattedPrice();
	}
}
