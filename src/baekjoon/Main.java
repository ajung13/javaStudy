package baekjoon;
// Q1931: Convention Hall

import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		int n;
		int[][] meeting;
		int latestTime = 0;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		meeting = new int[n][2];
		for(int i = 0; i < n; i++){
			meeting[i][0] = scn.nextInt();
			meeting[i][1] = scn.nextInt();
			if(meeting[i][1] > latestTime)
				latestTime = meeting[i][1];
		}
		scn.close();
		
		Arrays.sort(meeting, new java.util.Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return Integer.compare(a[1], b[1]);
			}
		});
		
//		boolean[] meetOK = new boolean[n];
		int end = 0;				//index
		int meetCnt = 0;
		while(meeting[end][1] < latestTime){
			//find the meeting which ends at the earlier time
			int min = end;
			for(int idx = end+1; idx < n; idx++){
//				if(meetOK[idx] || meeting[idx][0] < meeting[end][1])
				if(meeting[idx][0] < meeting[end][1])
					continue;
				if(min == -1 || meeting[idx][1] < meeting[min][1])
					min = idx;
			}
			
			if(min < 0)
				break;
			
			meetCnt++;
//			meetOK[min] = true;
			end = min;
		}
		
//		for(int i = 0; i < n; i++)
//			System.out.print(meetOK[i] + " ");
//		System.out.print("\nanswer: " + meetCnt);
		System.out.print(meetCnt);
	}
}