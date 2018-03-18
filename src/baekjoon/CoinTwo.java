package baekjoon;
// Q2294: CoinTwo

import java.util.Arrays;
import java.util.Scanner;

public class CoinTwo{
	public static void main(String[] args){
		int n, k;
		int[] coin;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		k = scn.nextInt();
		coin = new int[n];
		for(int i = 0; i < n; i++)
			coin[i] = scn.nextInt();
		scn.close();

		Arrays.sort(coin);
		
		int[] dp = new int[k+1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		for(int i = 1; i <= k; i++){
			//make i (i is money value) 
			for(int j = 0; j < n && coin[j] <= i; j++){
				//using j-th coin
				dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
			}
		}
		
		if(dp[k] > 10000)
			System.out.print("-1");
		else
			System.out.print(dp[k]);
	}
}