package baekjoon;
// Q11399: ATM

import java.util.Arrays;
import java.util.Scanner;

public class ATM{
	public static void mainATM(String[] args){
		int n;
		int[] arr;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		scn.close();
		
		Arrays.sort(arr);
		
		int sum = arr[0];
		for(int i = 1; i < n; i++){
			arr[i] += arr[i-1];
//			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		
		System.out.print(sum);
	}
}