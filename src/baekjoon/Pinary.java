package baekjoon;
// Q2193: pinary number

import java.util.Scanner;

public class Pinary{
	public static void main(String[] args){
		int n;
		long[] pinary_ends_0, pinary_ends_1;
		
		//get input
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		scn.close();
		
		//initialize dp array
		pinary_ends_0 = new long[n+1];
		pinary_ends_1 = new long[n+1];
		pinary_ends_0[1] = 0;
		pinary_ends_1[1] = 1;
		
		for(int i = 2; i <= n; i++){
			pinary_ends_0[i] = pinary_ends_0[i-1] + pinary_ends_1[i-1];
			pinary_ends_1[i] = pinary_ends_0[i-1];
		}
		
		System.out.println(pinary_ends_0[n] + pinary_ends_1[n]);
	}
}