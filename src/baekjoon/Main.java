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
		public int getMax(){
			return max;
		}
		
		public void find(){
			dfs(0, 0, 0, (byte)3, 0);
		}
		
		private void dfs(int i, int j, int depth, byte straightFlag, int sum){
			//straightFlag:	0	-> impossible to make で shape
			//				1	-> possible to make で, ぬ shape
			//				2	-> possible to make た, っ shape
			//				3	-> possible to make で, ぬ, た, っ shape
			//straightFlag : all false -> it's impossible to make で shape
			//straightFlag[0] : true -> possible to make で, ぬ shape
			//straightFlag[1] : true -> possible to make た, っ shape
			
			sum += map[i][j];
			
			if(depth == 4){
				//search finished
				if(sum > this.max)
					this.max = sum;
				return;
			}
			
			if(i > 0){
				if(straightFlag % 2 == 1)
					dfs(i-1, j, depth+1, (byte)1, sum);
				else
					dfs(i-1, j, depth+1, (byte)0, sum);
			}
			if(i < n-1){
				if(straightFlag % 2 == 1)
					dfs(i+1, j, depth+1, (byte)1, sum);
				else
					dfs(i+1, j, depth+1, (byte)0, sum);
			}
			if(j > 0){
				if(straightFlag > 1)
					dfs()
			}
				
			
			if(depth == 3){
				
			}
			
			dfs()
		}
	}
	public static void main(String[] args){
		Tet solution = new Tet();
		solution.find();
		System.out.print(solution.getMax());
	}
}