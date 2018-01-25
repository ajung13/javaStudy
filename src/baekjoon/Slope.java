package baekjoon;

import java.util.Scanner;

public class Slope{
	private static class Path{
		private int n, l;
		private int[][] input;
		private int path;
		public Path(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			l = scn.nextInt();
			input = new int[n][n];
			for(int i = 0; i < n*n; i++){	
				input[i/n][i%n] = scn.nextInt();
			}
			scn.close();
			
			path = 0;
		}
		public int getPath() {
			return path;
		}
		
		public void solve() {
			boolean lineFlag;
			boolean[] slope = new boolean[n];
			
			for(int i = 0; i < n; i++){
				//initialize
				lineFlag = true;
				for(int j = 0; j < n; j++)
					slope[j] = false;
				
				//check the i-th slope line
				for(int j = 0; j < n-1; j++){
					if(input[i][j+1] == input[i][j])
						continue;
					int diff = input[i][j+1] - input[i][j];
					switch(diff){
					case 1:
						if(j + 1 - l < 0)
							lineFlag = false;
						else if(slope[j+1-l])
							lineFlag = false;
						else{
							int tmp = input[i][j];
							for(int k = j; k > j-l; k--){
								if(input[i][k] != tmp){
									lineFlag = false;
									break;
								}
								slope[k] = true;
							}
						}
						break;
					case -1:
						if(j + l >= n)
							lineFlag = false;
						else if(slope[j+l])
							lineFlag = false;
						else{
							int tmp = input[i][j+1];
							for(int k = j+1; k <= j+l; k++){
								if(input[i][k] != tmp){
									lineFlag = false;
									break;
								}
								slope[k] = true;
							}
						}
						break;
					default:
						lineFlag = false;
						break;
					}
					
					if(!lineFlag)	break;
				}
				if(lineFlag)
					path++;
				
				//initialize
				lineFlag = true;
				for(int j = 0; j < n; j++)
					slope[j] = false;
				
				//check the i-th slope line
				for(int j = 0; j < n-1; j++){
					if(input[j+1][i] == input[j][i])
						continue;
					int diff = input[j+1][i] - input[j][i];
					switch(diff){
					case 1:
						if(j + 1 - l < 0)
							lineFlag = false;
						else if(slope[j+1-l])
							lineFlag = false;
						else{
							int tmp = input[j][i];
							for(int k = j; k > j-l; k--){
								if(input[k][i] != tmp){
									lineFlag = false;
									break;
								}
								slope[k] = true;
							}
						}
						break;
					case -1:
						if(j + l >= n)
							lineFlag = false;
						else if(slope[j+l])
							lineFlag = false;
						else{
							int tmp = input[j+1][i];
							for(int k = j+1; k <= j+l; k++){
								if(input[k][i] != tmp){
									lineFlag = false;
									break;
								}
								slope[k] = true;
							}
						}
						break;
					default:
						lineFlag = false;
						break;
					}
					
					if(!lineFlag)	break;
				}
				
				if(lineFlag)
					path++;
			}
			
			
		}
		
	}
	public static void mainSlope(String[] args){
		Path solution = new Path();
		solution.solve();
		System.out.print(solution.getPath());
	}
}