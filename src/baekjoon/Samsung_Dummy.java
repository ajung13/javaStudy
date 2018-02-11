package baekjoon;
import java.util.Scanner;

public class Samsung_Dummy {
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
			int time = 0;
			int moveIdx = 0;
			
			for(; time < Integer.MAX_VALUE; time++){
				if(moveIdx < moving.length && moving[moveIdx][0] == time){
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
				if(myMap[mySnake.i][mySnake.j] != 1)
					//there's not an apple
					traceTail(moveIdx-1, time+1);
				myMap[mySnake.i][mySnake.j] = 2;
			}
			System.out.print(time+1);
		}
		
		//private method
		private void traceTail(int moveIdx, int time){
			int x = mySnake.i;
			int y = mySnake.j;
			int direction = mySnake.direction;
			int idx = moveIdx;
			
			for(int j = time; j >= 0; j--){
				if(x < 0 || x >= n || y < 0 || y >= n){
					System.out.println("Unexpected error");
					return;
				}
				if(idx >= 0 && moving[idx][0] == j){
					//change direction at that time
					if(moving[idx][1] == 1){
						//it WAS right
						direction = (direction + 1) % 4;
					}
					else
						direction = (direction + 3) % 4;
					idx--;
				}
				
				x -= (direction-2) % 2;
				y += (direction-1) % 2;
				
				if(x < 0 || y < 0 || x >= n || y >= n || myMap[x][y] != 2){
					x += (direction-2) % 2;
					y -= (direction-1) % 2;
					break;
				}
			}
			
			//delete tail!
			myMap[x][y] = 0;
		}
	}
	
	private static class snake{
		public int i, j;			// the head position of snake
		public int direction;		// 0: right 1: up 2: left 3: down
		public snake(){
			i = 0; j = 0;
			direction = 0;
		}
	}

	public static void mainDummy(String[] args) {
		Map solution = new Map();
		solution.startGame();
	}

}
