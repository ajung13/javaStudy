package studyDFS;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
	private static class Map{
		private int n;
		private int[][] map;
		private ArrayList<Integer> myArea;
		private int globalS;
		
		public Map(){
			Scanner scn = new Scanner(System.in);
			this.n = scn.nextInt();
			map = new int[n][n];
			
			String tmp = scn.nextLine();
			for(int i = 0; i < n; i++){
				tmp = scn.nextLine();
				for(int j = 0; j < n; j++)
					map[i][j] = Character.getNumericValue(tmp.charAt(j));
			}
			scn.close();
			myArea = new ArrayList<>();
		}
		
		public void findArea(){
			for(int i = 0 ; i < n; i++){
				for(int j = 0; j < n; j++){
					if(map[i][j] != 1)
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
				System.out.println(i);
		}
		
		private void newArea(int i, int j) {
			map[i][j] = 2;
			globalS++;
			
			if(i > 0 && map[i-1][j] == 1)
				newArea(i-1, j);
			if(i < n-1 && map[i+1][j] == 1)
				newArea(i+1, j);
			if(j > 0 && map[i][j-1] == 1)
				newArea(i, j-1);
			if(j < n-1 && map[i][j+1] == 1)
				newArea(i, j+1);
			
			return;
		}
	}
	public static void main(String[] args){
		Map solution = new Map();
		solution.findArea();
		solution.printAreas();
	}
}