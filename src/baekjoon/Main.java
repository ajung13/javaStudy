package baekjoon;

import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		int n;
		int[] arr;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		scn.close();
		
		int[][] d = new int[2][n];
		d[0][0] = 10;	//the smallest number
		d[1][0] = 1;	//length
		for(int i = 0; i < n; i++){
			if(arr[i] > d[0][i-1]){
				d[0][i] = d[0][i-1];
				d[1][i] = d[1][i-1] + 1;
			}
		}
	}
}