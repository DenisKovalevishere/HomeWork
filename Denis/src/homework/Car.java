package homework;

public class Car {
	
	String color;
	String engine;
	int door;
	

public Car (String color, String engine, int door) {
	this.color = color;
	this.engine = engine;
	this.door = door;
}
}

class CarTest {
	
	public static void changeDoor (Car s4, int d1) {
		s4.door = d1;
		
	}
	
	public static void swap (Car s1, Car s2) {
		String color = s1.color;
		String engine = s1.engine;
		
		s1.color = s2.color;
		s1.engine = s2.engine;
		
		s2.color = color;
		s2.engine = engine;
		
	}
	
	
	public static void main(String[] args) {

		Car car1 = new Car("Blue", "V6", 2);
		System.out.println(car1.color);
		System.out.println(car1.engine);
		System.out.println(car1.door);
		System.out.println();
	
		Car car2 = new Car("Red", "V8", 4);
		System.out.println(car2.color);
		System.out.println(car2.engine);
		System.out.println(car2.door);
		System.out.println();
		
		swap(car1, car2);
		
		System.out.println(car1.color);
		System.out.println(car1.engine);
		System.out.println();
		System.out.println(car2.color);
		System.out.println(car2.engine);
		System.out.println();
		
		changeDoor(car1, 4);
		System.out.println(car2.door);
		
	}
}
