package homework.oop;

public class Student {
	private StringBuilder name;
	private int course;
	private int grade;

	public StringBuilder getName() {
		StringBuilder name2 = new StringBuilder(name);
		return name2;
	}

	public void setall(StringBuilder name, int course, int grade) {
		if (name.length() > 3) {
			this.name = name;
		}
		if (course > 1 && course < 4) {
			this.course = course;
		}

		if (grade > 1 && grade <= 10) {
			this.grade = grade;
		}
	}

	public void showInfo() {
		System.out.println("Imya studenta: " + name);
		System.out.println("Imya kurs: " + course);
		System.out.println("Imya ocenka: " + grade);
	}

}

class StudentTest {
	public static void main(String[] args) {
		Student st1 = new Student();
		st1.setall(new StringBuilder("Ivan"), 3, 7);
		st1.showInfo();
	}
}
