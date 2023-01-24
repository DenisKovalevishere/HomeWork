package homework.oop.abstractniy;

abstract class Animal {
	String name;

	Animal(String name) {
		this.name = name;
	}

	abstract void sleep();

	abstract void eat();
}

abstract class Fish extends Animal {
	Fish(String name) {
		super(name);
	}

	public void sleep() {
		System.out.println("Vsegda interesno nablydat, kak spyat ribi");
	}

	abstract void swim();
}

abstract class Bird extends Animal implements Speakable {

	Bird(String name) {
		super(name);
	}

	public void speak() {
		System.out.println(name + "sings");
	}

	abstract void fly();
}

abstract class Mammal extends Animal implements Speakable {

	Mammal(String name) {
		super(name);
	}

	abstract void run();
}

interface Speakable {
	default void speak() {
		System.out.println("Somebody speaks");
	}
}

class Mechenosec extends Fish {

	Mechenosec(String name) {
		super(name);
	}

	@Override
	void swim() {
		System.out.println("Mechenosec krasivaya riba, kotoraya bistro plavaet!");
	}

	@Override
	void eat() {
		System.out.println("Mechenosec ne xishnaya riba, i ona est obichno ribiy korm!");
	}
}

class Pingvin extends Bird {

	Pingvin(String name) {
		super(name);
	}

	@Override
	void fly() {
		System.out.println("Pingvini ne umeyut letat!");
	}

	@Override
	void sleep() {
		System.out.println("Pingvini spyat prijavshis dryg k drugu!");
	}

	@Override
	void eat() {
		System.out.println("Pingvin lyubit est ribu!");
	}

	public void speak() {
		System.out.println("Pingvini ne umeyut pet kak solovyi");
	}
}

class Lev extends Mammal {

	Lev(String name) {
		super(name);
	}

	@Override
	void run() {
		System.out.println("Lev-eto ne samaya bistraya kpshka!");
	}

	@Override
	void sleep() {
		System.out.println("Bolshuyu chast dnya lev spit!");
	}

	@Override
	void eat() {
		System.out.println("Lev kak lyuboy xishnik, lubit myaso!");
	}

}

class Main {
	public static void main(String[] args) {
		
		Animal a1 = new Mechenosec("Masha");
		Animal a2 = new Pingvin("Vanya");
		Animal a3 = new Lev("Gosha");
		Fish f1 = new Mechenosec("Roma");
		Bird b1 = new Pingvin("Yasha");
		Mammal m1 = new Lev("Yasha");
		Mechenosec m2 = new Mechenosec("Petya");
		Pingvin p1 = new Pingvin("Maks");
		Lev l1 = new Lev("Misha");		
		Speakable s1 = new Lev("Denis");
		Speakable s2 = new Pingvin("Dima");
		
		Animal[] array = {a1,a2,a3,f1,b1,m1,m2,p1,l1};
		Speakable[] array1 = {s1,s2,b1,m1,p1,l1};
		
		for(Animal ar:array) {
			if(ar instanceof Mechenosec) {
				Mechenosec m = (Mechenosec) ar;
				System.out.println(m.name);
				m.eat();
				m.sleep();
				m.swim();
				System.out.println();
			}
			else if(ar instanceof Pingvin) {
				Pingvin p = (Pingvin) ar;
				System.out.println(p.name);
				p.eat();
				p.fly();
				p.sleep();
				p.speak();
				System.out.println();
			}
			else if(ar instanceof Lev) {
				Lev l = (Lev) ar;
				System.out.println(l.name);
				l.eat();
				l.sleep();
				l.speak();
				l.run();
				System.out.println();
		}
		
	}
		System.out.println("-------------------------------------");
		for (Speakable s:array1) {
			if(s instanceof Lev) {
				Lev l = (Lev) s;
				System.out.println(l.name);
				l.eat();
				l.sleep();
				l.speak();
				l.run();
				System.out.println();
		}
			else if(s instanceof Pingvin) {
				Pingvin p = (Pingvin) s;
				System.out.println(p.name);
				p.eat();
				p.fly();
				p.sleep();
				p.speak();
				System.out.println();
			}
		}

}
}
