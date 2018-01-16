package baekjoon;

import java.util.Scanner;

public class Samsung_Wheel {
	private final static int wheelNum = 4;
	private static wheel[] wheels;
	
	private static class wheel {
		private final int saw = 8;
		private int[] arr;
		private wheel(Scanner scn){
			arr = new int[saw];
			String tmp = scn.nextLine();
			for(int i = 0; i < saw; i++)
				arr[i] = Character.getNumericValue(tmp.charAt(i));
		}
		private int get(int i){
			return arr[i];
		}
		private int left(){
			return 6;
		}
		private int right(){
			return 2;
		}
		
		private boolean check(wheel another, int dir){
			//This function is checking
			// whether 'this' wheel can make 'another' wheel rotate.
			//If dir = 0, another wheel is on the left side of this wheel
			// and if dir = 1, another wheel is on the right side of this wheel.
			boolean flag = false;
			switch(dir){
			case 0:
				if(this.get(left()) != another.get(right()))
					flag = true;
				break;
			case 1:
				if(this.get(right()) != another.get(left()))
					flag = true;
				break;
			default:
				break;
			}
			return flag;
		}
		
		private void rotation(int direction){
			//Rotate this wheel by changing arr[].
			//If direction = 1, rotate clockwise,
			// and direction = -1, rotate counterclockwise.
			if(direction == -1){
				int tmp = arr[0];
				for(int i = 0; i < saw - 1; i++)
					arr[i] = arr[i+1];
				arr[saw - 1] = tmp;
			}
			else{
				int tmp = arr[saw - 1];
				for(int i = saw - 1; i > 0; i--)
					arr[i] = arr[i-1];
				arr[0] = tmp;
			}
			
			return;
		}
		
		private void print(){
			for(int i = 0; i < saw; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
	
	public static void mainWheel(String[] args) {
		wheels = new wheel[wheelNum];
		
		//get inputs
		Scanner scn = new Scanner(System.in);
		for(int i = 0; i < wheelNum; i++)
			wheels[i] = new wheel(scn);
		
		int rotNum = scn.nextInt();
		int[][] rotArr = new int[rotNum][2];
		for(int i = 0; i < rotNum; i++){
			rotArr[i][0] = scn.nextInt();
			rotArr[i][1] = scn.nextInt();
		}
		
		scn.close();
		
		//rotate wheels
		solution(rotNum, rotArr);
		
		//calculate the score and print it
		int score = getScore();
		System.out.print(score);
		
		return;
	}

	private static int getScore() {
		int score = 0;
		for(int i = 0; i < wheelNum; i++){
			if(wheels[i].get(0) == 1)
				score += Math.pow(2, i);
		}
		return score;
	}

	private static void solution(int rotNum, int[][] rotArr) {
		for(int i = 0; i < rotNum; i++){
			//rotate wheels
			int rotateWheel = rotArr[i][0];	//the wheel which is rotated
			rotateWheel--;
			
			int[] rotateFlag = new int[wheelNum];	//the flag whether that wheel rotates or not
			//initialize rotate flags
			for(int j = 0; j < wheelNum; j++)
				rotateFlag[j] = 0;
			rotateFlag[rotateWheel] = rotArr[i][1];
			
			//check the flags on the left wheels of 'rotateWheel'
			int initDir = rotateFlag[rotateWheel];
			for(int j = rotateWheel; j > 0; j--){
				initDir *= -1;
				if(wheels[j].check(wheels[j-1], 0))
					rotateFlag[j-1] = initDir;
				else
					break;
			}
			
			//check the flags on the right wheels of 'rotateWheel'
			initDir = rotateFlag[rotateWheel];
			for(int j = rotateWheel; j < wheelNum-1; j++){
				initDir *= -1;
				if(wheels[j].check(wheels[j+1], 1))
					rotateFlag[j+1] = initDir;
				else
					break;
			}
			
			System.out.println("flags");
			for(int j = 0; j < wheelNum; j++)
				System.out.println(rotateFlag[j] + " ");
			System.out.println();
			
			//if the (rotate) flag is not 0, rotate that wheel
			for(int j = 0; j < wheelNum; j++){
				if(rotateFlag[j] != 0){
					wheels[j].rotation(rotateFlag[j]);
					System.out.println("rotation " + j + "th wheel");
					for(int k= 0; k <wheelNum; k++){
						if(k == j)
							System.out.print("    ->");
						wheels[k].print();
					}
					System.out.println();
				}
			}
			
			System.out.println();
			rotateFlag = null;
		}
	}
	
}
