package homework.oop;

public class Animal {

	int eyes;

	Animal() {
		System.out.println("I am animal");
	}

	void eat() {
		System.out.println("Animal eats");
	}

	void drink() {
		System.out.println("Animal drink");
	}

}

class Pet extends Animal {
	Pet() {
		System.out.println("I am pet");
		eyes = 2;
	}

	String name;
	final int tail = 1;
	final int paw = 4;

	void run() {
		System.out.println("Pet runs");
	}

	void jump() {
		System.out.println("Pet jumps");
	}
}

class Dog extends Pet {
	
	Dog(String name) {
		this.name = name;
		System.out.println("I am dog and my name is: " + name);
	}

	void play() {
		System.out.println("Dog plays");
	}
}

class Cat extends Pet {
	
	Cat(String name) {
		this.name = name;
		System.out.println("I am cat and my name is: " + name);
	}

	void sleep() {
		System.out.println("Cat sleeps");
	}
}

class Test {
	public static void main(String[] args) {
		Dog dog = new Dog("Kuzya");
		System.out.println(dog.paw);
		
		System.out.println();

		Cat cat = new Cat("Druzok");
		cat.sleep();
	}
}
