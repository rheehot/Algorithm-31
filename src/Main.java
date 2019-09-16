
import java.util.*;
public class Main {

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
		
		/*
		for(int i = 0; i < n; i++) {
			
			name = scan.nextLine();
			if (phoneBook.get(name) == null) {
				System.out.println("Not found");
			}
			else {
				System.out.println(name + "=" + phoneBook.get(name));
			}
		}
		*/
	}

}
