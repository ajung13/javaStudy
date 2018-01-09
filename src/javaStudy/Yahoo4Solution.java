package javaStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class Yahoo4Solution {
	int[] input;
	int totalCnt;
	
	public Yahoo4Solution(){
		Scanner scn = new Scanner(System.in);
		 String[] array = scn.nextLine().split(" ");
		 input = new int[array.length];
		 for(int i = 0; i < array.length; i++){
			 input[i] = Integer.parseInt(array[i]);
		 }
		 scn.close();
		 
		 totalCnt = 0;
	}
	
	public void findSolution(){
//		ArrayList<Integer> tmp = new ArrayList<>();
		boolean[] flag = new boolean[input.length];
		for(int i=0; i<input.length; i++){
			int cnt = 0, dup = 0;
			ArrayList<Integer> tmp = new ArrayList<>();
			if(flag[i])	continue;
			flag[i] = true;
			for(int j=i+1; j<input.length; j++){
				if(input[i] < input[j]){
					if(checkDup(tmp, input[j]))
						dup++;
					tmp.add(input[j]);
					cnt++;
					flag[j] = true;
				}
			}
			tmp.clear();
			tmp = null;
			
			if(cnt == 0)	continue;
			cnt++;
			totalCnt += subsetNum(cnt, dup);
			System.out.println("input: " + input[i] + ", cnt: " + cnt + ", dup: " + dup + ", total: " + totalCnt);
		}
		flag = null;
		
		System.out.println("total: " + totalCnt);
		return;
	}
	
	private boolean checkDup(ArrayList<Integer> tmp, int x) {
		// TODO Auto-generated method stub
		if(tmp.indexOf(x) < 0)
			return false;
		return true;
	}

	private int subsetNum(int n, int dup){
		if(dup == 0){
			return (int) (Math.pow(2, n) -1 -n);
		}
		int notDup = n-dup;
		int result = (int) (Math.pow(2, notDup) -1 -notDup);
		result += (Math.pow(2,  notDup-1) - 1) * dup;
		
		return result;
	}
}
