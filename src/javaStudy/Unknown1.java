package javaStudy;

import java.util.Scanner;

public class Unknown1 {
	private int[] input;
	private int n;

	public Unknown1(){
		Scanner scn = new Scanner(System.in);
		 String[] array = scn.nextLine().split(" ");
		 input = new int[array.length];
		 for(int i = 0; i < array.length; i++){
			 input[i] = Integer.parseInt(array[i]);
		 }
		 scn.close();
		 
		 n = input.length;
	}
	
	public void findSolution(){
		boolean[] flag = new boolean[n];
		
		//initialize flags
		for(int i = 0; i < n; i++)
			flag[i] = false;
		
		//setting flags
		for(int i = 0; i < n; i++){
			if(input[i] > n || input[i] <= 0)	continue;
			flag[input[i]-1] = true;
		}
		
		//print
		for(int i = 0; i < n; i++){
			if(!flag[i]){
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(n+1);
		return;
	}
}
