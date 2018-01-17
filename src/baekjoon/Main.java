package baekjoon;

import java.util.Scanner;

public class Main{
	private static class lab{
		private int m, n;
		private int[][] labMap;
		public lab(){
			//get inputs
			Scanner scn = new Scanner(System.in);
			this.m = scn.nextInt();
			this.n = scn.nextInt();
			labMap = new int[m][n];
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++)
					labMap[i][j] = scn.nextInt();
			}
			scn.close();
		}
		
		private void virus(){
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++)
					if(labMap[i][j] == 2)
						spread_virus(i, j);
			}
		}
		
		private void spread_virus(int x, int y){
			if(labMap[x][y] == 1)	return;
			labMap[x][y] = 2;
			if(x != 0 && labMap[x-1][y] == 0)
				spread_virus(x-1, y);
			if(y != 0 && labMap[x][y-1] == 0)
				spread_virus(x, y-1);
			if(x != m-1 && labMap[x+1][y] == 0)
				spread_virus(x+1, y);
			if(y != n-1 && labMap[x][y+1] == 0)
				spread_virus(x, y+1);
		}
		
		private int safe_score(){
			int score = 0;
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					if(labMap[i][j] == 0)
						score++;
				}
			}
			return score;
		}
		
		private void printLab(){
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++)
					System.out.print(labMap[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		lab solution = new lab();
		
		System.out.println("Before");
		solution.printLab();
		
		solution.virus();
		
		System.out.println("After");
		solution.printLab();
		
		System.out.print(solution.safe_score());
	}
	
}