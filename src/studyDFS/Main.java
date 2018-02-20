package studyDFS;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
	private static class Relation{
		//private member variables
		private int n;
		private int[][] distance;
		private int minimum;
		private boolean[] visited;
		
		//public methods and constructor
		public Relation(int n){
			this.n = n;
			distance = new int[n][n];
			for(int i = 0; i < n*n; i++){
				if(i/n == i%n)
					distance[i/n][i%n] = 0;
				else
					distance[i/n][i%n] = Integer.MAX_VALUE;
			}
			minimum = Integer.MAX_VALUE;
			visited = new boolean[n];
		}
		public void newRelationship(int a, int b){
			a--;	b--;
			distance[a][b] = 1;
			distance[b][a] = 1;
		}
		public void run(){
			for(int i = 0; i < n; i++)
				KevinBacon(i);
		}
		public int min(){
			return this.minimum;
		}
		
		//private methods
		private void KevinBacon(int start){
			//get kevinBacon value by using Dijkstra algorithm and
			//change the minimum when kevinBacon is smaller
			Arrays.fill(visited, false);
			for(int i = 0; i < n; i++)
				dijkstra(i, 0, n-1);
		}
		private int dijkstra(int start, int pnt, int end){
			if(pnt == end)
				return distance[start][end];
			
			visited[pnt] = true;
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++){
				if(visited[i] == false && distance[pnt][i] != Integer.MAX_VALUE){
					if(distance[start][i] > distance[start][pnt] + distance[pnt][i] && distance[start][pnt] != Integer.MAX_VALUE){
						distance[start][i] = distance[start][pnt] + distance[pnt][i];
					}
					if(min == Integer.MAX_VALUE || distance[start][min] > distance[start][i])
						min = i;
				}
			}
			
			return dijkstra(start, min, end);
		}
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		
		Relation solution = new Relation(scn.nextInt());
		int cnt = scn.nextInt();
		for(; cnt > 0; cnt--)
			solution.newRelationship(scn.nextInt(), scn.nextInt());
		
		scn.close();
		
		solution.run();
		System.out.print(solution.min());
	}
}