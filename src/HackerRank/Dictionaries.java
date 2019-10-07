package HackerRank;

/*
 * https://www.hackerrank.com/challenges/30-dictionaries-and-maps/problem?h_r=next-challenge&h_v=zen
 */

import java.util.*;
public class Dictionaries {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		scan.nextLine();
		Map<String, String> phoneBook = new HashMap<String, String>(); 
		
		String test = "";
		
		for(int i = 0; i < n; i++) {
			test = scan.nextLine();
			String[] words = test.split(" ");
			
			phoneBook.put(words[0], words[1]);
		}
		
		String name = "";
		
		while(scan.hasNext()) {
			name = scan.nextLine();
			if (phoneBook.get(name) == null) {
				System.out.println("Not found");
			}
			else {
				System.out.println(name + "=" + phoneBook.get(name));
			}
		}

	}

}
