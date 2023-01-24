package homework;

public class Proizv {
	static final double pi = 3.14;


	static int proizv(int a, int b, int c) {
			return a*b*c;
		}
	static void razn(int a, int b) {
			System.out.println((a/b)+"."+(a%b));
			System.out.println();
		}

	double S1(int r1) {
		double pl = pi*r1*r1;
		return pl;
	}
	static double S2(int r2) {
		double dl = 2*pi*r2;
		return dl;
	}

	void info(int r3) {	
		System.out.println("Radius kruga raven: " + r3);
		System.out.println("Ploshod kruga ravna: " + S1(r3));
		System.out.println("Dlinna okrujnosti: " + S2(r3));
		System.out.println();
	}

	}


	class ProizvTest {
		public static void main(String[] args) {
			
			System.out.println(Proizv.proizv(9, 5, 3));
			Proizv.razn(9, 4);
			
			Proizv s = new Proizv();
			s.info(7);
			

		}
	}