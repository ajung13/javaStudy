package studyDFS;

import java.util.Arrays;
import java.util.Scanner;

public class KevinBacon{
	private static class Relation{
		//private member variables
		private int n;
		private int[][] distance;
		private int minimum;
		private int minPerson;
		private boolean[][] visited;
		
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
			visited = new boolean[n][n];
		}
		public void newRelationship(int a, int b){
			a--;	b--;
			distance[a][b] = 1;
			distance[b][a] = 1;
		}
		public void run(){
			for(int i = 0; i < n; i++)
				KevinBacon(i, i);
		}
		public int min(){
			return this.minPerson;
		}
		
		//private methods
		private void KevinBacon(int start, int pnt){
			visited[start][pnt] = true;
			for(int i = 0; i < n; i++){
				if(allVisited(start))	break;
				if(distance[start][i] > distance[start][pnt] + distance[pnt][i])
					distance[start][i] = distance[start][pnt] + distance[pnt][i];
			}
		}
		private boolean allVisited(int j){
			boolean flag = true;
			for(int i = 0; i < n; i++){
				if(!visited[j][i]){
					flag = false;
					break;
				}
			}
			return flag;
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