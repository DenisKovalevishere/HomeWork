package homework;

public class Mail {
	
	static String s1 = "ya@yahoo.com; on@mail.ru; ona@gmail.com;";

  public static void email (String mail) {
	int a = 0; 
	int b = 0;
	int c = 0;
	while (c < mail.length() - 1) {
		
		a = mail.indexOf('@', c);
		b = mail.indexOf('.', c );
		c = mail.indexOf(';', c + 1);
		System.out.println(mail.substring(a + 1, b));
	}
		
}
	
  public static void main(String[] args) {

	email(Mail.s1);

}
  
  
  
  }








