package studyDFS;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
	private static class Relation{
		//private member variables
		private int n;
		private int[][] distance;
		private int minimum;
		private int minPerson;
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
			minPerson = -1;
			visited = new boolean[n];
		}
		public void newRelationship(int a, int b){
			a--;	b--;
			distance[a][b] = 1;
			distance[b][a] = 1;
		}
/*		public void run(){
			for(int i = 0; i < n; i++)
				KevinBacon(i);
		}*/
		public int min(){
			return this.minPerson;
		}
		
		//private methods
		private void KevinBacon(){
			//get kevinBacon value by using Dijkstra algorithm and
			//change the minimum when kevinBacon is smaller
			for(int i = 0; i < n; i++){
				Arrays.fill(visited, false);
				dijkstra(i, i, n-1);
				
				int sum = 0;
				for(int j = 0; j < n; j++){
					if(i < j)
						sum += distance[i][j];
					else
						sum += distance[j][i];
				}
				if(sum < this.minimum){
					this.minimum = sum;
					this.minPerson = i+1;
				}
			}
		}
		private void dijkstra(int start, int pnt, int end){
			if(pnt == end)
				return;
			if(pnt >= n || pnt < 0)
				return;
			
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
			
			dijkstra(start, min, end);
		}
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		
		Relation solution = new Relation(scn.nextInt());
		int cnt = scn.nextInt();
		for(; cnt > 0; cnt--)
			solution.newRelationship(scn.nextInt(), scn.nextInt());
		
		scn.close();
		
//		solution.run();
		solution.KevinBacon();
		System.out.print(solution.min());
	}
}