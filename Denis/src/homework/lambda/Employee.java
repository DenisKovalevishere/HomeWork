package homework.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Employee {
	String name;
	String department;
	double salary;
	
	Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

}


class TestEmployee {
	
	void printEmployee(Employee e) {
		System.out.println("Name employee: " + e.name + ". Departmrnt employee: " +
	e.department + ". Salary employee: " + e.salary + ".");
	}
	
	void filtraciyaRabotnikov(ArrayList<Employee> aL, Predicate<Employee> t) {
		for (Employee e:aL) {
			if(t.test(e)) {
				printEmployee(e);
			}
		}
	}
	
	public static void main(String[] args) {
		
	
	
	ArrayList<Employee> list = new ArrayList<>();
	Employee e1 = new Employee("Ivan", "IT", 150.00);
	Employee e2 = new Employee("Elena", "Sales", 300.00);
	Employee e3 = new Employee("Petr", "IT", 500.00);
	Employee e4 = new Employee("Ekaterina", "Sales", 450.00);
	Employee e5 = new Employee("Viktor", "IT", 600.00);
	Employee e6 = new Employee("Roman", "IT", 100.00);
	Employee e7 = new Employee("Nataliya", "Sales", 850.00);
	Employee e8 = new Employee("Karl", "Sales", 150.00);
	list.add(e1);
	list.add(e2);
	list.add(e3);
	list.add(e4);
	list.add(e5);
	list.add(e6);
	list.add(e7);
	list.add(e8);
	
	TestEmployee tE = new TestEmployee();
	tE.filtraciyaRabotnikov(list, e->e.department.equals("IT") && e.salary>200);
	tE.filtraciyaRabotnikov(list, e->e.name.startsWith("E") && e.salary!=450);
	tE.filtraciyaRabotnikov(list, e->e.name.equals(e.department));
	
	
	}
}
