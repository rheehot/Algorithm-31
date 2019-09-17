
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int result = 1;
		
		for(int i = N; i > 0; i--) {
			result *= i;
		}
		
		System.out.println(result);
	}

}
