package studyDFS;

import java.util.Scanner;

public class Cycle {
	private static class Numbers{
		private int n;
		private int[] arr;
		public Numbers(Scanner scn){
			this.n = scn.nextInt();
			this.arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = scn.nextInt();
		}
		
		public int findCycle(){
			boolean[] flag = new boolean[n];
			int cycle = 0;
			
			for(int i = 0; i < n; i++){
				if(flag[i])
					continue;
				flag[i] = true;
				cycle++;
				
				int tmp = arr[i] - 1;
				while(tmp != i){
					if(tmp < 0 || tmp >= n)	break;	//unexpected error
					flag[tmp] = true;
					tmp = arr[tmp] - 1;
				}
			}
			
			return cycle;
		}
	}

	public static void mainCycle(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testcase = scn.nextInt();
		Numbers input;
		
		for(; testcase > 0; testcase--){
			input = new Numbers(scn);
			System.out.println(input.findCycle());			
			input = null;
		}
		
		scn.close();
	}

}
