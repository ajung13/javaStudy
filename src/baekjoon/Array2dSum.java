package baekjoon;
// Q2167: sum of 2d array

import java.util.Scanner;

public class Array2dSum{
	private static int sum;
	public static void main(String[] args){
		int m, n;
		int[][] arr;
		
		Scanner scn = new Scanner(System.in);
		m = scn.nextInt();
		n = scn.nextInt();
		arr = new int[m][n];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++)
				arr[i][j] = scn.nextInt();
		}
		
		int testCase = scn.nextInt();
		while(testCase-- > 0){
			sum = 0;
			getSum(arr, scn.nextInt(), scn.nextInt(), scn.nextInt(), scn.nextInt());
			System.out.println(sum);
		}
		
		scn.close();
	}
	
	private static void getSum(int[][] arr, int i, int j, int x, int y){
		i--;	j--;	x--;	y--;
		for(; i <= x; i++){
			for(int idx = j; idx <= y; idx++)
				sum += arr[i][idx];
		}
	}
}