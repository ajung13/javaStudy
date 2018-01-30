package baekjoon;

import java.util.Scanner;

public class Samsung_Dice{
	private static class dice_on_map{
		private dice myDice;
		private map myMap;
		
		public void run(){
			Scanner scn = new Scanner(System.in);
			int m = scn.nextInt();
			int n = scn.nextInt();
			myDice = new dice();
			myDice.x = scn.nextInt();
			myDice.y = scn.nextInt();
			int k = scn.nextInt();
			myMap = new map(scn, m, n);
			for(int i = 0; i < k; i++){
				move(scn.nextInt());
			}
			scn.close();
		}
		
		private void move(int direction){
			//change the location of the dice
			boolean outFlag = false;
			
			switch(direction){
			case 1:
				if(myDice.y >= myMap.n-1)
					outFlag = true;
				else
					myDice.y++;	break;
			case 2:
				if(myDice.y <= 0)
					outFlag = true;
				else
					myDice.y--;	break;
			case 3:
				if(myDice.x <= 0)
					outFlag = true;
				else
					myDice.x--;	break;
			case 4:
				if(myDice.x >= myMap.m-1)
					outFlag = true;
				else
					myDice.x++;	break;
			default:
				break;
			}
			
			if(outFlag)
				return;
			
			//rotate the dice
			myDice.rotate(direction);
			
			//check the die and the map
			if(myMap.idx(myDice.x, myDice.y) == 0){
				myMap.set(myDice.x, myDice.y, myDice.getBottom());
			}
			else{
				myDice.set(myMap.idx(myDice.x, myDice.y));
				myMap.set(myDice.x, myDice.y, 0);
			}
			
			System.out.println(myDice.getTop());
		}
	}
	private static class dice{
		public int x, y;
		private int[] die;
		public dice(){
			die = new int[6];
		}
		public void set(int k){
			die[5] = k;
		}
		public int getTop(){
			return die[2];
		}
		public int getBottom(){
			return die[5];
		}
		public void rotate(int direction){
			int tmp = die[5];
			switch(direction){
			case 1:
				die[5] = die[3];
				die[3] = die[2];
				die[2] = die[1];
				die[1] = tmp;	break;
			case 2:
				die[5] = die[1];
				die[1] = die[2];
				die[2] = die[3];
				die[3] = tmp;	break;
			case 3:
				die[5] = die[0];
				die[0] = die[2];
				die[2] = die[4];
				die[4] = tmp;	break;				
			case 4:
				die[5] = die[4];
				die[4] = die[2];
				die[2] = die[0];
				die[0] = tmp;	break;
			}
		}
	}
	private static class map{
		private int m, n;		//the size of the map
		private int[][] index;
		public map(Scanner scn, int m, int n){
			this.m = m;
			this.n = n;
			index = new int[m][n];
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++)
					index[i][j] = scn.nextInt();
			}
		}
		public int idx(int i, int j){
			return index[i][j];
		}
		public void set(int i, int j, int k){
			index[i][j] = k;
		}
	}
	
	public static void mainDice(String[] args){
		dice_on_map sol = new dice_on_map();
		sol.run();
	}
}