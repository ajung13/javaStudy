package baekjoon;

import java.util.Scanner;

public class Main{
	private static class Resign{
		private int n;
		private int[] T, P;
		private int profit;
		public Resign(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			T = new int[n];
			P = new int[n];
			for(int i = 0; i < n; i++){
				T[i] = scn.nextInt();
				P[i] = scn.nextInt();
			}
			scn.close();
			profit = 0;
		}
		public void solve() {
			// TODO Auto-generated method stub
			
		}
		public int getProfit() {
			return profit;
		}
	}
	public static void main(String[] args){
		Resign solution = new Resign();
		solution.solve();
		System.out.print(solution.getProfit());
	}
}