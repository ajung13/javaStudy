package javaStudy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Yahoo3Solution {
	private int[] input;
	private Map<Integer, Integer> dupNum = new HashMap<Integer, Integer>();
	private int maxDistance;
	
	public Yahoo3Solution(){
		 Scanner scn = new Scanner(System.in);
		 String[] array = scn.nextLine().split(" ");
		 input = new int[array.length];
		 for(int i = 0; i < array.length; i++){
			 input[i] = Integer.parseInt(array[i]);
		 }
		 scn.close();
		 
		 maxDistance = 0;
	}
	
	public void findSolution(){
		for(int i=0; i<input.length; i++){
			dupNum.put(input[i], i);
		}
//		for(Integer key : dupNum.keySet())
//			System.out.println(key + " " + dupNum.get(key));
		
		for(int i=0; i<input.length; i++){
			int cnt = 0;
			if(dupNum.containsKey(input[i]))
				cnt = dupNum.get(input[i]) - i;
			if(cnt > maxDistance)
				maxDistance = cnt;
		}
	}
	
	public int maxDist(){
		return maxDistance;
	}
	
}
