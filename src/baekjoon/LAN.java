package baekjoon;

import java.util.Scanner;

public class LAN {
	private static long n;
	private static int k;
	private static long[] input;
	
	public static void mainLAN(String[] args) {
		long output;
		
		Scanner scn = new Scanner(System.in);
		k = scn.nextInt();
		n = scn.nextInt();
		input = new long[k];
		for(int i=0; i<k; i++)
			input[i] = scn.nextInt();
		scn.close();
		
		output = solution();
		System.out.print(output);
		
		return;
	}

	private static long solution() {
		long output = 0;

		long initRight = input[0];
		for(int i=1; i<k; i++){
			if(initRight < input[i])
				initRight = input[i];
		}
/*		int initRight = 0;
		for(int i=0; i<k; i++)
			initRight += input[i];
		initRight = initRight/n;*/
		
		output = binarySearch(0, initRight);
		
		return output;
	}
	
	private static long binarySearch(long l, long r){
		if(l >= r){
			if(countLAN(l) < n)
				return l-1;
			return l;
		}
		long mid = (l+r+1)/2;
		long tmp = countLAN(mid);
//		System.out.println("l: " + l + ", r: " + r + ", tmp: " + tmp);
		if(tmp > n)
			return binarySearch(mid+1, r);
		else if(tmp == n){
			if(countLAN(mid+1) != n)
				return mid;
			else
				return binarySearch(mid+1, r);
		} 
		else
			return binarySearch(l, mid-1);
	}
	
	private static long countLAN(long mid){
		long cnt = 0;
		for(int i=0; i<k; i++){
			cnt += (long)(input[i]/mid);
		}
		return cnt;
	}
}
