package baekjoon;

import java.util.Scanner;

public class Main{
	private static class coinOne{
		private int n, value;
		private int[] coin;
		private int total;
		public coinOne(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			value = scn.nextInt();
			coin = new int[n];
			for(int i = 0; i < n; i++)
				coin[i] = scn.nextInt();
			scn.close();
			total = 0;
		}
		public int run(){
			dp(0, value);
			return total;
		}
		
		private void dp(int i, int left){
			//ith coin is used?
			if(left == 0){
				total++;
				return;
			}
			if(left < 0){
				return;
			}
			if(i == n-1){
				if(left % coin[i] == 0){
					total++;
				}
				return;
			}
			
			int max = (int)(left/coin[i]);
			for(int idx = 0; idx <= max; idx++){
				dp(i+1, left-coin[i]*idx);
			}
		}
	}
	public static void main(String[] args){
		coinOne solution = new coinOne();
		System.out.print(solution.run());
	}
}