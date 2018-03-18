package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class LongestArray{
	public static void main(String[] args){
		int n;
		int[] arr;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		scn.close();
		
		int[] dp = new int[n];
//		dp[0] = 1;		why?????????????T_T
		Arrays.fill(dp,  1);
		int max = 1;
		
		for(int i = 1; i < n; i++){
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			if(max < dp[i])
				max = dp[i];
		}
		
		System.out.print(max);
		
	}
}