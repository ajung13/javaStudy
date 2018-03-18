package baekjoon;

import java.util.Scanner;

public class Main{
	private static int m, n;
	private static int[][] map;
	private static int ways;
	
	public static void main(String[] args){
		// get inputs
		Scanner scn = new Scanner(System.in);
		m = scn.nextInt();
		n = scn.nextInt();
		map = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++)
				map[i][j] = scn.nextInt();
		}
		scn.close();
		
		ways = 0;
		search(0, 0);
		
		System.out.print(ways);
	}
	
	private static void search(int i, int j){
		if(i == m-1 && j == n-1){
			ways++;
			return;
		}
		
		if(i > 0 && map[i-1][j] < map[i][j])
			search(i-1, j);
		if(i < m-1 && map[i+1][j] < map[i][j])
			search(i+1, j);
		if(j > 0 && map[i][j-1] < map[i][j])
			search(i, j-1);
		if(j < n-1 && map[i][j+1] < map[i][j])
			search(i, j+1);
		
		return;
	}
}