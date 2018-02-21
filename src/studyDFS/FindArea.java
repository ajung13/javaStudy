package studyDFS;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class FindArea{
	private static class Map{
		//private member variable
		private int m, n;
		private int[][] map;
		//map :: 0 : empty(non-visited) 1 : square 2 : visited
		private ArrayList<Integer> myArea;
		private int globalS;
		
		//public method and constructor
		public Map(){
			Scanner scn = new Scanner(System.in);
			this.m = scn.nextInt();
			this.n = scn.nextInt();
			map = new int[m][n];
			
			int square = scn.nextInt();
			for(; square > 0; square--)
				setSquare(scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.nextInt());
			scn.close();
//			printMap();
			myArea = new ArrayList<>();
		}
		public void findArea(){
			for(int i = 0 ; i < m; i++){
				for(int j = 0; j < n; j++){
					if(map[i][j] != 0)
						continue;
					globalS = 0;
					newArea(i, j);
					myArea.add(globalS);
				}
			}
		}
		public void printAreas(){
			System.out.println(myArea.size());
			
			Collections.sort(myArea);
			for(int i : myArea)
				System.out.print(i + " ");
		}
		
		//private methods
		private void setSquare(int ay, int ax, int by, int bx){
			ax = m-ax-1;
			bx = m-bx;
			by--;
			
			for(; bx <= ax; bx++){
				for(int i = ay; i <= by; i++)
					map[bx][i] = 1;
			}
		}
		private void newArea(int i, int j) {
			map[i][j] = 2;
			globalS++;
			
			if(i > 0 && map[i-1][j] == 0)
				newArea(i-1, j);
			if(i < m-1 && map[i+1][j] == 0)
				newArea(i+1, j);
			if(j > 0 && map[i][j-1] == 0)
				newArea(i, j-1);
			if(j < n-1 && map[i][j+1] == 0)
				newArea(i, j+1);
			
			return;
		}
	}
	public static void mainArea(String[] args){
		Map solution = new Map();
		solution.findArea();
		solution.printAreas();
	}
}