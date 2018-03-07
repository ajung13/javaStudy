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
			for(int i = 0; i < cowCnt; i++){
				LinkedList<Integer> list = new LinkedList<Integer>();
				stack(list, i);
				list = null;
				System.out.println("--------------------");
			}
			
			if(maxStablity == -1)
				System.out.print("Mark is too tall");
			else
				System.out.print(maxStablity);
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
			
			for(int i = 0; i < list.size(); i++){
				System.out.print(list.get(i) + " ");
				if(i == 0)	System.out.print("/ ");
			}
			System.out.println();
			
			if(heightCheck(list)){
				//height is taller than Mark
				System.out.println("stab: " + stability);
				if(stability > maxStablity)
					maxStablity = stability;
				return;
			}
			else
				System.out.println("stab: " + stability);
			
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
			for(int i = 1; i < list.size(); i++)
				if(list.get(i) == key)	return true;
			return false;
		}
		
		private void myCopy(LinkedList<Integer> src, LinkedList<Integer> des){
			for(int i : src)
				des.add(i);
		}
		
		private boolean heightCheck(LinkedList<Integer> list){
			int total = 0;
			for(int i = 1; i < list.size(); i++)
				total += cows[list.get(i)].tall;
			System.out.print("height: " + total + " / ");
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