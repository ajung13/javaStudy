package baekjoon;

import java.util.Scanner;

public class Main{
	private static class Path{
		private int n, l;
		private int[][] input;
		private int path;
		public Path(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			l = scn.nextInt();
			for(int i = 0; i < n*n; i++)
				input[i/n][i%n] = scn.nextInt();
			scn.close();
			
			path = 0;
		}
		public int getPath() {
			return path;
		}
		
		public void solve() {
			for(int i = 0; i < n; i++){
				
			}
		}
		
	}
	public static void main(String[] args){
		Path solution = new Path();
		solution.solve();
		System.out.println(solution.getPath());
	}
}