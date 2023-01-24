package homework;

public class MethodABC {

	static String[] abc(String []... ar1) {
		int length = 0;
		for (String [] ar2 :ar1) {
			length += ar2.length;
		}
		
		String [] target = new String [length];
		int count = 0;
		for (String[] ar2:ar1) {
			for (String s :ar2) {
				target[count] = s;
				count++;
			}
		}
		return target;
	}
	
	public static void main(String[] args) {
		
		String[] target = abc (new String[] {"ok", "Privet", "poka"}, new String[] {"ok", "hello", "bye"});
		
		for (String s: args) {
			for (int i = 0; i<target.length; i++) {
				if (s.equals(target[i])) {
					target[i] = null;
				}
			}
		}
		for (String s: target) {
			System.out.print(s+ " ");
		}
		System.out.println();
	}
}
