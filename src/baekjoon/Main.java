package baekjoon;
import java.util.Scanner;

public class Main {
	private static class Map{
		private int n;
		private int[][] myMap;
		private Snake mySnake;
		private int[][] moving;
		public Map(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			mySnake = new Snake(n);
			n = 2*n+1;
			myMap = new int[n][n];
			myMap[(n-1)/2][(n-1)/2] = 2;
			
			int tmp = scn.nextInt();
			moving = new int[tmp][2];
			for(int i = 0; i < tmp; i++){
				if(i == 0)
					moving[i][0] = scn.nextInt();
				else
					moving[i][0] = scn.nextInt() + moving[i-1][0];
				moving[i][1] = (scn.next().charAt(0) == 'L')? 0:1;
				//0: left, 1: right
			}
			scn.close();
		}
		
		public void startMoving(){
			int time = 0;
			int moveIdx = 0;
			
			for(; time < Integer.MAX_VALUE; time++){
				printMap();
				if(moveIdx < moving.length && moving[moveIdx][0] == time){
					//time to change direction
					if(moving[moveIdx][1] == 0)
						mySnake.direction = (mySnake.direction + 1)%4;
					else
						mySnake.direction = (mySnake.direction + 3)%4;
					moveIdx++;
				}
				
				//move snake
				mySnake.i += (mySnake.direction-2)%2;
				mySnake.j -= (mySnake.direction-1)%2;
				
				//game over check
				if(mySnake.i < 0 || mySnake.i >= n || mySnake.j < 0 || mySnake.j >= n)
					break;
				if(myMap[mySnake.i][mySnake.j] == 2)
					break;
				
				myMap[mySnake.i][mySnake.j] = 2;
			}
			
			System.out.print(time+1);
		}
		
		private void printMap(){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++)
					System.out.print(myMap[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
	}
	
	private static class Snake{
		public int i, j;
		public int direction;
		public Snake(int l){
			i = l;	j = l;
			direction = 0;
		}
	}

	public static void main(String[] args) {
		Map solution = new Map();
		solution.startMoving();
	}

}
