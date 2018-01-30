package baekjoon;

import java.util.Scanner;

public class Main{
	private static class Tet{
		private int m, n;
		private int[][] map;
		private int max;
		
		public Tet(){
			Scanner scn = new Scanner(System.in);
			m = scn.nextInt();
			n = scn.nextInt();
			map = new int[m][n];
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++)
					map[i][j] = scn.nextInt();
			}
			scn.close();
			max = 0;
		}
		public void switchFlag(){
			boolean[][] flag = new boolean[m][n];
			
			//first, find the max
			int max = 0;
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					if(map[i][j] > max)
						max = map[i][j];
					flag[i][j] = false;
				}
			}
			
			//set flags
			for(int k = max; k > 0; k--){
				for(int i = 0; i < m; i++){
					for(int j = 0; j < n; j++){
						if(map[i][j] == max)
							flag[i][j] = true;
					}
				}
				//check whether there are tetrominos
				if(findTetro(flag))
					break;
			}
			
			return;
		}
		private boolean findTetro(boolean[][] flag) {
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					if(flag[i][j])
				}
			}
			return false;
		}
		public int getMax(){
			return max;
		}
	}
	public static void main(String[] args){
		Tet solution = new Tet();
		solution.switchFlag();
		System.out.print(solution.getMax());
	}
}