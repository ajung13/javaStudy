package javaStudy;

import java.util.Scanner;

public class Yahoo1Solution {
	private int n;
	
	public Yahoo1Solution(){
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		scn.close();
	}
	
	public Yahoo1Solution(int n){
		this.n = n;
	}
	
	public void printNums(){
		if(n < 0 || n > 1000){
			System.out.println("n is not initialized");
			return;
		}
		for(int i = 1; i <= n; i++){
			boolean flag = false;
			if(i % 3 == 0){
				System.out.print("Fizz");
				flag = true;
			}
			if(i % 5 == 0){
				System.out.print("Buzz");
				flag = true;
			}
			if(i % 7 == 0){
				System.out.print("Woof");
				flag = true;
			}
			if(!flag)
				System.out.print(i);
			System.out.println();
		}
	}

}
