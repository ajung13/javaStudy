package baekjoon;
import java.util.Scanner;

public class Main {
	private static class Map{
		//class member variable
		private int n;
		private int[][] myMap;			// 0: empty 1: apple
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
			
			inputCase = scn.nextInt();
			moving = new int[inputCase][2];	//moving[][1]=0: left 1: right
			for(int i = 0; i < inputCase; i++){
				moving[i][0] = scn.nextInt();
				moving[i][1] = (scn.next().charAt(0) == 'D')? 1:0;
			}
			scn.close();
		}
		public void startGame(){
			for(int time = 0; time < Integer.MAX_VALUE; time++){
				
			}
		}
	}
	
	private static class snake{
		public int i, j;
		public snake(){
			i = 0; j = 0;
		}
	}

	public static void main(String[] args) {
		Map solution = new Map();
		solution.startGame();
	}

}
