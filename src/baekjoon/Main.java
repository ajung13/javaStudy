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
			//get inputs
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			input_num = new int[n];
			for(int i = 0; i < n; i++)
				input_num[i] = scn.nextInt();
			
			int[] op = new int[4];
			for(int i = 0; i < 4; i++){
				op[i] = scn.nextInt();
			}
			scn.close();
			
			//using input_operator array
			//for example, if op[] = {1, 2, 3, 4},
			//then input_op[] = {0, 1, 1, 2, 2, 2, 3, 3, 3, 3}
			input_op = new int[n-1];
			int idx = 0;
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < op[i]; j++){
					input_op[idx] = i;
					idx++;
				}
			}
			
			//initialize min and max
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
		}
		
		public int getMin(){
			return min;
		}
		public int getMax(){
			return max;
		}

		public void solution() {
			int size = n-1;
			Arrays.sort(input_op);		//this will be the first operators
			
			while(true){
				int i;
				
				//now input_op[] is the new operator array
				//we have to calculate using that operators
				int tmp = calculate(input_op);
				if(tmp > max)	max = tmp;
				if(tmp < min)	min = tmp;
				
				//then find another combination of operator array
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
		
		private int calculate(int[] op){
			//by using op[] and input_num[], calculate that formula
			int result = input_num[0];
			for(int i = 0; i < n-1; i++){
				result = operationHelper(result, input_num[i+1], op[i]);
			}
			return result;
		}
		
		private int operationHelper(int a, int b, int op){
			int result = 0;
			switch(op){
			case 0:	result = a+b;	break;
			case 1:	result = a-b;	break;
			case 2:	result = a*b;	break;
			case 3:	result = a/b;	break;
			}
			return result;			
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