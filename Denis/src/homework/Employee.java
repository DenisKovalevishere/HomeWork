package homework;

public class Employee {

	int id;
    public String surname;
    int age;
    String departament;
    private double salary;
    
    private Employee (int id1, String surname1, double salary1) {
    	this (id1, surname1, salary1, null, 0);
    	
    }
    public Employee (int id2, String surname2, double salary2, String departament2, int age2) {
    	id = id2;
    	surname = surname2;
    	salary = salary2;
    	departament = departament2;
    	age = age2;
    }
    Employee (int id3, String surname3, double salary3, String departament3) {
    	this (id3, surname3, salary3, departament3, 0);	
    }

    double uvelichenie() {
        salary*=2;
        System.out.println("Zarplata uvelichena v dvoe: " + salary);
        return salary;
    }

    public void info1() {
        System.out.println("ID: " + id);
        System.out.println("Surname: " + surname);
        System.out.println("Vozrast: " + age);
        System.out.println("Department: " + departament);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
    void info2 () {
    	System.out.println("ID: " + id);
        System.out.println("Surname: " + surname);
        System.out.println("Department: " + departament);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
    private void info3 () {
    	System.out.println("ID: " + id);
        System.out.println("Surname: " + surname);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}
