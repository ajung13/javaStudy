package baekjoon;
// Q9461: Wave

import java.util.Scanner;

public class WaveProgression{
	private static long[] dp;
	public static void mainWave(String[] args){
		Scanner scn = new Scanner(System.in);
		dp = new long[101];
		dp[1] = 1;	dp[2] = 1;	dp[3] = 1;
		dp[4] = 2; 	dp[5] = 2;
		
		int testcase = scn.nextInt();
		while(testcase-- > 0){
			int n = scn.nextInt();
			System.out.println(getP(n));
		}
		
		scn.close();
	}
	
	private static long getP(int n){
		if(dp[n] != 0)
			return dp[n];
		
		for(int i = 6; i <= n; i++)
			dp[i] = dp[i-1] + dp[i-5];
		
		return dp[n];
	}
}