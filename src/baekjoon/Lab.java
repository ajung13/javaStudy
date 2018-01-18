package baekjoon;

import java.util.Scanner;

public class Lab{
	private static class lab{
		private int m, n;
		private int[][] labMap;
		private int[][] tmp;
		private int emptyCnt;
		public lab(){
			//get inputs
			Scanner scn = new Scanner(System.in);
			this.m = scn.nextInt();
			this.n = scn.nextInt();
			labMap = new int[m][n];
			tmp = new int[m][n];
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					labMap[i][j] = scn.nextInt();
					if(labMap[i][j] == 0)
						emptyCnt++;
				}
			}
			scn.close();
		}
		
		public int solution(){
			//set an array that contains all empty space(0)
			empty[] emptySpace = new empty[emptyCnt];
			int idx = 0;
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					if(labMap[i][j] == 0){
						emptySpace[idx] = new empty();
						emptySpace[idx].x = i;
						emptySpace[idx].y = j;
						idx++;
					}
				}
			}
			
			int max = 0;
			for(int i = 0; i < emptyCnt-2; i++){
				for(int j = i+1; j < emptyCnt-1; j++){
					for(int k = j+1; k < emptyCnt; k++){
						int tmp = virus(i, j, k, emptySpace);
						if(tmp > max)
							max = tmp;
					}
				}
			}
			
			emptySpace = null;
			return max;
		}
		
		private int virus(int a, int b, int c, empty[] arr){
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++)
					tmp[i][j] = labMap[i][j];
			}
			tmp[arr[a].x][arr[a].y] = 1;
			tmp[arr[b].x][arr[b].y] = 1;
			tmp[arr[c].x][arr[c].y] = 1;
			
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++)
					if(tmp[i][j] == 2)
						spread_virus(i, j);
			}
			return safe_score();
		}
		
		private void spread_virus(int x, int y){
			if(tmp[x][y] == 1)	return;
			tmp[x][y] = 2;
			if(x != 0 && tmp[x-1][y] == 0)
				spread_virus(x-1, y);
			if(y != 0 && tmp[x][y-1] == 0)
				spread_virus(x, y-1);
			if(x != m-1 && tmp[x+1][y] == 0)
				spread_virus(x+1, y);
			if(y != n-1 && tmp[x][y+1] == 0)
				spread_virus(x, y+1);
		}
		
		private int safe_score(){
			int score = 0;
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					if(tmp[i][j] == 0)
						score++;
				}
			}
			return score;
		}
		
		private void printLab(){
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++)
					System.out.print(tmp[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
	}
	
	private static class empty{
		public int x, y;
		public empty(){
			x = 0;
			y = 0;
		}
	}
	
	public static void mainLab(String[] args){
		lab solution = new lab();
		System.out.print(solution.solution());
	}
	
}