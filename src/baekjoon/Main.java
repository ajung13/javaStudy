package baekjoon;

import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static class Map{
		private int n, maxHeight;
		private int[][] map;
		private Queue<Pos> q;
		private boolean[][] visited;
		public Map(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			map = new int[n][n];
			
			maxHeight = 0;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					map[i][j] = scn.nextInt();
					if(map[i][j] > maxHeight)
						maxHeight = map[i][j];
				}
			}
			scn.close();
			
			q = new <Pos> LinkedList();
			visited = new boolean[n][n];
		}
		
		public void rain(int height){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					if(map[i][j] <= height)
						map[i][j] = 0;
				}
			}
		}
		
		public int area(){
			for(int i = 0; i < n; i++)
				Arrays.fill(visited[i], false);
		}
		
		private void bfs(Pos idx){
			q.add(idx);
			while(!q.isEmpty()){
				Pos tmp = q.poll();
				
			}
		}
	}
	private static class Pos{
		public int x, y;
	}
	public static void main(String[] args) {
		Map solution = new Map();
		int maxArea = 0;
		
		for(int i = 1; i < solution.maxHeight; i++){
			solution.rain(i);
			maxArea = Math.max(solution.area(), maxArea);
		}
		
		System.out.print(maxArea);
	}

}
