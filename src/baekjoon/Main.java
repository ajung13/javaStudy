package baekjoon;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	private static class Map{
		//class member variable
		private int n;
//		private ArrayList<Snake> snake;
		private ArrayList<ArrayList<Snake>> snake_group;
		private ArrayList<Snake> snake_child;
		private Snake cur;
		private int[][] move;
		private int direction;
		
		public Map(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			cur = new Snake(n, n);
//			snake = new ArrayList<>();
//			snake.add(new Snake(n, n));
			snake_group = new ArrayList<ArrayList<Snake>>();
			snake_child = new ArrayList<Snake>();
			snake_child.add(cur);
			snake_group.add(snake_child);
			
			int tmp = scn.nextInt();
			move = new int[tmp][2];
			for(int i = 0; i < tmp; i++){
				if(i == 0)
					move[i][0] = scn.nextInt();
				else
					move[i][0] = move[i-1][0] + scn.nextInt();
				move[i][1] = (scn.next().charAt(0) == 'L')? 0:1;
			}
			scn.close();
			
			n = n*2+1;
		}
		
		public void startMoving(){
			int time = 0;
			int moveIdx = 0;
			
			for(; time < Integer.MAX_VALUE; time++){
				if(time == 50000)
					System.out.println("hi");
				if(moveIdx < move.length && move[moveIdx][0] == time){
					//time to change direction
					if(move[moveIdx][1] == 0)
						direction = (direction + 1)%4;
					else
						direction = (direction + 3)%4;
					moveIdx++;
				}
				
				//move snake
				cur.i += (direction-2)%2;
				cur.j -= (direction-1)%2;
				
				//game over check
				if(cur.i < 0 || cur.i >= n || cur.j < 0 || cur.j >= n)
					break;
				if(meetMe())
					break;
				
//				snake.add(new Snake(cur.i, cur.j));
				insert(cur.i, cur.j);
			}
			
			System.out.print(time+1);
		}

		private boolean meetMe(){
/*			boolean flag = false;
			for(Snake tmp : snake){
				if(tmp.i == cur.i && tmp.j == cur.j){
					flag = true;
					break;
				}
			}
			return flag;*/
			
/*			if(snake.indexOf(cur) < 0)
				return false;
			else
				return true;*/
			
			boolean flag = false;
			int idx;
			for(idx = 0; idx < snake_group.size(); idx++){
				if(snake_group.get(idx).get(0).i == cur.i){
					flag = true;
					break;
				}
			}
			
			if(flag){
				flag = false;
				for(Snake tmp : snake_group.get(idx)){
					if(tmp.j == cur.j){
						flag = true;
						break;
					}
				}
			}
			
			return flag;
		}
		
		private void insert(int i, int j){
			for(int idx = 0; idx < snake_group.size(); idx++){
				if(((Snake) snake_group.get(idx).get(0)).i == i){
					snake_group.get(idx).add(new Snake(i, j));
					return;
				}
			}
			
			snake_child = new ArrayList<Snake>();
			snake_child.add(new Snake(i, j));
			snake_group.add(snake_child);
		}

	}
	
	private static class Snake{
		public int i, j;
		public Snake(int i, int j){
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		Map solution = new Map();
		solution.startMoving();
	}

}
