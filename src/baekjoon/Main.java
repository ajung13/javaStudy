package baekjoon;

import java.util.Scanner;

public class Main{
	private static class Map{
		private int m, n;
		private Position red, blue, hole;
		private int[][] map;
		private int minimum;
		public Map(){
			Scanner scn = new Scanner(System.in);
			m = scn.nextInt();
			n = scn.nextInt();
			map = new int[m][n];
			red = new Position();
			blue = new Position();
			hole = new Position();
			
			String input = "";
			for(int i = 0; i < m; i++){
				input = scn.nextLine();
				for(int j = 0; j < n; j++){
					if(input.charAt(j) == '#')
						map[i][j] = 1;
					else if(input.charAt(j) == 'O'){
						hole.i = i;	hole.j = j;
					}
					else if(input.charAt(j) == 'R'){
						red.i = i;	red.j = j;
					}
					else if(input.charAt(j) == 'B'){
						blue.i = i;	blue.j = j;
					}
				}
			}
			scn.close();
			minimum = Integer.MAX_VALUE;
		}
		
		public void solve(){
			dfs(0, red, blue, hole);
		}
		
		private void dfs(int depth, Position red, Position blue, Position hole){
			Position initRed, initBlue;
			if(depth >= 10)
				return;
			
			//left
			if()
			dfs(depth+1, )
			//right
			
			//
		}
		
		private boolean canMove(Position r, Position b, int direction){
			boolean flag = true;
			switch(direction){
			case 0:	//left
				if(map[r.i][r.j-1] == 1)	//there's a wall on left side
					flag = false;
				if(map[r.i][r.j-1] )
			}
			return flag;
		}
	}
	private static class Position{
		private int i, j;
	}
	public static void main(String[] args){
		Map solution = new Map();
		solution.solve();
	}
}