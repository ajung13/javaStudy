package baekjoon;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
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
		int digit;
//		while(true){
			digit = (int)Math.log10(n)+1;
			
			System.out.println(digit);
//		}
		return false;
	}
}