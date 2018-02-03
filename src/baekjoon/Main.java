package baekjoon;

import java.util.Scanner;

public class Main{
	private static class nono{
		private long min, max;
		private boolean[] flag;
		private int length;
		public nono(){
			Scanner scn = new Scanner(System.in);
			min = scn.nextLong();
			max = scn.nextLong();
			scn.close();
			
			length = (int) (max-min+1);
			flag = new boolean[length];
		}
		
		public void setFlag(){
			// set the flag of i*i's multiples 'true'
			long idx = 2;
			for(; idx <= 1000000; idx++){
				if(idx*idx < min)	continue;
				if(idx*idx > max)	break;
				for(long j = idx*idx; j <= max; j += idx*idx){
					flag[(int) (j-min)] = true;
				}
			}
		}
		public int getCnt(){
			int cnt = 0;
			for(int i = 0; i < length; i++){
				if(!flag[i])	cnt++;
			}
			return cnt;
		}
	}
	public static void main(String[] args){
		nono solution = new nono();
		solution.setFlag();
		System.out.print(solution.getCnt());
	}
}