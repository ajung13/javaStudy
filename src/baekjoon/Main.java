package baekjoon;

import java.util.Scanner;

public class Main{
	private static class treasure{
		private int[] a, b;
		private int n;
		private int S;
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
			//calculate S
			this.S = 0;
			
			boolean[] flagA = new boolean[n];
			boolean[] flagB = new boolean[n];
			for(int i = 0; i < n; i++){
				flagA[i] = false;
				flagB[i] = false;
			}
			
			for(int i = 0; i < n; i++){
				//find the i-th largest number among b[]
				int max = 0, min = 0;
				
				do{
					if(flagA[min])
						min++;
					if(flagB[max])
						max++;
				}while(flagA[min] || flagB[max]);
				
				for(int j = 0; j < n; j++){
					if(!flagB[j] && b[j] > b[max])
						max = j;
					if(!flagA[j] && a[j] < a[min])
						min = j;
				}
				//b[max] is the maximum among b[]
				//and a[min] is the minimum among a[]
				flagA[min] = true;
				flagB[max] = true;
				
//				System.out.println("max: " + max + ", min: " + min);
				
				S += (a[min] * b[max]);
			}
			
			flagA = null;
			flagB = null;
			return;
		}
		
		public int getS(){
			return S;
		}
	}
	public static void main(String[] args){
		treasure solution = new treasure();
		solution.sorting();
		System.out.print(solution.getS());
		return;
	}
}