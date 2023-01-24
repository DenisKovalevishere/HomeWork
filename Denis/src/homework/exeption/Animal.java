package homework.exeption;

public class Animal {
	public static void main(String[] args) {

		Tiger t = new Tiger();
		t.eat("myaso");
		try {
			t.drink("voda");
			try {
				t.drink("pivo");
			} catch (NeVodaException nv) {
				System.out.println(nv.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println("Eto inner finally block");
			}
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}

class NeMyasoEcxeption extends RuntimeException {
	NeMyasoEcxeption(String myaso) {
		super(myaso);
	}
}

class NeVodaException extends Exception {
	NeVodaException(String voda) {
		super(voda);
	}
}

class Tiger {
	void eat(String food) {
		if (!food.equals("myaso")) {
			throw new NeMyasoEcxeption("Tigr NE est " + food);
		}
		System.out.println("Tigr est myaso");
	}

	void drink(String dr) throws NeVodaException {
		if (!dr.equals("voda")) {
			throw new NeVodaException("Tigr NE pyet " + dr);
		}
		System.out.println("Tigr pyet vodu");
	}
}
