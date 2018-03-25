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
				if(a[1] != b[1])
					return Integer.compare(a[1], b[1]);
				else
					return Integer.compare(a[0], b[0]);
			}
		});
		
		int end = 0;				//index
		int meetCnt = 1;
		while(meeting[end][1] < latestTime){
			//find the meeting which ends at the earlier time
			int idx = end + 1;
			for(; idx < n; idx++){
				if(meeting[idx][0] >= meeting[end][1])
					break;
			}
			
			if(idx >= n)
				break;
			
			meetCnt++;
			end = idx;
		}
		
		System.out.print(meetCnt);
	}
}