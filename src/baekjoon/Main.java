package baekjoon;

import java.util.Scanner;

public class Main{
	private static long min;
	public static void main(String[] args){
		int n;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		scn.close();
		
		min = Integer.MAX_VALUE;
		dp(n, 0);
		
		System.out.print(min);
	}
	
	private static void dp(long left, int cnt){
		if(left == 1){
			if(cnt < min)
				min = cnt;
			return;
		}
		if(left < 1)
			return;
		
		if(left % 3 == 0)
			dp(left/3, cnt+1);
		if(left % 2 == 0)
			dp(left/2, cnt+1);
		dp(left-1, cnt+1);
	}
}