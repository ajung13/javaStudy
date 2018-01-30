package baekjoon;

import java.util.Scanner;

public class FA{
	public static void mainFA(String[] args){
		int num;
		
		Scanner scn = new Scanner(System.in);
		num = scn.nextInt();
		scn.close();
		
		if(check(num))
			System.out.print("FA");
		else
			System.out.print("NFA");
	}
	
	private static boolean check(int n){
		int digit, prev, next;
		prev = n;
		for(int i = 0; i < 100; i++){
			digit = (int)Math.log10(prev);
			next = (int) ((prev / Math.pow(10, digit)) * (digit+1));
			if(next == prev)
				return true;
//			System.out.println(next);
			prev = next;
		}
		return false;
	}
}