package baekjoon;

import java.util.Scanner;

public class Samsung_Soccer{
	private static class Soccer{
		private int[][] input;
		private int n;
		private int min;
		public Soccer(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			input = new int[n][n];
			for(int i = 0; i < n * n; i++)
				input[i/n][i%n] = scn.nextInt();
			scn.close();
			
			min = Integer.MAX_VALUE;
		}
		public int getMin() {
			return min;
		}
		public void findMin() {
			int[] team = new int[n/2];
			team[0] = 0;
			combination(team, 1);
			team = null;
		}
		
		private int diff(int[] team){
			int start = 0, link = 0;
			int[] nonteam = new int[n/2];
			
			int idx1 = 0, idx2 = 0;
			for(int i = 0; i < n; i++){
				if(idx2 >= n/2 || team[idx2] != i){
					nonteam[idx1] = i;
					idx1++;
				}
				else{
					idx2++;
				}
			}
			
			for(int i = 0; i < n/2; i++){
				for(int j = i+1; j < n/2; j++){
					start += input[team[i]][team[j]];
					start += input[team[j]][team[i]];
					link += input[nonteam[i]][nonteam[j]];
					link += input[nonteam[j]][nonteam[i]];
				}
			}
			return Math.abs(start-link);
		}
		
		private void combination(int[] team, int idx){
			if(idx >= n/2){
				int tmp = diff(team);
				if(tmp < min)
					min = tmp;
				return;
			}
			
			int i;
			if(idx != 0)
				i = team[idx-1] + 1;
			else
				i = 0;
			for(; i < n; i++){
				team[idx] = i;
				combination(team, idx+1);
			}
		}
	}
	public static void mainSoccer(String[] args){
		Soccer solution = new Soccer();
		solution.findMin();
		System.out.println(solution.getMin());
	}

}