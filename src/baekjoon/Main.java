package baekjoon;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		int wineNum;
		int[] wine;
		
		Scanner scn = new Scanner(System.in);
		wineNum = scn.nextInt();
		wine = new int[wineNum];
		for(int i = 0; i < wineNum; i++)
			wine[i] = scn.nextInt();
		scn.close();
		
		
	}
}