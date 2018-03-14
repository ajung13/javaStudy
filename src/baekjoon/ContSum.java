package baekjoon;
//Q1912: Sum of continual number

import java.util.Scanner;

public class ContSum {
	public static void mainSum(String[] args){
		int n;
		int[] num_arr;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		num_arr = new int[n];
		for(int i = 0; i < n; i++)
			num_arr[i] = scn.nextInt();
		scn.close();
		
		int[] dp = new int[n+1];
		dp[1] = num_arr[0];
		for(int i = 2; i <= n; i++){
			dp[i] = Math.max(num_arr[i-1], dp[i-1] + num_arr[i-1]);
		}
		
		int max = dp[1];
		for(int i = 2; i <= n; i++)
			max = Math.max(max, dp[i]);
		
		System.out.print(max);
	}
}
