package homework;

public class SortShowArray {

	void showArray (String [][] ar1) {
		for (int i = 0; i<ar1.length; i++) {
			System.out.print("{");
			for (int j = 0; j<ar1[i].length; j++) {
				String ch;
				ch = ar1[i][j];
				System.out.print("{" + ch +" "+i+j +"}");
			}
			System.out.print("} ");
		}
	}

int [] sortirovka (int [] ar2) {
	
	int a;
	
	for (int j = 0; j<ar2.length; j++) {
		int min = ar2[j];
		int index = j;
		for (int i = j+1; i<ar2.length; i++) {
		if (min > ar2[i]) {
			min = ar2[i];
			index = i;
			}
		}
		if (j != index) {
			a = ar2[j];
			ar2[j] = min;
			ar2[index] = a;
		}
}
	return ar2;	
	}

}

class SortShowArrayTest {
	public static void main(String[] args) {

		SortShowArray ssa1= new SortShowArray();
		
		String [][] s1 = {{"privet", "vsem"},{"kak", "vashi", "dela"}, {"Horosho"}};
		
		int [] s5 = {9,-4,6,1,-12,0,-9,8,-34};
		
		ssa1.sortirovka(s5);
		
		ssa1.showArray(s1);
		
		System.out.println(); 
		System.out.println();
		
		for (int i = 0; i<s5.length; i++) {
			System.out.print(s5[i] + ",");
		
		}
		

	}
}
