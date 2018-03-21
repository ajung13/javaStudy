package baekjoon;
// Q1915: biggest square

import java.util.Scanner;

public class BiggestSquare{
	public static void mainSquare(String[] args){
		int m, n;
		int[][] arr;
		int max = 0;
		
		//get inputs
		Scanner scn = new Scanner(System.in);
		m = scn.nextInt();
		n = scn.nextInt();
		arr = new int[m][n];
		scn.nextLine();
		for(int i = 0; i < m; i++){
			String tmp = scn.nextLine();
			for(int j = 0; j < n; j++){
				arr[i][j] = Character.getNumericValue(tmp.charAt(j));
				if(i > 0 && j > 0 && arr[i][j] == 1)
					arr[i][j] = Math.min(arr[i-1][j], Math.min(arr[i-1][j-1], arr[i][j-1])) + 1;
				if(arr[i][j] > max)
					max = arr[i][j];
//				System.out.print(arr[i][j] + " ");
			}
//			System.out.println();
		}
		
		System.out.print(max*max);
		scn.close();
	}
}