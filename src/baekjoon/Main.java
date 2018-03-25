package baekjoon;
// Q1931: Convention Hall

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
		
		boolean[] meetOK = new boolean[n];
		int end = 0;
		int meetCnt = 0;
		while(end < latestTime){
			//find the meeting which ends at the earlier time
			int min = -1;
			for(int idx = 0; idx < n; idx++){
				if(meetOK[idx] || meeting[idx][0] < end)
					continue;
				if(min == -1 || meeting[idx][1] < meeting[min][1])
					min = idx;
			}
			
			if(min < 0)
				break;
			
			meetCnt++;
			meetOK[min] = true;
			end = meeting[min][1];
		}
		
//		for(int i = 0; i < n; i++)
//			System.out.print(meetOK[i] + " ");
//		System.out.print("\nanswer: " + meetCnt);
		System.out.print(meetCnt);
	}
}