package homework;

public class StudentSravn {
	
public static void sravn (Student st1, Student st2) {
	if (st1.name.equals(st2.name) && st1.studyYear == st2.studyYear && st1.srednee == st2.srednee) {
		System.out.println("Studenti odinakovie");
	} else {
		System.out.println("Studenti NE odinakovie");
	}
	System.out.println();
}

	
public static void sravnpolnoe (Student st1, Student st2) {
	
if (st1.name.equals(st2.name)) {
	 if (st1.studyYear == st2.studyYear) {
		if (st1.srednee == st2.srednee) {
			System.out.println("Studenti RAVNI");
		} else {
			System.out.println("Imena studentos i kursi odinakovie, NO ocenki raznie");
		} 
	}	else {	
			System.out.println("Imena studentov odinakovie, NO kursi i ocenki raznie");
	}
	} else { 
		if (st1.studyYear == st2.studyYear) {
			if (st1.srednee == st2.srednee) {
			System.out.println("Imena studentov RAZNIE, NO kursi i ocenki odinakovie");
			} else {
			System.out.println("Imena studentov i ocenki RAZNIE, NO kursi odinakovie");
		} 
		} else { 
			if (st1.srednee == st2.srednee) {
			System.out.println("Imena studentov i kursi RAZNIE, no ocenki odinakovie");
			} else
			System.out.println("Imena studentov, kursi i ocenki RAZNIE");
		}
	}
	System.out.println();
 }

public static void main(String[] args) {

	Student st1 = new Student("Denis", 4, 4.6, 4.3, 4.8);
    Student st2 = new Student("Denis", 4, 4.6, 4.3, 4.8);
    
    sravn(st1, st2);
    sravnpolnoe(st1, st2); 

}
}