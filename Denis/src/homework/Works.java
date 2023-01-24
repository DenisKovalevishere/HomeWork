package homework;

import java.time.*;
import java.time.format.*;


public class Works {
	
	
	DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy, MMMM-dd !! hh:mm");
	DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh:mm, dd/MM/yy");

	
	void smena(LocalDateTime ldt1, LocalDateTime ldt2, Period p, Duration d) {
		
		LocalDateTime nachalo =ldt1;
		while (nachalo.isBefore(ldt2)) {
			System.out.println("Rabotaem s:" + nachalo.format(f1));
			nachalo = nachalo.plus(p);
			System.out.println("Do: " + nachalo.format(f1));
			System.out.println("Otdixaem s: " + nachalo.format(f2));
			nachalo = nachalo.plus(d);
			System.out.println("Do: " + nachalo.format(f2));
		}
		
	}
	
	public static void main(String[] args) {
		
		Works w = new Works();
		
	LocalDateTime ldt1 = LocalDateTime.of(2016, 1, 1, 9,30);
	LocalDateTime ldt2 = LocalDateTime.of(2016, 2, 3, 9,00);
	Period p = Period.of(0,1,2);
	Duration d = Duration.ofMinutes(600);

	w.smena(ldt1, ldt2, p, d);
		
	}
}
