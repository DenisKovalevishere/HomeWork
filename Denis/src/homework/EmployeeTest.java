package homework;

public class EmployeeTest {

		public static void main(String[] args) {
			Employee Em1 = new Employee (34, "Ivanov", 3466.34, "Sales", 54);
			Em1.info1();
			
			Employee Em2 = new Employee (65, "Petrov", 3466.45, "IT");
			Em2.info2();
			
//			Employee Em3 = new Employee (36, "Sidorov", 4357.45);
//			Em3.info3();
			
			System.out.println(Em1.id);
			System.out.println(Em1.surname);
		//	System.out.println(Em1.salary);
			
		
		}
	}
