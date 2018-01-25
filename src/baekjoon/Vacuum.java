package baekjoon;

import java.util.Scanner;

public class Vacuum{
	private static class Cleaning{
		private int n, m;
		private int[][] room;
		private int[] robot;
		private int cleaned;
		public Cleaning(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			m = scn.nextInt();
			
			robot = new int[3];
			room = new int[n][m];
			
			for(int i = 0; i < 3; i++)
				robot[i] = scn.nextInt();
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++)
					room[i][j] = scn.nextInt();
			}
			scn.close();
			
			cleaned = 0;
		}
		public int getCleanSpace(){
			return this.cleaned;
		}
		
		public void clean() {
			if(room[robot[0]][robot[1]] != 0)
				return;
			
			int thisPlace = 0;
			boolean checkFlag = false;
			while(true){
				System.out.print("robot location: room[" + robot[0] + "][" + robot[1] + "]");
				System.out.println(" direction: " + robot[2]);
				if(!checkFlag){
					//1. clean this place
					room[robot[0]][robot[1]] = 2;
					cleaned++;
					checkFlag = true;
					System.out.println("...robot cleaning");
				}
				
				//2. check the left side
				int myLeft = (robot[2]%2==0)? robot[2]-1 : (robot[2]-2)*2;
				if(robot[0]+myLeft/2 >= 0 && robot[0]+myLeft/2 < n &&
						robot[1]+myLeft%2 >= 0 && robot[1]+myLeft%2 < m &&
						room[robot[0]+myLeft/2][robot[1]+myLeft%2] == 0){
					//2-1. the left place is not cleaned yet
					//rotate the robot
					robot[2]--;
					if(robot[2] < 0)	robot[2] = 3;
					//move to that place
					robot[0] += myLeft/2;
					robot[1] += myLeft%2;
					thisPlace = 0;
					checkFlag = false;
					continue;
				}
				else if(thisPlace < 3){
					//2-2. there's not place to clean
					//rotate the robot
					robot[2]--;
					if(robot[2] < 0)	robot[2] = 3;
					thisPlace++;
				}
				else{
					//2-3. if every place around robot is the wall or cleaned yet
					robot[2]--;
					if(robot[2] < 0)	robot[2] = 3;
					
					int myBack = (robot[2]%2==0)? (robot[2]-1)*(-2) : robot[2]-2;
					if(robot[0]+myBack/2 < 0 || robot[0]+myBack/2 >= n ||
							robot[1]+myBack%2 < 0 || robot[1]+myBack%2 >= m ||
							room[robot[0]+myBack/2][robot[1]+myBack%2] == 1)
						//there's no place to go back
						break;
					else{
						robot[0] += myBack/2;
						robot[1] += myBack%2;
						thisPlace = 0;
					}
				}
			}
		}
		
		public void printRoom(){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++)
					System.out.print(room[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
	}
	public static void mainVacuum(String[] args){
		Cleaning robot = new Cleaning();
		robot.printRoom();
		robot.clean();
		robot.printRoom();
		System.out.print(robot.getCleanSpace());
	}
}