package baekjoon;

import java.util.Scanner;

public class IceBear{
	private static int bearReach;
	private static int[] map;
	private static int mapLength;
	public static void mainBear(String[] args){
		//get inputs
		Scanner scn = new Scanner(System.in);
		int bucket = scn.nextInt();
		bearReach = scn.nextInt();
		if(bearReach > 500000)
			bearReach = 500000;
		
		map = new int[1000001];
		mapLength = 0;
		for(; bucket > 0; bucket--){
			int tmpIce = scn.nextInt();
			int tmpLocation = scn.nextInt();
			map[tmpLocation] = tmpIce;
			if(tmpLocation > mapLength)
				mapLength = tmpLocation;
		}
		scn.close();
		
		//get the sum of initial
		int max = 0;
		int sum = 0;
		for(int i = 0; i <= bearReach*2; i++)
			sum += map[i];
		max = sum;
		
		//move the pointer and check
		for(int i = bearReach*2 + 1; i <= mapLength; i++){
			sum -= map[i-bearReach*2-1];
			sum += map[i];
			if(sum > max)
				max = sum;
		}
		
		//print
		System.out.print(max);
	}
}