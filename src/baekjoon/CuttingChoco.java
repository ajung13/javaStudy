package baekjoon;
// Q2163: cutting chocolate

import java.util.Scanner;

public class CuttingChoco{
	public static void mainChoco(String[] args){
		int n, m;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		m = scn.nextInt();
		scn.close();
		
		System.out.print((m-1) + (n-1)*m);
	}
}