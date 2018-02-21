package studyDFS;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponent{
	private static class adjList{
		private int n;
		private ArrayList<Integer>[] graph;
		private boolean[] visited;
		
		public adjList(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			graph = new ArrayList[n];
			for(int i = 0; i < n; i++)
				graph[i] = new ArrayList<>();
			
			int edge = scn.nextInt();
			for(; edge > 0; edge--){
				int from = scn.nextInt();
				int to = scn.nextInt();
				from--; to--;
				graph[from].add(to);
				graph[to].add(from);
			}

			scn.close();
			
//			printGraph();
			visited = new boolean[n];
		}
		public boolean visitComponent(int pnt){
			if(visited[pnt])
				return false;
			
			visited[pnt] = true;
			for(int tmp : graph[pnt]){
				if(!visited[tmp]){
					visitComponent(tmp);
				}
			}
			return true;
		}
		
		private void printGraph(){
			for(int i = 0 ; i < n; i++){
				for(int tmp : graph[i])
					System.out.print(tmp + " -> ");
				System.out.println("end");
			}
		}
	}
	
	public static void mainCC(String[] args){
		int cc = 0;
		adjList solution = new adjList();
		for(int i = 0; i < solution.n; i++){
			if(solution.visitComponent(i))
				cc++;
		}
		System.out.print(cc);
	}
}