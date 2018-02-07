package baekjoon;

import java.util.Scanner;
import java.util.Arrays;

public class Main{
	private static class board{
	//variables
		private int n;
		private int[][] blocks;
		private int max;
		
	//public methods and constructor
		public board(){
			Scanner scn = new Scanner(System.in);
			this.n = scn.nextInt();
			blocks = new int[n][n];
			for(int i = 0; i < n*n; i++)
				blocks[i/n][i%n] = scn.nextInt();
			scn.close();
			this.max = 0;
		}
		public void solve(){
			dfs(0, blocks);
		}
		public int getMax(){
			return this.max;
		}
		
	//private methods
		private void printBlocks(int[][] block){
			for(int i = 0; i < n*n; i++){
				if(i%n == 0)
					System.out.println();
				System.out.print(block[i/n][i%n] + " ");
			}
		}
		private void move(int[][] block, int direction){
			//direction: 0 (up) 1 (down) 2 (left) 3 (right)
			boolean[] mergeFlag = new boolean[n];
			for(int i = 0 ; i < n; i++){
				//when direction is 0/1, i will be the column
				//and when direction is 2/3, i will be the row
				
				//initialize mergeFlag
				for(int j = 0; j < n; j++)
					mergeFlag[j] = false;
				
				int j, idx;		//idx: last nonempty place
				if(direction%2==0){
					//check block[1][i] -> block[n-1][i]	(direction: 0)
					//		block[i][1] -> block[i][n-1]	(direction: 2)
					j = 1;
					if(direction == 0 && block[0][i] != 0)
						idx = 0;
					else if(direction == 2 && block[i][0] != 0)
						idx = 0;
					else
						idx = -1;
				}
				else{
					//check block[n-2][i] -> block[0][i]	(direction: 1)
					//		block[i][n-2] -> block[i][0]	(direction: 3)
					j = n-2;
					if(direction == 1 && block[n-1][i] != 0)
						idx = n-1;
					else if(direction == 3 && block[i][n-1] != 0)
						idx = n-1;
					else
						idx = n;
				}
				
				while(true){
					//check block[j][i]		(direction: 0, 1)
					//		block[i][j]		(direction: 2, 3)
					
					if((direction/2 == 0 && block[j][i] != 0) || (direction/2 == 1 && block[i][j] != 0)){
						//nonempty
						if(direction%2==0 && idx+1!=j){
							//there are empty place
							if(direction == 0){
								block[idx+1][i] = block[j][i];
								block[j][i] = 0;
							}
							else{
								block[i][idx+1] = block[i][j];
								block[i][j] = 0;
							}
							j = idx+1;
							continue;
						}
						else if(direction%2==1 && idx-1!=j){
							//there are empty place
							if(direction == 1){
								block[idx-1][i] = block[j][i];
								block[j][i] = 0;
							}
							else{
								block[i][idx-1] = block[i][j];
								block[i][j] = 0;
							}
							j = idx-1;
							continue;
						}
						
						idx = j;
						if((direction%2 == 0 && j != 0) || (direction%2==1 && j != n-1)){
							//if block is same with prev block, merge them
							switch(direction){
							case 0:
								if(block[j][i] == block[j-1][i] && !mergeFlag[j-1]){
									block[j-1][i] *= 2;
									block[j][i] = 0;
									mergeFlag[j-1] = true;
									idx--;
									continue;
								}
								break;
							case 1:
								if(block[j][i] == block[j+1][i] && !mergeFlag[j+1]){
									block[j+1][i] *= 2;
									block[j][i] = 0;
									mergeFlag[j+1] = true;
									idx++;
									continue;
								}
								break;
							case 2:
								if(block[i][j] == block[i][j-1] && !mergeFlag[j-1]){
									block[i][j-1] *= 2;
									block[i][j] = 0;
									mergeFlag[j-1] = true;
									idx--;
									continue;
								}
								break;
							case 3:
								if(block[i][j] == block[i][j+1] && !mergeFlag[j+1]){
									block[i][j+1] *= 2;
									block[i][j] = 0;
									mergeFlag[j+1] = true;
									idx++;
									continue;
								}
								break;
							}
						}
					}
					
					//for running loop
					if(direction%2==0 && j<n-1)
						j++;
					else if(direction%2==1 && j>0)
						j--;
					else
						break;
				}
			}
			return;
		}
		private void dfs(int depth, int[][] block){
			System.out.println("depth: " + depth);
			if(depth > 5){
				printBlocks(block);
				for(int i = 0; i < n*n; i++){
					if(block[i/n][i%n] > this.max)
						max = block[i/n][i%n];
				}
			}
			
			int[][] initBlock = new int[n][n];
			System.arraycopy(block, 0, initBlock, 0, n*n);
			boolean checkFlag = false;
			
			move(block, 0);
			if(!Arrays.equals(initBlock, block)){
				dfs(depth+1, block);
				checkFlag = true;
			}

			System.arraycopy(initBlock, 0, block, 0, n*n);
			move(block, 1);
			if(!Arrays.equals(initBlock, block)){
				dfs(depth+1, block);
				checkFlag = true;
			}
			
			System.arraycopy(initBlock, 0, block, 0, n*n);
			move(block, 2);
			if(!Arrays.equals(initBlock, block)){
				dfs(depth+1, block);
				checkFlag = true;
			}
			
			System.arraycopy(initBlock, 0, block, 0, n*n);
			move(block, 3);
			if(!Arrays.equals(initBlock, block)){
				dfs(depth+1, block);
				checkFlag = true;
			}
			
			if(!checkFlag){
				for(int i = 0; i < n*n; i++){
					if(block[i/n][i%n] > this.max)
						max = block[i/n][i%n];
				}
			}
		}
	}
	public static void main(String[] args){
		board solution = new board();
		solution.solve();
		System.out.print(solution.getMax());
	}
}