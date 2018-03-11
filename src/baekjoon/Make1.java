package baekjoon;
// Q1463: make One

import java.util.Scanner;

public class Make1{
	public static void mainOne(String[] args){
		int n;
		int[] dp;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		scn.close();
		
		dp = new int[n+1];
		dp[1] = 0;
		for(int i = 2; i <= n; i++){
			dp[i] = Integer.MAX_VALUE;
			if(i % 3 == 0)
				dp[i] = dp[i/3] + 1;
			if(i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			dp[i] = Math.min(dp[i], dp[i-1] + 1);
		}
		
		System.out.print(dp[n]);
	}
}