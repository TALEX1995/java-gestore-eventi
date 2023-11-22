package org.lessons.java.event;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		
//		Milestone 3 ---------------------------------------
		LocalDate ld = LocalDate.parse("2024-10-10");
		LocalTime lt = LocalTime.parse("12:30:40");
		BigDecimal bd = new BigDecimal("20.50");
		
		try {
			Concerto concert = new Concerto("Mio concerto", ld, 200, lt, bd);
			System.out.println(concert.getFullDate());
			System.out.println(concert.getFormattedPrice());
			System.out.println(concert);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
//		----------------------------------------------------
		
//		Milestone 4 ---------------------------------------
		ProgrammEventi p = new ProgrammEventi("Mostra");
		LocalDate localD = LocalDate.parse("2024-08-08");
		try {
			Evento ev = new Evento("mioEvento", ld, 200);
			Evento eve = new Evento("tuoEvento", localD, 100);
			p.addEvent(ev);
			p.addEvent(eve);
			System.out.println("Milestone 4: \n" + p.orderedEvents());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
//		----------------------------------------------------
		
		
//		Milestone 2 ----------------------------------------
		Scanner in = new Scanner(System.in);
		
		System.out.println("Inserisci il nome dell'evento");
		String title = in.nextLine();
		
//		Validation user input data
		boolean correctData = false;
		LocalDate date = null;
		while(!correctData) {
			System.out.println("Inserisci la data dell'evento con formato YYYY-MM-DD");
			String strDate = in.nextLine();	
			try {
	            date = LocalDate.parse(strDate);
	            correctData = true;
	        } catch (DateTimeParseException e) {
	            System.out.println("Formato data non valido. Assicurati di usare il formato YYYY-MM-DD.");
	        }
		}
		
//		Validation user input total seats
		boolean correctSeats = false;
		int totalSeats = 0;
		while(!correctSeats) {
			System.out.println("Inserisci il numero di posti totali");
			String strTotalSeats = in.nextLine();
			
			try {
				totalSeats = Integer.parseInt(strTotalSeats);
				if(totalSeats > 0) {
					correctSeats = true;
				} else {
					System.out.println("Il numero di posti deve essere superiore a zero");
				}
				
			} catch(NumberFormatException e) {
				System.out.println("Il numero di posti totali deve essere superiore a zero");
			}
		}
		
//		Instantiate new Event
		Evento event = null;
		try {
			event = new Evento(title, date, totalSeats);
			System.out.println(event);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
//		Request to user if he want to reserve 1 or more seats
		System.out.println("Vuoi effettuare delle prenotazioni per questo evento? \n 1 = SI \n 2 = NO");
		String strUserReserve = in.nextLine();
		int userReserve = Integer.parseInt(strUserReserve);
		
		if(userReserve == 2) {
			in.close();
			return;
		}
		
//		Check if the number of user reserve is less than the available seats
		int seatsNumberReserve = Integer.MAX_VALUE;
		
		while(seatsNumberReserve > event.getAvailableSeats()) {
			System.out.println("Quanti posti vuoi prenotare?");
			String strSeatsNumberReserve = in.nextLine();
			seatsNumberReserve = Integer.parseInt(strSeatsNumberReserve);
			
			if(seatsNumberReserve > event.getAvailableSeats()) {
				System.out.println("I posti ancora disponibili per questa data sono: " + event.getAvailableSeats() + ", riprova");
			}
		}
		
//		Reserve seats
		try {
			for(int i = 0; i < seatsNumberReserve; i++) {
				event.reserve();
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
//		Print total seats, reserved seats and available seats
		System.out.println("---------------------------------------------\n"
							+"L'evento ha un totale di: " + event.getTotalSeatsNumber() + " posti"
							+ "\n" + "Sono stati prenotati: " + event.getReservedSeats() + " posti"
							+ "\n" + "Rimangono quindi: " + event.getAvailableSeats() + " posti"
							+ "\n---------------------------------------------");
		
		
//		Request to user if he want to cancel reserve seat
		System.out.println("Vuoi cancellare delle prenotazioni per questo evento? \n 1 = SI \n 2 = NO");
		String strUserCancelReserve = in.nextLine();
		int userCancelReserve = Integer.parseInt(strUserCancelReserve);
		
		if(userCancelReserve == 2) {
			in.close();
			return;
		}
		
//		Check if the number of user cancel reserve is less than the reserved seats	
		int cancelSeatsReserve = Integer.MAX_VALUE;
		
		while(cancelSeatsReserve > event.getReservedSeats()) {
			System.out.println("Quante prenotazioni vuoi cancellare?");
			String strCancelReserveNumber = in.nextLine();
			cancelSeatsReserve = Integer.parseInt(strCancelReserveNumber);
			
			if(cancelSeatsReserve > event.getReservedSeats()) {
				System.out.println("Le prenotazioni che vuoi eliminare sono superiori ai posti prenotati. \nI posti prenotati sono: " + event.getReservedSeats() + ", riprova");
			}
		}
		
//		Cancel Reserved seats
		try {
			for(int i = 0; i < cancelSeatsReserve; i++) {
				event.cancelReserve();
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
//		Print total seats, reserved seats and available seats
		System.out.println("---------------------------------------------\n"
				+"L'evento ha un totale di: " + event.getTotalSeatsNumber() + " posti"
				+ "\n" + "Sono stati prenotati: " + event.getReservedSeats() + " posti"
				+ "\n" + "Rimangono quindi: " + event.getAvailableSeats() + " posti"
				+ "\n---------------------------------------------");
		
		in.close();
		
		
	}

}
