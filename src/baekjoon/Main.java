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
				cows[i].name = i;
				cows[i].tall = scn.nextInt();
				cows[i].weight = scn.nextInt();
				cows[i].power = scn.nextInt();
			}
			
			scn.close();
			maxStablity = -1;
		}
		
		public void solve(){
			LinkedList<Integer> list = new LinkedList<Integer>();
			for(int i = 0; i < cowCnt; i++){
				stack(list, i);
				System.out.println("--------------------");
			}
		}
		
		private void stack(LinkedList<Integer> list, int cowNum){
			int stability;
			if(list.size() == 0)
				stability = cows[cowNum].power;
			else{
				stability = list.pop();
				stability -= cows[cowNum].weight * list.size();
				if(stability < 0)
					return;
			}
			list.push(cowNum);
			list.push(stability);
			
			for(int i = 0; i < list.size(); i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
			
			if(heightCheck(list)){
				//height is taller than Mark
				if(stability > maxStablity)
					maxStablity = stability;
				else
					return;
			}
			
			if(list.size() >= cowCnt)
				return;
			
			for(int i = 0 ; i < cowCnt; i++){
				if(i == cowNum)	continue;
				if(list.contains(i))	continue;
				stack(list, i);
			}
		}
		
		private boolean heightCheck(LinkedList<Integer> list){
			int total = 0;
			for(int i = 0; i < list.size()-1; i++)
				total += cows[i].tall;
			return (total >= mark);
		}
	}
	private static class Cow{
		private int name;
		private int tall;
		private int weight;
		private int power;
	}
	public static void main(String[] args){
		Farm solution = new Farm();
		solution.solve();
	}
}