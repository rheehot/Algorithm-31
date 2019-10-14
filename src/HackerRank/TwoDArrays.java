package src.HackerRank;

/*
 * https://www.hackerrank.com/challenges/30-2d-arrays/problem
 */

import java.util.*;
public class TwoDArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] A = new int[6][6];
		
		for(int a = 0; a < 6; a++) {
			for(int b = 0; b < 6; b++) {
				A[a][b] = scan.nextInt();
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int a = 0; a < 4; a++) {
			for(int b = 0; b < 4; b++) {
				int temp = 0;
				temp += A[a][b];
				temp += A[a][b + 1];
				temp += A[a][b + 2];
				temp += A[a + 1][b + 1];
				temp += A[a + 2][b];
				temp += A[a + 2][b + 1];
				temp += A[a + 2][b + 2];
				
				if(temp > max) {
					max = temp;
				}
			}
 		}
		
		System.out.print(max);
	}

}
