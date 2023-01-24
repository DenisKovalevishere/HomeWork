package homework;

public class BankAccount {
	int id = 10;
	String name = "Petr";
	double balance = 100;

	void popolnenieScheta(double bl1) {
		balance += bl1;
		System.out.println("Balans popolnen na summu: " + bl1 + ".");
		System.out.println("Balans raven: " + balance + ".");
	}

	void snytieSoScheta(double bl2) {
		balance -= bl2;
		System.out.println("Balans umenshen na summu: " + bl2 + ".");
		System.out.println("Balans raven: " + balance + ".");
	}
}

class BankAccountTest {
	public static void main(String[] args) {
		BankAccount ba1 = new BankAccount();
		System.out.println("ID: " + ba1.id);
		System.out.println("Name: " + ba1.name);
		System.out.println("Balance: " + ba1.balance);
		System.out.println();

		ba1.popolnenieScheta(23.86);
		System.out.println();
		ba1.snytieSoScheta(74.96);

	}
}
