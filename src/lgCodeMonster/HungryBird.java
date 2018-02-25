package lgCodeMonster;

import java.util.*;

public class HungryBird {
	private static class BirdMap{
		private int n;
		private int[][] map;
		// 0: empty | 1: bob | 2: visited
		private Pos bird;
		ArrayList<Pos> bobs;
		
		public void init(Scanner scn){
			this.n = scn.nextInt();
			if(map != null)
				map = null;
			map = new int[n][n];
			
			String tmp = scn.nextLine();
			for(int i = 0; i < n; i++){
				tmp = scn.nextLine();
				for(int j = 0; j < n; j++){
					if(tmp.charAt(j*2) == '_')
						map[i][j] = 0;
					else if(tmp.charAt(j*2) == 'B')
						map[i][j] = 1;
				}
			}
			
			bird.x = n-1;
			bird.y = 0;
			bobs = new ArrayList<>();
		}
		
		public void run(){
			
		}
	}
	
	private static class Pos{
		public int x, y;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testCase = scn.nextInt();
		BirdMap solution = new BirdMap();
		
		for(; testCase > 0; testCase--){
			solution.init(scn);
			solution.run();
		}
		scn.close();
	}

}
