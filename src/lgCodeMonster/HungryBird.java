package lgCodeMonster;

import java.util.Scanner;

/* 수정할 사항 (버그)
 * 위로 가나 아래로 가나 밥의 최대 개수가 같은 경우
 */


public class HungryBird {
	private static class BirdMap{
		private int n;
		private int[][] map;
		// 0: empty | 1: bob | 2: visited
		private Bird bird;
		private int eatenBob;
		private int maxBob;
		
		public void init(Scanner scn){
			this.n = scn.nextInt();
			if(map != null)
				map = null;
			map = new int[n][n];
			
			maxBob = 0;
			String tmp = scn.nextLine();
			for(int i = 0; i < n; i++){
				tmp = scn.nextLine();
				for(int j = 0; j < n; j++){
					if(tmp.charAt(j*2) == '_')
						map[i][j] = 0;
					else if(tmp.charAt(j*2) == 'B'){
						map[i][j] = 1;
						maxBob++;
					}
				}
			}
			
			bird = new Bird(n);
			eatenBob = 0;
		}
		
		public void run(){
			while(!bird.arrived()){
				eatenBob += map[bird.x][bird.y];
				map[bird.x][bird.y] = 0;
				
				int nextPos = bird.findNext(map, maxBob);
					// 0: up | 1: right | 2: down
				maxBob = bird.maxBob;
				
				bird.move(nextPos);
			}
		}
	}
	
	private static class Bird{
		private int n;
		public int x, y;
		public boolean upward;
		public int maxBob;
		
		public Bird(int n){
			this.n = n;
			this.x = n-1;
			this.y = 0;
			this.upward = true;
		}
		public boolean arrived(){
			if(x == n-1 && y == n-1)
				return true;
			else
				return false;
		}
		public void move(int pos){
			switch(pos){
			case 0:	this.x--;	break;
			case 1: this.y++;	break;
			case 2: this.x++;	break;
			}
		}
		public int findNext(int[][] map, int max){
			// 0: up | 1: right | 2: down
			maxBob = 0;
			int maxPosition = -1;
			int tmpBob;
			
			//find the max num of bob (continue to go up or down)
			if((this.upward && this.x > 0) || (!this.upward && this.x < n-1)){
				tmpBob = max;
				for(int i = this.y; i < this.n; i++)
					tmpBob -= map[this.x][i];
				if(tmpBob > maxBob){
					maxBob = tmpBob;
					if(this.upward)
						maxPosition = 0;
					else
						maxPosition = 2;
				}
			}
			
			//go to right
			if(this.y < n-1){
				tmpBob = max;
				if(this.upward){
					for(int i = 0; i < this.x; i++)
						tmpBob -= map[i][this.y];
				}
				else{
					for(int i = this.x+1; i < n; i++)
						tmpBob -= map[i][this.y];
				}
				if(tmpBob > maxBob){
					maxBob = tmpBob;
					maxPosition = 1;
				}
			}
			
			//check when this.upward == true
			if(this.upward){
				//go right and upward=false
				if(this.y < n-1){
					tmpBob = 0;
					for(int i = this.x; i < n; i++){
						for(int j = this.y+1; j < n; j++)
							tmpBob += map[i][j];
					}
					if(tmpBob > maxBob){
						maxBob = tmpBob;
						maxPosition = 1;
						this.upward = false;
					}
				}
				
				//go down
				tmpBob = 0;
				for(int i = this.x+1; i < n; i++){
					for(int j = this.y; j < n; j++)
						tmpBob += map[i][j];
				}
				if(tmpBob > maxBob){
					maxBob = tmpBob;
					maxPosition = 2;
					this.upward = false;
				}
			}
			
			return maxPosition;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testCase = scn.nextInt();
		BirdMap solution = new BirdMap();
		
		for(; testCase > 0; testCase--){
			solution.init(scn);
			solution.run();
			System.out.println(solution.eatenBob);
		}
		scn.close();
	}

}
