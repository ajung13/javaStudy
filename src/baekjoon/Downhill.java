package baekjoon;
// Q1520: downhill

import java.util.Scanner;

public class Downhill{
	private static int m, n;
	private static int[][] map;
	private static int[][] visited;
	
	public static void main(String[] args){
		// get inputs
		Scanner scn = new Scanner(System.in);
		m = scn.nextInt();
		n = scn.nextInt();
		map = new int[m][n];
		visited = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++)
				map[i][j] = scn.nextInt();
		}
		scn.close();
		visited[m-1][n-1] = 1;
		
		find(0, 0);
		System.out.print(visited[0][0]);
	}
	
	public static void find(int i, int j){
		if(i > 0 && map[i-1][j] < map[i][j]){	//up
			if(visited[i-1][j] == 0)
				find(i-1, j);
			visited[i][j] += visited[i-1][j];
		}
		if(i < m-1 && map[i+1][j] < map[i][j]){	//down
			if(visited[i+1][j] == 0)
				find(i+1, j);
			visited[i][j] += visited[i+1][j];
		}
		if(j > 0 && map[i][j-1] < map[i][j]){	//left
			if(visited[i][j-1] == 0)
				find(i, j-1);
			visited[i][j] += visited[i][j-1];
		}
		if(j < n-1 && map[i][j+1] < map[i][j]){	//right
			if(visited[i][j+1] == 0)
				find(i, j+1);
			visited[i][j] += visited[i][j+1];
		}
	}
}