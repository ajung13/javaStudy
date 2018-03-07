package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Frisbee{
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
				LinkedList<Integer> list = new LinkedList<Integer>();
				stack(list, i);
				list = null;
			}
			
			if(maxStablity == -1)
				System.out.print("Mark is too tall");
			else
				System.out.print(maxStablity);
		}
		
		private void stack(LinkedList<Integer> list, int cowNum){
			int stability;

			list.push(cowNum);
			stability = getStability(list);
			if(stability < 0)
				return;
			
			if(heightCheck(list)){
				//height is taller than Mark
				if(stability > maxStablity)
					maxStablity = stability;
				return;
			}
			
			if(list.size() >= cowCnt)
				return;
			
			for(int i = 0 ; i < cowCnt; i++){
				if(i == cowNum)	continue;
				if(myContains(list, i))	continue;
				LinkedList<Integer> copyList = new LinkedList<Integer>();
				myCopy(list, copyList);
				stack(copyList, i);
				copyList = null;
			}
		}
		
		private boolean myContains(LinkedList<Integer> list, int key){
			for(int i = 0; i < list.size(); i++)
				if(list.get(i) == key)	return true;
			return false;
		}
		
		private void myCopy(LinkedList<Integer> src, LinkedList<Integer> des){
			for(int i : src)
				des.add(i);
		}
		
		private boolean heightCheck(LinkedList<Integer> list){
			int total = 0;
			for(int i = 0; i < list.size(); i++)
				total += cows[list.get(i)].tall;
			return (total >= mark);
		}
		private int getStability(LinkedList<Integer> list){
			int[] pow = new int[list.size()];
			for(int i = 0; i < list.size(); i++){
				pow[i] = cows[list.get(list.size()-i-1)].power;
				for(int j = 0; j < i; j++)
					pow[j] -= cows[list.get(list.size()-i-1)].weight;
			}
			
			int min = pow[0];
			for(int i = 1; i < list.size(); i++){
				if(pow[i] < min)
					min = pow[i];
			}
			
			pow = null;
			return min;
		}
	}
	private static class Cow{
		private int tall;
		private int weight;
		private int power;
	}
	public static void mainFrisbee(String[] args){
		Farm solution = new Farm();
		solution.solve();
	}
}