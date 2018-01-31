package baekjoon;

import java.util.Scanner;

public class Main{
	private static class Tet{
		private int m, n;
		private int[][] map;
		private int max, inputmax;
		
		public Tet(){
			Scanner scn = new Scanner(System.in);
			m = scn.nextInt();
			n = scn.nextInt();
			map = new int[m][n];
			inputmax = 0;
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					map[i][j] = scn.nextInt();
					if(map[i][j] > inputmax)
						inputmax = map[i][j];
				}
			}
			scn.close();
			max = 0;
		}
		public int getMax(){
			return max;
		}
		
		public void find(){
			dfs(0, 0, 0, (byte)3, 0);
		}
		
		private void dfs(int i, int j, int depth, boolean straightFlag, byte beforeLocation, int sum){
			//if it's possible to make で, ぬ, た, っ shape, straightFlag is true
			//we use 'beforeLocation' to do better search
			//if the last location is on left, beforeLocation=1,
			//right: 2, top: 3, bottom: 4, first search: 0
			
			sum += map[i][j];
			
			if(depth == 4){
				//search finished
				if(sum > this.max)
					this.max = sum;
				return;
			}
			if(sum + inputmax * (4-depth) < this.max)
				return;
			
			if(j > 0 && beforeLocation != 1){
				//left search
				if(beforeLocation == 2 && straightFlag)
					dfs(i, j-1, depth+1, true, (byte)2, sum);
				else
					dfs(i, j-1, depth+1, false, (byte)2, sum);
			}
			if(j < n-1 && beforeLocation != 2){
				//right search
				if(beforeLocation == 1 && straightFlag)
					dfs(i, j+1, depth+1, true, (byte)1, sum);
				else
					dfs(i, j+1, depth+1, false, (byte)1, sum);
			}
			if(i > 0 && beforeLocation != 3){
				//top search
				if(beforeLocation == 4 && straightFlag)
					dfs(i-1, j, depth+1, true, (byte)4, sum);
				else
					dfs(i-1, j, depth+1, false, (byte)4, sum);
			}
			if(i < m-1 && beforeLocation != 4){
				//bottom search
				if(beforeLocation == 3 && straightFlag)
					dfs(i+1, j, depth+1, true, (byte)3, sum);
				else
					dfs(i+1, j, depth+1, false, (byte)3, sum);
			}
			
			if(depth == 3 && straightFlag){
				//consider the case of た, っ, で, ぬ
				
			}
			
			return;
		}
	}
	public static void main(String[] args){
		Tet solution = new Tet();
		solution.find();
		System.out.print(solution.getMax());
	}
}