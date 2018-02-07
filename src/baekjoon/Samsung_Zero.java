package baekjoon;

import java.util.Scanner;

public class Samsung_Zero{
	private static class Map{
		private int m, n;
		private Position red, blue, hole;
		private int[][] map;
		private int minimum;
		public Map(){
			Scanner scn = new Scanner(System.in);
			m = scn.nextInt();
			n = scn.nextInt();
			scn.nextLine();
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
			dfs(0, red, blue);
			if(minimum > 10)
				System.out.print("-1");
			else
				System.out.print(minimum);
		}
		
		private void dfs(int depth, Position red, Position blue){
			Position initRed = red;
			Position initBlue = blue;
			
			System.out.println("depth: " + depth + " // red(" + red.i + ", " + red.j + 
					"), blue(" + blue.i + ", " + blue.j + ")");
			
			if(depth >= 10)
				return;
			if(red.i == hole.i && red.j == hole.j){
				if(depth < minimum)
					minimum = depth;
				return;
			}
			
			int idx;
			boolean leftflag;	//when it's true, there's a blue ball on that direction
			boolean holeflag;	//whether red/blue ball arrive
			
			//left
			if(canMove(red, blue, 0)){
				leftflag = false;
				holeflag = false;
				
				//move red ball
				for(idx = red.j; idx > 0; idx--){
					if(red.i == blue.i && blue.j == idx-1)
						leftflag = true;
					if(red.i == hole.i && idx == hole.j){
						holeflag = true;
						break;
					}
					if(map[red.i][idx-1] == 1)
						break;
				}
				red.j = idx;
				if(leftflag)	red.j++;
				
				//move blue ball
				for(idx = blue.j; idx > 0; idx--){
					if(blue.i == hole.i && idx == hole.j){
						break;
					}
					if(map[blue.i][idx-1] == 1)
						break;
				}
				blue.j = idx;
				if(red.i == blue.i && red.j == blue.j && !holeflag)
					blue.j++;
				
				//check the hole location
				if(blue.i != hole.i || blue.j != hole.j){
					dfs(depth+1, red, blue);
				}
			}
			
			//right
			red = initRed;
			blue = initBlue;
			if(canMove(red, blue, 1)){
				leftflag = false;
				holeflag = false;
				
				//move red ball
				for(idx = red.j; idx < n-1; idx++){
					if(red.i == blue.i && blue.j == idx+1)
						leftflag = true;
					if(red.i == hole.i && idx == hole.j){
						holeflag = true;
						break;
					}
					if(map[red.i][idx+1] == 1)
						break;
				}
				red.j = idx;
				if(leftflag)	red.j--;
				
				//move blue ball
				for(idx = blue.j; idx < n-1; idx++){
					if(blue.i == hole.i && idx == hole.j)
						break;
					if(map[blue.i][idx+1] == 1)
						break;
				}
				blue.j = idx;
				if(red.i == blue.i && red.j == blue.j && !holeflag)
					blue.j--;
				
				//check the hole location
				if(blue.i != hole.i || blue.j != hole.j){
					dfs(depth+1, red, blue);
				}
			}
			
			//top
			red = initRed;
			blue = initBlue;
			if(canMove(red, blue, 2)){
				leftflag = false;
				holeflag = false;
				
				//move red ball
				for(idx = red.i; idx > 0; idx--){
					if(idx-1 == blue.i && blue.j == red.j)
						leftflag = true;
					if(idx == hole.i && red.j == hole.j){
						holeflag = true;
						break;
					}
					if(map[idx-1][red.j] == 1)
						break;
				}
				red.i = idx;
				if(leftflag)	red.i++;
				
				//move blue ball
				for(idx = blue.i; idx > 0; idx--){
					if(idx == hole.i && blue.j == hole.j){
						break;
					}
					if(map[idx-1][blue.j] == 1)
						break;
				}
				blue.i = idx;
				if(red.i == blue.i && red.j == blue.j && !holeflag)
					blue.i++;
				
				//check the hole location
				if(blue.i != hole.i || blue.j != hole.j){
					dfs(depth+1, red, blue);
				}
			}
			
			//bottom
			red = initRed;
			blue = initBlue;
			if(canMove(red, blue, 3)){
				leftflag = false;
				holeflag = false;
				
				//move red ball
				for(idx = red.i; idx < m-1; idx++){
					if(idx+1 == blue.i && blue.j == red.j)
						leftflag = true;
					if(idx == hole.i && red.j == hole.j){
						holeflag = true;
						break;
					}
					if(map[idx+1][red.j] == 1)
						break;
				}
				red.i = idx;
				if(leftflag)	red.i--;
				
				//move blue ball
				for(idx = blue.i; idx < m-1; idx++){
					if(idx == hole.i && blue.j == hole.j)
						break;
					if(map[blue.i][idx+1] == 1)
						break;
				}
				blue.i = idx;
				if(red.i == blue.i && red.j == blue.j && !holeflag)
					blue.i--;
				
				//check the hole location
				if(blue.i != hole.i || blue.j != hole.j){
					dfs(depth+1, red, blue);
				}
			}
		}
		
		private boolean canMove(Position r, Position b, int direction){
			boolean flag = true;
			switch(direction){
			case 0:	//left
				if(map[r.i][r.j-1] == 1)	//there's a wall on left side
					flag = false;
				if(r.j-2 >= 0 && r.j-1 == b.j && r.i == b.i && map[r.i][r.j-2] == 1 )
					flag = false;			//the case of #BR
				break;
			case 1:	//right
				if(map[r.i][r.j+1] == 1)	//there's a wall on right side
					flag = false;
				if(r.j+2 < n && r.j+1 == b.j && r.i == b.i && map[r.i][r.j+2] == 1)
					flag = false;			//the case of RB#
				break;
			case 2:	//top
				if(map[r.i-1][r.j] == 1)
					flag = false;
				if(r.i-2 >= 0 && r.i-1 == b.i && r.j == b.j && map[r.i-2][r.j] == 1)
					flag = false;
				break;
			case 3:	//bottom
				if(map[r.i+1][r.j] == 1)
					flag = false;
				if(r.i+2 < m && r.i+1 == b.i && r.j == b.j && map[r.i+2][r.j] == 1)
					flag = false;
				break;
			}
			
			return flag;
		}
	}
	private static class Position{
		private int i, j;
	}
	public static void mainZero(String[] args){
		Map solution = new Map();
		solution.solve();
	}
}