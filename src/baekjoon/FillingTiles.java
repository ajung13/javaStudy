package baekjoon;
// Q2133: Filling the tiles

import java.util.Scanner;

public class FillingTiles{
	public static void mainTile(String[] args){
		int n;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		scn.close();
		
		if(n % 2 == 1)
			System.out.print("0");
		else{
			n = n/2;
			int[] dp = new int[n+1];
			dp[0] = 1;
			dp[1] = 3;
			for(int i = 2; i <= n; i++){
//				dp[i] = (dp[i-1] * 3) + (dp[i-2] * 2);
				dp[i] = dp[i-1] * 3;
				for(int j = 2; j <= i; j++)
					dp[i] += dp[i-j] * 2;
			}
			System.out.print(dp[n]);
		}
	}
}