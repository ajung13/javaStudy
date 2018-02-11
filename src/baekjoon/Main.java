package baekjoon;
import java.util.Scanner;

public class Main {
	private static class Map{
		//class member variable
		private int n;
		private int[][] myMap;			// 0: empty 1: apple 2: snake
		private snake mySnake;
		private int[][] moving;			// the direction of snake
		
		//public method and constructor
		public Map(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			myMap = new int[n][n];
			
			int inputCase = scn.nextInt();
			for(int i = 0; i < inputCase; i++)
				myMap[scn.nextInt()-1][scn.nextInt()-1] = 1;
			myMap[0][0] = 2;
			
			inputCase = scn.nextInt();
			moving = new int[inputCase][2];	//moving[][1]=0: left 1: right
			for(int i = 0; i < inputCase; i++){
				moving[i][0] = scn.nextInt();
				moving[i][1] = (scn.next().charAt(0) == 'D')? 1:0;
			}
			scn.close();
			
			mySnake = new snake();
		}
		public void startGame(){
			int time = 1;
			int moveIdx = 0;
			
			for(; time < Integer.MAX_VALUE; time++){
				printMap();
				if(moving[moveIdx][0] == time){
					//time to change direction
					if(moving[moveIdx][1] == 0){
						//move left
						mySnake.direction = (mySnake.direction + 1)%4;
					}
					else{
						//move right
						mySnake.direction = (mySnake.direction + 3)%4;
					}
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
				
				//change the location
				if(myMap[mySnake.i][mySnake.j] == 1){
					//there's an apple
					myMap[mySnake.i][mySnake.j] = 2;
				}
				else{
					myMap[mySnake.i][mySnake.j] = 2;
					traceTail();
				}
			}
			System.out.print(time);
		}
		
		//private methods
		private void printMap(){
			System.out.println("snake: " + mySnake.i + ", " + mySnake.j);
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++)
					System.out.print(myMap[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
	}
	
	private static class snake{
		public int i, j;			// the head position of snake
		public int tail_i, tail_j;	// the tail position of snake
		public int direction;		// 0: right 1: up 2: left 3: down
		public snake(){
			i = 0; j = 0;
			direction = 0;
			tail_i = 0; tail_j = 0;
		}
	}

	public static void main(String[] args) {
		Map solution = new Map();
		solution.startGame();
	}

}
