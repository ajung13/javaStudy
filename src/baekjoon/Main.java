package baekjoon;
// Q1937: greedy panda

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		int n;
		int[][] map;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		map = new int[n][n];
		for(int i = 0; i < n*n; i++)
			map[i/n][i%n] = scn.nextInt();
		scn.close();
		
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				
			}
		}
	}
}