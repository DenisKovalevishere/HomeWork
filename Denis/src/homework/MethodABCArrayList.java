package homework;

import java.util.*;

public class MethodABCArrayList {

	public ArrayList<String> abc(String... s) {
		ArrayList<String> aL = new ArrayList<>();
		for (String s1 : s) {
			if (!aL.contains(s1)) {
				aL.add(s1);
			}
		}
		aL.sort(null);
		System.out.println(aL);

		return aL;
	}

	public static void main(String[] args) {

		MethodABCArrayList mABCAL = new MethodABCArrayList();
		mABCAL.abc("privet", "ok", "poka", "privet", "kak dela?", "ok", "hello");
		

	}

}
