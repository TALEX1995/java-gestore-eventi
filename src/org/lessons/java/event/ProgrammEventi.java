package org.lessons.java.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammEventi {
	private String title;
	private List<Evento> events;
	
	public ProgrammEventi(String title) {
		setTitle(title);
		this.events = new ArrayList<>();
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void addEvent(Evento e) {
		events.add(e);
	}
	
	public List<Evento> eventOnDate(LocalDate date){
		List<Evento> eventsOnDate = new ArrayList<>();
		
		for(Evento e: events) {
			if(e.getDate().equals(date)) {
				eventsOnDate.add(e);
			}
		}
		return eventsOnDate;
	}
	
	
	public int eventNumber() {
		return events.size();
	}
	
	public void clearEvents() {
		events.clear();
	}
	
	public String orderedEvents() {
		String result = "";
		events.sort(Comparator.comparing(Evento::getDate));
        for (Evento evento : events) {
            result += evento.getDate() + " - " + evento.getTitle() + "\n";
        }
        return result;
	}
}
