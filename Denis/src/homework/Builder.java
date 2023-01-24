package homework;

public class Builder {

	static boolean ravenstvo(StringBuilder sb1, StringBuilder sb2) {
		boolean res = true;
		
		if (sb1.length() == sb2.length()) {
			for (int i = 0; i<sb1.length(); i++) {
				if (sb1.charAt(i) != sb2.charAt(i)) {
					res = false;
					if (sb1.charAt(i) != sb2.charAt(i)) {
						System.out.print(sb1.charAt(i));
			
						System.out.println(sb2.charAt(i));
					}
					
					continue;
				}
			}
			
		} else {
			res = false;
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {

		StringBuilder sb1 = new StringBuilder("Privet");
		StringBuilder sb2 = new StringBuilder("rtivru");
		
		System.out.println(ravenstvo(sb1, sb2));

		

	}
	
	
}
