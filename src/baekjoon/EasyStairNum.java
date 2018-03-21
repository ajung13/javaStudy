package baekjoon;
// Q10844: Easy stairNum

import java.util.Arrays;
import java.util.Scanner;

public class EasyStairNum{
	public static void main(String[] args){
		int n;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		scn.close();
		
		long[][] dp = new long[2][10];
		for(int i = 1; i < 10; i++)
			dp[0][i] = 1;
		
		for(int i = 2; i <= n; i++){
			for(int j = 0; j < 10; j++){
				dp[1][j] = 0;
				if(j != 0)
					dp[1][j] += dp[0][j-1];
				if(j != 9)
					dp[1][j] += dp[0][j+1];
				dp[1][j] %= 1000000000;
			}
			dp[0] = Arrays.copyOf(dp[1], 10);
		}
		
		//get sum
		long sum = 0;
		for(int i = 0; i < 10; i++)
			sum += dp[0][i];
		sum %= 1000000000;
		System.out.print(sum);
	}
}