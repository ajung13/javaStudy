package baekjoon;
// Q2156: testing wine

import java.util.Scanner;

public class TestingWine{
	public static void mainWine(String[] args){
		int wineNum;
		int[] wine;
		
		Scanner scn = new Scanner(System.in);
		wineNum = scn.nextInt();
		wine = new int[wineNum];
		for(int i = 0; i < wineNum; i++)
			wine[i] = scn.nextInt();
		scn.close();
		
		int[] dp = new int[wineNum+1];
		dp[1] = wine[0];
		for(int i = 2; i <= wineNum; i++){
			// not eating i-th wine
			dp[i] = dp[i-1];
			// not eating i-1 th wine and eat i-th wine
			dp[i] = Math.max(dp[i], dp[i-2] + wine[i-1]);
			// eat i, i-1 th wine
			if(i > 2)
				dp[i] = Math.max(dp[i], dp[i-3] + wine[i-1] + wine[i-2]);
			else
				dp[i] = Math.max(dp[i], wine[i-1] + wine[i-2]);
		}
		
		System.out.print(dp[wineNum]);
	}
}