package baekjoon;
// Q11726 tiling

import java.util.Scanner;

public class Tiling21{
	public static void mainTile(String[] args){
		int n;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		scn.close();
		
		long[] dp = new long[n+1];
		dp[0] = 1;	dp[1] = 1;
		for(int i = 2; i <= n; i++){
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 10007;
		}
		
		System.out.print(dp[n]%10007);
	}
}