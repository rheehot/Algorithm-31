/*
 * https://www.hackerrank.com/challenges/30-arrays/problem
 */

import java.util.*;
public class Array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int A = scan.nextInt();
		int[] array = new int[A];
		
		for (int i = 0; i < A; i++) {
			array[i] = scan.nextInt();
		}
		
		for (int i = A - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
	}

}
