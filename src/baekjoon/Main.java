package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	private static class Farm{
		private int mark;
		private int cowCnt;
		private Cow[] cows;
		private int maxStablity;
		public Farm(){
			Scanner scn = new Scanner(System.in);
			cowCnt = scn.nextInt();
			mark = scn.nextInt();
			cows = new Cow[cowCnt];
			
			for(int i = 0; i < cowCnt; i++){
				cows[i] = new Cow();
				cows[i].tall = scn.nextInt();
				cows[i].weight = scn.nextInt();
				cows[i].power = scn.nextInt();
			}
			
			scn.close();
			maxStablity = -1;
		}
		
		public void solve(){
			for(int i = 0; i < cowCnt; i++){
				Queue<Integer> q = new <Integer>LinkedList();
				dp(i, q, -1);
			}
		}
		private void dp(int pointer, Queue q, int last){
			//for debug
			printQueue(q);
			
			int stability = stableCheck(q);
			
			//check the height
			int height = heightCheck(q);
			if(height >= mark){
				//stability check
				if(stability > maxStablity)
					maxStablity = stability;
				return;
			}
			
			//all cows are stacked but mark is too tall
			if(pointer >= cowCnt)
				return;
			
			//'pointer'th cow is not stacked
			for(int i = 0; i < cowCnt; i++){
				if(i == pointer)	continue;
				if(q.contains(i))	continue;
				dp(i, q, last);
			}
			
			if(last == -1 || stability > cows[pointer].weight){
				//first stack or 'pointer'th cow can be stacked
				//put me
				q.add(pointer);
				for(int i = 0; i < cowCnt; i++){
					if(i == pointer)	continue;
					if(q.contains(i))	continue;
					dp(i, q, pointer)
				}
			}
		}
		private int heightCheck(Queue q){
			int height = 0;
			while(q.peek()!=null){
				int cow = (int)q.poll();
				height += cows[cow].tall;
			}
			return height;
		}
		private int stableCheck(Queue q){
			int[] power = new int[cowCnt];
			int idx = 0;
			
			while(q.peek()!=null){
				int cow = (int)q.poll();
				power[idx] = cows[cow].power;
				for(int i = 0; i < idx; i++)
					power[idx] -= cows[cow].weight;
			}
			
			idx = power[0];
			for(int i = 1; i < cowCnt; i++){
				if(power[i] < idx)
					idx = power[i];
			}
			return idx;
		}
		private void printQueue(Queue q){
			while(q.peek()!=null){
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
	private static class Cow{
		private int tall;
		private int weight;
		private int power;
	}
	public static void main(String[] args){
		Farm solution = new Farm();
		solution.solve();
	}
}