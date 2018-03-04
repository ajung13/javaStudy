package baekjoon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class RedGreen{
	private static class Art{
		private int n;
		private int[][] art;	//R: 0, B: 1, G: 2
		private boolean[][] visited;
		public Art() throws FileNotFoundException{
//			File file = new File("C:\\Users\\cwhth\\workspace\\javaStudy\\cowart\\1.in");
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			art = new int[n][n];
			visited = new boolean[n][n];
			scn.nextLine();
			for(int i = 0; i < n; i++){
				String tmp = scn.nextLine();
				for(int j = 0; j < n; j++)
					art[i][j] = (tmp.charAt(j) == 'R')? 0 : ((tmp.charAt(j) == 'G')? 1:2);
			}
			scn.close();
		}
		public void color(){
			for(int i = 0 ; i < n*n; i++){
				if(art[i/n][i%n] > 0)
					art[i/n][i%n]--;
			}
			for(int i = 0; i < n; i++)
				Arrays.fill(visited[i], false);
		}
		public int findArea(){
			int area = 0;
			for(int i = 0 ; i < n*n; i++){
				if(visited[i/n][i%n])
					continue;
				bfs(i);
				area++;
			}
			return area;
		}
		private void bfs(int start){
			Queue<Integer> q = new <Integer>LinkedList();	//art[i][j] -> [n*i+j]
			visited[start/n][start%n] = true;
			q.add(start);
			
			while(!q.isEmpty()){
				int temp = q.poll();
				int i = temp/n;
				int j = temp%n;
				
				//up
				if(i > 0 && !visited[i-1][j] && art[i-1][j] == art[i][j]){
					visited[i-1][j] = true;
					q.add((i-1)*n + j);
				}
				//down
				if(i < n-1 && !visited[i+1][j] && art[i+1][j] == art[i][j]){
					visited[i+1][j] = true;
					q.add((i+1)*n + j);
				}
				//left
				if(j > 0 && !visited[i][j-1] && art[i][j-1] == art[i][j]){
					visited[i][j-1] = true;
					q.add(i*n + j-1);
				}
				//right
				if(j < n-1 && !visited[i][j+1] && art[i][j+1] == art[i][j]){
					visited[i][j+1] = true;
					q.add(i*n + j+1);
				}
			}
		}
	}
	
	public static void mainRedGreen(String[] args){
		try{
			Art solution = new Art();
			System.out.print(solution.findArea() + " ");
			solution.color();
			System.out.print(solution.findArea());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}