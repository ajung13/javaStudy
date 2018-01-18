package baekjoon;

import java.util.Scanner;
import java.util.Arrays;

public class Main{
	private static class guguClass{
		private int n;
		private int[] input_num;
		private int[] input_op;
		private int min, max;
		
		public guguClass(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			input_num = new int[n];
			for(int i = 0; i < n; i++)
				input_num[i] = scn.nextInt();
			
			int[] op = new int[4];
			for(int i = 0; i < 4; i++){
				op[i] = scn.nextInt();
			}
			
			input_op = new int[n-1];
			int idx = 0;
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < op[i]; j++){
					input_op[idx] = i;
					idx++;
				}
			}
			
			scn.close();
		}
		
		public int getMin(){
			return min;
		}
		public int getMax(){
			return max;
		}

		public void solution() {
			int size = n-1;
			Arrays.sort(input_op);
			
			int cnt = 0;
			while(true){
				int i;
				System.out.print(cnt + ": ");
				for(i = 0; i < size; i++)
					System.out.print(input_op[i] + " ");
				System.out.println();
				
				for(i = size-2; i >= 0; --i){
					if(input_op[i] < input_op[i+1])
						break;
				}
				
				if(i == -1)
					break;
				else{
					int idx = findCeil(input_op[i], i+1, size-1);
					swapOp(i, idx);
					Arrays.sort(input_op, i+1, size);
				}
				
				cnt++;
			}
		}
		
		private int findCeil(int first, int l, int h) {
			int ceilIndex = l;
			
			for(int i = l+1; i <= h; i++){
				if(input_op[i] > first && input_op[i] < input_op[ceilIndex])
					ceilIndex = i;
			}
			return ceilIndex;
		}

		private void swapOp(int i, int j){
			int tmp = input_op[i];
			input_op[i] = input_op[j];
			input_op[j] = tmp;
		}
	}
	public static void main(String args[]){
		guguClass sol = new guguClass();
		
		sol.solution();
		
		System.out.println(sol.getMax());
		System.out.print(sol.getMin());
		
		return;
	}
}