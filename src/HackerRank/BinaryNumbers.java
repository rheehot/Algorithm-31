package src.HackerRank;

/*
 * https://www.hackerrank.com/challenges/30-binary-numbers/problem
 */

import java.util.*;
public class BinaryNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		String binary = getBinary(n);
		int result = getResult(binary);
		
		System.out.print(result);
	}
	
	public static String getBinary(int n) {
		
		String result = "";
		
		while(n > 0) {
			result += (n % 2);
			n /= 2;
		}
		
		return result;
	}
	
	public static int getResult(String binary) {
		int result = 0;
		
		String[] temp = binary.split("0");
		for(int i = 0; i < temp.length; i++) {
			if (temp[i].length() > result) {
				result = temp[i].length();
			}
		}
		
		return result;
	}

}
