package homework;

public class Month {
	
	
	
	static void MonthInfo (int mn) {
		
		String a = "V etom mesyace: ";
		String b = " dney.";		
		 
		switch (mn) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(a + 31 + b);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(a + 30 + b);
			break;
		case 2:
			System.out.println(a + 28 + b);
			break;
		default: System.out.println("Takogo mesyaca NET");
				
		}
	}
	
	public static void main(String[] args) {
	
		MonthInfo(4);
		
	}

}
