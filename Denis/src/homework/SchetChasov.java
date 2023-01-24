package homework;

public class SchetChasov {
	
	

	static void Schet() {
		
		int ch = 0;
		
		OUTER:
			while(ch<6)	{
				int min = -1;				
				MIDDLE:
					do {
						min++;
						if (ch>1 && min % 10 ==0) {
							break OUTER;
						}
						int sec = 0;
							while (sec <60) {
								if (sec*ch>min) {
									continue MIDDLE;
								}
							System.out.println(ch + ":" + min + ":" + sec);
							sec++;
							}							
					} 
					while(min<59);
				ch++;
				}	
		}		
	
	public static void main(String[] args) {

		Schet();

	}
	
}
