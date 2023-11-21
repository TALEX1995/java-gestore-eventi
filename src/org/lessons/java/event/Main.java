package org.lessons.java.event;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		LocalDate b = LocalDate.parse("2024-03-25");
		try {
			Evento a = new Evento("sdff", b, 1);
			
			a.reserve();
			a.cancelReserve();
			a.reserve();
			a.cancelReserve();
			System.out.println(a);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
