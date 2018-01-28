package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Samsung_Resignment{
	private static class Resign{
		private int n;
		private int[] T, P;
		private int profit;
		private int[] maxProb;
		public Resign(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			T = new int[n];
			P = new int[n];
			for(int i = 0; i < n; i++){
				T[i] = scn.nextInt();
				P[i] = scn.nextInt();
				if(T[i] + i > n)
					P[i] = 0;
			}
			scn.close();
			profit = 0;
		}
		public void solve() {
			//we use 'maxProb' array
			maxProb = new int[n];
			Arrays.fill(maxProb, 0);
			for(int i = n-1; i >= 0; i--){
				if(T[i] + i < n+1){
					if(i != n-1)
						maxProb[i] = maxProb[i+1] + P[i];
					else
						maxProb[i] = P[i];
				}
				else if(i != n-1)
					maxProb[i] = maxProb[i+1];
			}
			counsel(0, 0);
		}
		
		private void counsel(int idx, int price){
			if(idx >= n){
				if(price > profit)
					profit = price;
				return;
			}
			if(price + maxProb[idx] < profit)
				return;
			
			//when counseling today(idx day)
			if(idx+T[idx] <= n)
				counsel(idx+T[idx], price + P[idx]);
			//when not counseling today
			counsel(idx+1, price);
			
			return;
		}
		
		public int getProfit() {
			return profit;
		}
	}
	public static void mainResign(String[] args){
		Resign solution = new Resign();
		solution.solve();
		System.out.print(solution.getProfit());
	}
}