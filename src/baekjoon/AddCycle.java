package baekjoon;

import java.util.Scanner;

public class AddCycle{
	public static void mainCycle(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();		
		scn.close();
		
		int initN = n;
		int cycle = 0;
		while(cycle < 100){
			int last = n%10;
			int sum = 0;
			for(int i = 0; i < 2; i++){
				sum += n%10;
				n /= 10;
			}
			n = (last % 10) * 10 + (sum % 10);
			cycle++;
			if(initN == n)
				break;
		}
		
		System.out.print(cycle);
		return;
	}
}