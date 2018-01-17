package baekjoon;

import java.util.Scanner;

public class Main{
	private static class treasure{
		private int[] a, b;
		private int n;
		private int[] idx;
		public treasure(){
			//get inputs
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			a = new int[n];
			b = new int[n];
			for(int i = 0; i < n; i++)
				a[i] = scn.nextInt();
			for(int i = 0; i < n; i++)
				b[i] = scn.nextInt();
			scn.close();
		}
		
		public void sorting(){
			//sorting A
			for(int i = 0; i < n; i++){
				//find the value of A[i]
				for(int j = 0; j < n; j++){
				}
			}
		}
		
		public int getS(){
			//Calculate the value of S
			//and this function must be called after 'sorting' function is called
			int S = 0;
			for(int i = 0; i < n; i++)
				S += (a[i] * b[i]); 
			return S;
		}
	}
	public static void main(String[] args){
		treasure solution = new treasure();
		solution.sorting();
		System.out.println(solution.getS());
		return;
	}
}