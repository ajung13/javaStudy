package baekjoon;
// Q9465: sticker

import java.util.Scanner;

public class Sticker{
	private static class mySticker{
		int n;
		int[][] sticker;
		public mySticker(Scanner scn){
			this.n = scn.nextInt();
			sticker = new int[2][n];
			for(int i = 0; i < 2; i++){
				for(int j = 0; j < n; j++)
					sticker[i][j] = scn.nextInt();
			}
		}
		public int get(){
			int[][] dp = new int[2][n];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			
			for(int i = 1; i < n; i++){
				if(i == 1){
					dp[0][i] = dp[1][i-1] + sticker[0][i];
					dp[1][i] = dp[0][i-1] + sticker[1][i];
				}
				else{
					dp[0][i] = Math.max(dp[1][i-1] + sticker[0][i], dp[0][i-2] + sticker[0][i]);
					dp[0][i] = Math.max(dp[0][i], dp[1][i-2] + sticker[0][i]);
					dp[1][i] = Math.max(dp[0][i-1] + sticker[1][i], dp[1][i-2] + sticker[1][i]);
					dp[1][i] = Math.max(dp[1][i], dp[0][i-2] + sticker[1][i]);
				}
//				System.out.println(i + "th max: " + dp[0][i] + ", " + dp[1][i]);
			}
			
			return Math.max(dp[0][n-1], dp[1][n-1]);
		}
	}
	public static void mainSticker(String[] args){
		Scanner scn = new Scanner(System.in);
		
		int testCase = scn.nextInt();
		while(testCase-- > 0){
			mySticker solution = new mySticker(scn);
			System.out.println(solution.get());
		}
		
		scn.close();
	}
}