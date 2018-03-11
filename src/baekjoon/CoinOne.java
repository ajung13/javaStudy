package baekjoon;

import java.util.Scanner;

public class CoinOne{
	public static void mainCoin1(String[] args){
		int n, value;
		int[] coin;
		int[] dp;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		value = scn.nextInt();
		coin = new int[n];
		dp = new int[value+1];
		for(int i = 0; i < n; i++)
			coin[i] = scn.nextInt();
		scn.close();
		
		dp[0] = 1;
		for(int i = 0; i < n; i++){
			for(int j = coin[i]; j <= value; j++)
				dp[j] += dp[j-coin[i]];
		}
		
		System.out.print(dp[value]);
	}
}